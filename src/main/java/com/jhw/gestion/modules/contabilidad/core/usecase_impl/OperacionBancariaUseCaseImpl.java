package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;

public class OperacionBancariaUseCaseImpl extends DefaultCRUDUseCase<OperacionBancariaDomain> implements OperacionBancariaUseCase {

    private final OperacionBancariaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(OperacionBancariaRepo.class);

    public OperacionBancariaUseCaseImpl() {
        super.setRepo(repo);
    }

}
