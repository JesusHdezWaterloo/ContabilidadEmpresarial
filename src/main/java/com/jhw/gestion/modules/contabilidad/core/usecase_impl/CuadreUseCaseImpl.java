package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import java.util.List;

public class CuadreUseCaseImpl extends DefaultCRUDUseCase<CuadreDomain> implements CuadreUseCase {

    private final CuadreRepo repo = ContabilidadCoreModule.getInstance().getImplementation(CuadreRepo.class);

    public CuadreUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public List<CuadreDomain> findAllPending() throws Exception {
        return repo.findAllPending();
    }

    @Override
    public List<CuadreDomain> findByLiquidada(boolean liquidada) throws Exception {
        return repo.findByLiquidada(liquidada);
    }

    @Override
    public List<CuadreDomain> findAllLiquidadas() throws Exception {
        return repo.findAllLiquidadas();
    }

}
