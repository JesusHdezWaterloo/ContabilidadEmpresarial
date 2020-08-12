package com.jhw.gestion.modules.contabilidad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.gestion.modules.contabilidad.core.domain.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.utils.others.PairDifferent;

public interface MonedaRepo extends CRUDRepository<MonedaDomain> {

    public PairDifferent<MonedaDomain, CuentaDomain> create(MonedaDomain moneda, CuentaDomain cuenta) throws Exception;

    public PairDifferent<MonedaDomain, CuentaDomain> destroy(MonedaDomain moneda, CuentaDomain cuenta) throws Exception;

}
