package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.old.MetodoPagoDomain;
import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;

public class MetodoPagoUseCaseImpl extends DefaultCRUDUseCase<MetodoPagoDomain> implements MetodoPagoUseCase {

    private final MetodoPagoRepo repo = ContabilidadCoreModule.getInstance().getImplementation(MetodoPagoRepo.class);

    public MetodoPagoUseCaseImpl() {
        super.setRepo(repo);
    }
}
