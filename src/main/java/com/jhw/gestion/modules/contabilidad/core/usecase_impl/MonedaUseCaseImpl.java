package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import java.util.Collections;
import java.util.List;

public class MonedaUseCaseImpl extends DefaultCRUDUseCase<MonedaDomain> implements MonedaUseCase {

    private final MonedaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(MonedaRepo.class);

    public MonedaUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public MonedaDomain findMonedaBase() throws Exception {
        List<MonedaDomain> mon = findAll();
        Collections.sort(mon, (a, b) -> {
            return Integer.compare(a.getIdMoneda(), b.getIdMoneda());
        });
        if (mon.isEmpty()) {
            return null;
        }
        return mon.get(0);
    }
}
