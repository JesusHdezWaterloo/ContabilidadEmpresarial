package com.jhw.gestion.modules.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;

public interface TipoOperacionContableUseCase extends CRUDUseCase<TipoOperacionContableDomain> {

    public TipoOperacionContableDomain findByKey(String key);
}
