package com.jhw.module.gestion.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.InfoOperacionContableDomain;
import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.repo_def.InfoOperacionContableRepo;
import com.jhw.module.gestion.contabilidad.core.usecase_def.InfoOperacionContableUseCase;

public class InfoOperacionContableUseCaseImpl extends DefaultCRUDUseCase<InfoOperacionContableDomain> implements InfoOperacionContableUseCase {

    private final InfoOperacionContableRepo repo = ContabilidadCoreModule.getInstance().getImplementation(InfoOperacionContableRepo.class);

    public InfoOperacionContableUseCaseImpl() {
        super.setRepo(repo);
    }

}
