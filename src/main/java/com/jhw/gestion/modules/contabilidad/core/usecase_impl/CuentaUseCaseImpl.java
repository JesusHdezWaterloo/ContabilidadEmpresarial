package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.clean.core.domain.services.Resource;
import java.util.HashMap;
import java.util.List;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;

public class CuentaUseCaseImpl extends DefaultCRUDUseCase<CuentaDomain> implements CuentaUseCase {

    private final CuentaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(CuentaRepo.class);

    public CuentaUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public CuentaDomain destroy(CuentaDomain cuenta) throws Exception {
        if (cuenta.getCuentaBase()) {
            throw new RuntimeException(Resource.getString("msg.module.contabilidad.validation.destroy_cuenta_base"));
        } else {
            return super.destroy(cuenta);
        }
    }

    @Override
    public void destroyCuentaBase(MonedaDomain mon) throws Exception {
        repo.destroyCuentaBase(mon);
    }

    @Override
    public CuentaDomain findCuentaDepositoBase(MonedaDomain mon) throws Exception {
        return repo.findCuentaDepositoBase(mon);
    }

    @Override
    public List<CuentaDomain> findCuentasBase() throws Exception {
        return repo.findCuentasBase();
    }

    @Override
    public List<CuentaDomain> findCuentasHijoDelPadre(CuentaDomain padre) throws Exception {
        return repo.findCuentasHijoDelPadre(padre);
    }

    @Override
    public List<CuentaDomain> findCuentasPadresDelHijo(CuentaDomain hijo) throws Exception {
        return repo.findCuentasPadresDelHijo(hijo);
    }

    @Override
    public void updateFor(ExtraccionCuentaDomain extraccionCuenta, boolean create) throws Exception {
        CuentaDomain c = findBy(extraccionCuenta.getCuentaFk().getIdCuenta());
        double valor = c.getTotalExtracciones();
        valor += create ? extraccionCuenta.getValor() : -extraccionCuenta.getValor();//si estoy creando la extraccion lo sumo, sino lo resto
        c.setTotalExtracciones(valor);
        edit(c);
    }

    @Override
    public void updateFor(DepositoCuentaDomain dep, boolean create) throws Exception {
        CuentaDomain c = findBy(dep.getCuentaFk().getIdCuenta());
        double valor = c.getTotalDepositos();
        valor += create ? dep.getValor() : -dep.getValor();//si estoy creando el deposito lo sumo, sino lo resto
        c.setTotalDepositos(valor);
        edit(c);
    }

    @Override
    public void updateValues() throws Exception {
        checkCuentasBaseIntegrity();
        HashMap<Integer, CuentaDomain> map = new HashMap<>();
        for (CuentaDomain c : findAll()) {
            c.setTotalExtracciones(0d);
            c.setTotalDepositos(0d);
            map.put(c.getIdCuenta(), c);
        }

        for (ExtraccionCuentaDomain ext : ContabilidadCoreModule.getInstance().getImplementation(ExtraccionCuentaRepo.class).findAll()) {
            CuentaDomain c = map.get(ext.getCuentaFk().getIdCuenta());
            double valor = c.getTotalExtracciones() + ext.getValor();
            c.setTotalExtracciones(valor);
            map.put(c.getIdCuenta(), c);
        }

        for (DepositoCuentaDomain dep : ContabilidadCoreModule.getInstance().getImplementation(DepositoCuentaRepo.class).findAll()) {
            CuentaDomain c = map.get(dep.getCuentaFk().getIdCuenta());
            double valor = c.getTotalDepositos() + dep.getValor();
            c.setTotalDepositos(valor);
            map.put(c.getIdCuenta(), c);
        }
        for (CuentaDomain cuenta : map.values()) {
            edit(cuenta);
        }
    }

    @Override
    public void checkCuentasBaseIntegrity() throws Exception {
        List<CuentaDomain> base = repo.findCuentasBase();
        int baseCount = base.size();

        MonedaRepo monedaRepo = ContabilidadCoreModule.getInstance().getImplementation(MonedaRepo.class);
        int monCount = monedaRepo.count();

        if (monCount > baseCount) {//faltan cuentas base
            List<MonedaDomain> monedas = monedaRepo.findAll();
            for (MonedaDomain mon : monedas) {
                CuentaDomain baseAct = repo.findCuentaDepositoBase(mon);
                if (baseAct == null) {
                    create(new CuentaDomain("Banco " + mon.getTipoMoneda(), 100f, 0d, 0d, "0000111122223333", "1234",
                            "Cuenta base para los depósitos en moneda " + mon.getTipoMoneda(),
                            true, mon));
                }
            }
        } else if (monCount > baseCount) {//sobram cuentas base
            for (CuentaDomain c : base) {
                try {
                    MonedaDomain mon = monedaRepo.findBy(c.getMonedaFk());
                    if (mon == null) {
                        throw new NullPointerException("Esta Cuenta sobra");
                    }
                } catch (Exception e) {
                    try {
                        destroy(c);
                    } catch (Exception ex) {
                        System.out.println("NO SE PUEDE ELIMINAR cuenta.");
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}
