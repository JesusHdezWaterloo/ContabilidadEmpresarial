package com.jhw.module.gestion.contabilidad.core.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.TipoOperacionContableDomain;
import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.repo_def.TipoOperacionContableRepo;
import com.jhw.module.gestion.contabilidad.core.usecase_def.TipoOperacionContableUseCase;

public class TipoOperacionContableUseCaseImpl extends DefaultCRUDUseCase<TipoOperacionContableDomain> implements TipoOperacionContableUseCase {

    private final TipoOperacionContableRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TipoOperacionContableRepo.class);

    public TipoOperacionContableUseCaseImpl() {
        super.setRepo(repo);
    }

}
