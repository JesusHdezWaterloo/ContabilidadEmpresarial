package com.jhw.module.gestion.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.SubcuentaDomain;
import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.repo_def.SubcuentaRepo;
import com.jhw.module.gestion.contabilidad.core.usecase_def.SubcuentaUseCase;

public class SubcuentaUseCaseImpl extends DefaultCRUDUseCase<SubcuentaDomain> implements SubcuentaUseCase {

    private final SubcuentaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(SubcuentaRepo.class);

    public SubcuentaUseCaseImpl() {
        super.setRepo(repo);
    }

}
