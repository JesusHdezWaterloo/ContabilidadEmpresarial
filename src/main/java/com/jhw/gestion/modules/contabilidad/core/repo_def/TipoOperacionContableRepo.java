package com.jhw.gestion.modules.contabilidad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.gestion.modules.contabilidad.core.domain.*;

public interface TipoOperacionContableRepo extends CRUDRepository<TipoOperacionContableDomain> {

    public TipoOperacionContableDomain findByKey(String key) throws Exception;
}
