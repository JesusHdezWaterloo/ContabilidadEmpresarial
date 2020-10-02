package com.jhw.module.gestion.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.TipoOperacionContableDomain;

public interface TipoOperacionContableUseCase extends CRUDUseCase<TipoOperacionContableDomain> {

    public TipoOperacionContableDomain findByKey(String key);
}
