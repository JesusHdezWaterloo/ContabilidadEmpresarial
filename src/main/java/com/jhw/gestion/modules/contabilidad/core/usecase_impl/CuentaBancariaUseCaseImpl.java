package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancariaUseCaseImpl extends DefaultCRUDUseCase<CuentaBancariaDomain> implements CuentaBancariaUseCase {

    private final CuentaBancariaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(CuentaBancariaRepo.class);

    public CuentaBancariaUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public List<CuentaBancariaDomain> findAll(String searchText) throws Exception {
        List<CuentaBancariaDomain> cuentasBancarias = findAll();
        List<CuentaBancariaDomain> cuentas = new ArrayList<>();
        for (CuentaBancariaDomain c : cuentasBancarias) {
            if (c.test(searchText)) {
                cuentas.add(c);
            }
        }
        return cuentas;
    }

    @Override
    public CuentaBancariaDomain findCuentaDefault(MonedaDomain moneda) throws Exception {
        List<CuentaBancariaDomain> all = findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("No hay ninguna cuenta bancaria creada.");
        }
        for (CuentaBancariaDomain c : all) {
            if (c.getMonedaFk().equals(moneda)) {
                return c;
            }
        }
        return all.get(0);
    }

    @Override
    public CuentaBancariaDomain create(CuentaBancariaDomain cuenta) throws Exception {
        cuenta.setDebito(0);
        cuenta.setCredito(0);
        return super.create(cuenta);
    }

    @Override
    public List<Cuenta> findAllCuentas() throws Exception {
        List<CuentaBancariaDomain> cuentasBancarias = findAll();
        List<Cuenta> cuentas = new ArrayList<>(cuentasBancarias.size());
        for (CuentaBancariaDomain c : cuentasBancarias) {
            cuentas.add(c);
        }
        return cuentas;
    }
}
