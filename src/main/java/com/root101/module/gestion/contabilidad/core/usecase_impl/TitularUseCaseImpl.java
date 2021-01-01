package com.root101.module.gestion.contabilidad.core.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.module.gestion.contabilidad.core.domain.TitularDomain;
import com.root101.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.root101.module.gestion.contabilidad.core.repo_def.TitularRepo;
import com.root101.module.gestion.contabilidad.core.usecase_def.TitularUseCase;

public class TitularUseCaseImpl extends DefaultCRUDUseCase<TitularDomain> implements TitularUseCase {

    private final TitularRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TitularRepo.class);

    public TitularUseCaseImpl() {
        super.setRepo(repo);
    }

}
