package com.jhw.module.gestion.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.clean.core.utils.Licenced;
import com.jhw.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaBancariaDomain;
import com.jhw.module.gestion.contabilidad.core.domain.LiquidacionDomain;
import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.repo_def.LiquidacionRepo;
import com.jhw.module.gestion.contabilidad.core.usecase_def.CuadreUseCase;
import com.jhw.module.gestion.contabilidad.core.usecase_def.CuentaBancariaUseCase;
import com.jhw.module.gestion.contabilidad.core.usecase_def.LiquidacionUseCase;
import com.jhw.module.gestion.contabilidad.utils.MonedaHandler;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class LiquidacionUseCaseImpl extends DefaultCRUDUseCase<LiquidacionDomain> implements LiquidacionUseCase {

    private final LiquidacionRepo repo = ContabilidadCoreModule.getInstance().getImplementation(LiquidacionRepo.class);

    private final CuentaBancariaUseCase cuentaUC = ContabilidadCoreModule.getInstance().getImplementation(CuentaBancariaUseCase.class);

    public LiquidacionUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    @Licenced
    public LiquidacionDomain create(LiquidacionDomain newObject) throws Exception {
        if (newObject.getCuadreFk().getLiquidada()) {
            throw new RuntimeException("No se puede liquidar dos veces el mismo cuadre");
        }
        if (!newObject.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk().getTipoCuentaFk().isLiquidable()) {
            throw new RuntimeException("No se puede liquidar un cuadre de una cuenta que no es liquidable.");
        }

        //convierto a la moneda e incremento banco
        BigDecimal debito = MonedaHandler.venta(newObject.getCuadreFk().getOperacionContableCuadreFk().getDebito(), newObject.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk().getMonedaFk(), newObject.getCuentaFk().getMonedaFk());
        newObject.setDebito(debito);
        BigDecimal credito = MonedaHandler.venta(newObject.getCuadreFk().getOperacionContableCuadreFk().getCredito(), newObject.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk().getMonedaFk(), newObject.getCuentaFk().getMonedaFk());
        newObject.setCredito(credito);

        //si se crea una liquidacion se le quita esa cantidad a la cuenta, por eso el decrease al deb-cred
        newObject.getCuentaFk().increase(newObject);

        //rebajo la cuenta contable
        newObject.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk().decrease(newObject.getCuadreFk().getOperacionContableCuadreFk());

        newObject.getCuadreFk().setLiquidada(true);

        return super.create(newObject);
    }

    @Override
    @Licenced
    public LiquidacionDomain edit(LiquidacionDomain objectToUpdate) throws Exception {
        LiquidacionDomain original = findBy(objectToUpdate.getIdLiquidacion());
        objectToUpdate.setDebito(original.getDebito());
        objectToUpdate.setCredito(original.getCredito());
        objectToUpdate.setCuadreFk(original.getCuadreFk());
        return objectToUpdate;
    }

    @Override
    @Licenced
    public LiquidacionDomain destroy(LiquidacionDomain objectToDestroy) throws Exception {
        objectToDestroy.getCuadreFk().setLiquidada(false);
        //si se elimina una liquidacion se le agrega esa cantidad a la cuenta, por eso el increase al deb-cred
        objectToDestroy.getCuentaFk().decrease(objectToDestroy);

        objectToDestroy.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk().increase(objectToDestroy.getCuadreFk().getOperacionContableCuadreFk());

        return super.destroy(objectToDestroy);
    }

    @Override
    @Licenced
    public LiquidacionDomain destroyById(Object keyId) throws Exception {
        throw new RuntimeException("No se puede eliminar directamente una liquidación.\nTiene que corregirse también el cuadre asociado");
    }

    @Override
    public LiquidacionDomain getLiquidacion(CuadreDomain cuadre) throws Exception {
        return new LiquidacionDomain(
                cuadre.info().getDocumento(),
                cuadre.info().getNombre(),
                cuadre.getOperacionContableCuadreFk().getDebito(),
                cuadre.getOperacionContableCuadreFk().getCredito(),
                LocalDate.now(),
                cuadre.info().getDescripcion(),
                cuentaUC.findCuentaDefault(cuadre.getOperacionContableCuadreFk().getCuentaFk().getMonedaFk()),
                cuadre);
    }

    /**
     * Delegate de getLiquidacion(CuadreDomain cuadre)
     *
     * @param idCuadre
     * @return
     * @throws Exception
     */
    @Override
    public LiquidacionDomain getLiquidacion(Integer idCuadre) throws Exception {
        return getLiquidacion(ContabilidadCoreModule.getInstance().getImplementation(CuadreUseCase.class).findBy(idCuadre));
    }

    @Override
    public List<LiquidacionDomain> findAll(CuentaBancariaDomain cuenta) throws Exception {
        return repo.findAll(cuenta);
    }

    /**
     * Delegate de findAll(CuentaBancariaDomain cuenta)
     *
     * @param IdCuentaBancaria
     * @return
     * @throws Exception
     */
    @Override
    public List<LiquidacionDomain> findAll(Integer IdCuentaBancaria) throws Exception {
        return findAll(ContabilidadCoreModule.getInstance().getImplementation(CuentaBancariaUseCase.class).findBy(IdCuentaBancaria));
    }
}
