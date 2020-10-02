package com.jhw.module.gestion.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.TitularDomain;
import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.repo_def.TitularRepo;
import com.jhw.module.gestion.contabilidad.core.usecase_def.TitularUseCase;

public class TitularUseCaseImpl extends DefaultCRUDUseCase<TitularDomain> implements TitularUseCase {

    private final TitularRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TitularRepo.class);

    public TitularUseCaseImpl() {
        super.setRepo(repo);
    }

}
