package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import java.util.Date;
import java.util.List;

public class LiquidacionUseCaseImpl extends DefaultCRUDUseCase<LiquidacionDomain> implements LiquidacionUseCase {

    private final LiquidacionRepo repo = ContabilidadCoreModule.getInstance().getImplementation(LiquidacionRepo.class);

    private final CuentaBancariaUseCase cuentaUC = ContabilidadCoreModule.getInstance().getImplementation(CuentaBancariaUseCase.class);

    public LiquidacionUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public LiquidacionDomain create(LiquidacionDomain newObject) throws Exception {
        if (newObject.getCuadreFk().getLiquidada()) {
            throw new RuntimeException("No se puede liquidar dos veces el mismo cuadre");
        }
        if (!newObject.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk().getTipoCuentaFk().isLiquidable()) {
            throw new RuntimeException("No se puede liquidar un cuadre de una cuenta que no es liquidable.");
        }
        newObject.setDebito(newObject.getCuadreFk().getOperacionContableCuadreFk().getDebito());
        newObject.setCredito(newObject.getCuadreFk().getOperacionContableCuadreFk().getCredito());
        newObject.getCuadreFk().setLiquidada(true);
        newObject.getCuentaFk().updateForCreate(newObject);
        newObject.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk().updateForCreate(newObject);
        return super.create(newObject);
    }

    @Override
    public LiquidacionDomain destroy(LiquidacionDomain objectToDestroy) throws Exception {
        objectToDestroy.getCuadreFk().setLiquidada(false);
        objectToDestroy.getCuentaFk().updateForDestroy(objectToDestroy);
        objectToDestroy.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk().updateForDestroy(objectToDestroy);
        return super.destroy(objectToDestroy);
    }

    @Override
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
                new Date(),
                cuadre.info().getDescripcion(),
                cuentaUC.findCuentaDefault(cuadre.getOperacionContableCuadreFk().getCuentaFk().getMonedaFk()),
                cuadre);
    }

    @Override
    public List<LiquidacionDomain> findAll(CuentaBancariaDomain cuenta) throws Exception {
        return repo.findAll(cuenta);
    }

    @Override
    public LiquidacionDomain edit(LiquidacionDomain objectToUpdate) throws Exception {
        LiquidacionDomain original = findBy(objectToUpdate.getIdLiquidacion());
        objectToUpdate.setDebito(original.getDebito());
        objectToUpdate.setCredito(original.getCredito());
        objectToUpdate.setCuadreFk(original.getCuadreFk());
        return objectToUpdate;
    }

}
