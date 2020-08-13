package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.old.TipoDepositoDomain;
import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;

public class TipoDepositoUseCaseImpl extends DefaultCRUDUseCase<TipoDepositoDomain> implements TipoDepositoUseCase {

    public static final TipoDepositoDomain PAGO_TRABAJO = new TipoDepositoDomain(1);

    private final TipoDepositoRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TipoDepositoRepo.class);

    public TipoDepositoUseCaseImpl() {
        super.setRepo(repo);
    }
}
