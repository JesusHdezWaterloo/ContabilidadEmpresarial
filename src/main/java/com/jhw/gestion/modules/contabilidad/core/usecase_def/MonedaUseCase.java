package com.jhw.gestion.modules.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;

public interface MonedaUseCase extends CRUDUseCase<MonedaDomain> {

    public MonedaDomain findMonedaBase() throws Exception;
}
