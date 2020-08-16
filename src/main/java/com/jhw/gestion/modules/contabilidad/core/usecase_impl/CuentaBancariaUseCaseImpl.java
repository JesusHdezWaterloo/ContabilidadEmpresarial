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
