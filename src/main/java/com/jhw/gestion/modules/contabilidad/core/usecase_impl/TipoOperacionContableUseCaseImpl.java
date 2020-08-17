package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;

public class TipoOperacionContableUseCaseImpl extends DefaultCRUDUseCase<TipoOperacionContableDomain> implements TipoOperacionContableUseCase {

    private final TipoOperacionContableRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TipoOperacionContableRepo.class);

    public TipoOperacionContableUseCaseImpl() {
        super.setRepo(repo);
    }

}
