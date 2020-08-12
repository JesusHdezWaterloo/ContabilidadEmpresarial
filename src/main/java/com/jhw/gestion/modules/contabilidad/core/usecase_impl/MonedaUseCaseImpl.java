package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import java.util.List;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import java.util.Collections;

public class MonedaUseCaseImpl extends DefaultCRUDUseCase<MonedaDomain> implements MonedaUseCase {

    private final MonedaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(MonedaRepo.class);

    public MonedaUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public MonedaDomain create(MonedaDomain moneda) throws Exception {
        moneda.setTipoMoneda(moneda.getTipoMoneda().toUpperCase());
        CuentaDomain cuenta = new CuentaDomain("Banco " + moneda.getTipoMoneda(), 100f, 0d, 0d, "0000111122223333", "1234",
                "Cuenta base para los depósitos en moneda " + moneda.getTipoMoneda(),
                true, moneda);
        return repo.create(moneda, cuenta).getA();//creo la cuenta con la moneda adentro y se crean los dos
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
