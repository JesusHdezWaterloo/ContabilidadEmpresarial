package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;

public class InfoOperacionContableUseCaseImpl extends DefaultCRUDUseCase<InfoOperacionContableDomain> implements InfoOperacionContableUseCase {

    private final InfoOperacionContableRepo repo = ContabilidadCoreModule.getInstance().getImplementation(InfoOperacionContableRepo.class);

    public InfoOperacionContableUseCaseImpl() {
        super.setRepo(repo);
    }

}
