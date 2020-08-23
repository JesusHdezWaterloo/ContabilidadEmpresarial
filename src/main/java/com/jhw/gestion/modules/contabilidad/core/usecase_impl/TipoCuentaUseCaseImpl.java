package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import java.util.ArrayList;
import java.util.List;

public class TipoCuentaUseCaseImpl extends DefaultCRUDUseCase<TipoCuentaDomain> implements TipoCuentaUseCase {

    private final TipoCuentaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TipoCuentaRepo.class);

    public TipoCuentaUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public List<TipoCuentaDomain> findAllCuadre(TipoCuentaDomain tipo) throws Exception {
        List<TipoCuentaDomain> tipos = findAll();
        List<TipoCuentaDomain> answ = new ArrayList<>(tipos.size());
        for (TipoCuentaDomain c : tipos) {
            if (c.getDebitoCredito() != tipo.getDebitoCredito() && c.isLiquidable()) {
                answ.add(c);
            }
        }
        return answ;
    }
}
