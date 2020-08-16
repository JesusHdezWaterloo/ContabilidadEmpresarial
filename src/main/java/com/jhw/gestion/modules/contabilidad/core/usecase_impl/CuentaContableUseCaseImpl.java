package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaContableUseCaseImpl extends DefaultCRUDUseCase<CuentaContableDomain> implements CuentaContableUseCase {

    private final CuentaContableRepo repo = ContabilidadCoreModule.getInstance().getImplementation(CuentaContableRepo.class);

    public CuentaContableUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public List<Cuenta> findAllCuentas() throws Exception {
        List<CuentaContableDomain> cuentasContables = findAll();
        List<Cuenta> cuentas = new ArrayList<>(cuentasContables.size());
        for (CuentaContableDomain c : cuentasContables) {
            cuentas.add(c);
        }
        return cuentas;
    }
}
