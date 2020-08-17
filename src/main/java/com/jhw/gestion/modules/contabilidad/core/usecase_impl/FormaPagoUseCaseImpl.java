package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;

public class FormaPagoUseCaseImpl extends DefaultCRUDUseCase<FormaPagoDomain> implements FormaPagoUseCase {

    private final FormaPagoRepo repo = ContabilidadCoreModule.getInstance().getImplementation(FormaPagoRepo.class);

    public FormaPagoUseCaseImpl() {
        super.setRepo(repo);
    }

}
