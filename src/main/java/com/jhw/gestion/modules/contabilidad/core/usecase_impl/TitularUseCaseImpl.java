package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;

public class TitularUseCaseImpl extends DefaultCRUDUseCase<TitularDomain> implements TitularUseCase {

    private final TitularRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TitularRepo.class);

    public TitularUseCaseImpl() {
        super.setRepo(repo);
    }

}
