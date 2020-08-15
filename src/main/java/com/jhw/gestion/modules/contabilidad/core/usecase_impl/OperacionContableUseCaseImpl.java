package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import java.util.List;

public class OperacionContableUseCaseImpl extends DefaultCRUDUseCase<OperacionContableDomain> implements OperacionContableUseCase {

    private final OperacionContableRepo repo = ContabilidadCoreModule.getInstance().getImplementation(OperacionContableRepo.class);

    public OperacionContableUseCaseImpl() {
        super.setRepo(repo);
    }

    public List<OperacionContableDomain> findAll(CuentaContableDomain cuenta) throws Exception {
        return repo.findAll(cuenta);
    }

}
