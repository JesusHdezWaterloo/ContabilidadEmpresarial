package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;

public class CuentaBancariaUseCaseImpl extends DefaultCRUDUseCase<CuentaBancariaDomain> implements CuentaBancariaUseCase {

    private final CuentaBancariaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(CuentaBancariaRepo.class);

    public CuentaBancariaUseCaseImpl() {
        super.setRepo(repo);
    }

}
