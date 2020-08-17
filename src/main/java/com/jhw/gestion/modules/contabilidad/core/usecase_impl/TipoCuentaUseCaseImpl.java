package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;

public class TipoCuentaUseCaseImpl extends DefaultCRUDUseCase<TipoCuentaDomain> implements TipoCuentaUseCase {

    private final TipoCuentaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TipoCuentaRepo.class);

    public TipoCuentaUseCaseImpl() {
        super.setRepo(repo);
    }

}
