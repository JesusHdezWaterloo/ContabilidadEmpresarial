package com.jhw.module.gestion.contabilidad.core.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.FormaPagoDomain;
import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.repo_def.FormaPagoRepo;
import com.jhw.module.gestion.contabilidad.core.usecase_def.FormaPagoUseCase;

public class FormaPagoUseCaseImpl extends DefaultCRUDUseCase<FormaPagoDomain> implements FormaPagoUseCase {

    private final FormaPagoRepo repo = ContabilidadCoreModule.getInstance().getImplementation(FormaPagoRepo.class);

    public FormaPagoUseCaseImpl() {
        super.setRepo(repo);
    }

}
