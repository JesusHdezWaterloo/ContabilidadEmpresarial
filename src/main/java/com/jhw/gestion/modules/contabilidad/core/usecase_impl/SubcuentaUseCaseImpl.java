package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;

public class SubcuentaUseCaseImpl extends DefaultCRUDUseCase<SubcuentaDomain> implements SubcuentaUseCase {

    private final SubcuentaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(SubcuentaRepo.class);

    public SubcuentaUseCaseImpl() {
        super.setRepo(repo);
    }

}
