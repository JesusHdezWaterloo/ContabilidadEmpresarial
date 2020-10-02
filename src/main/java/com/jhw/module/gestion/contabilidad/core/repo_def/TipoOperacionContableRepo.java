package com.jhw.module.gestion.contabilidad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.module.gestion.contabilidad.core.domain.TipoOperacionContableDomain;

public interface TipoOperacionContableRepo extends CRUDRepository<TipoOperacionContableDomain> {

    public TipoOperacionContableDomain findByKey(String key) throws Exception;
}
