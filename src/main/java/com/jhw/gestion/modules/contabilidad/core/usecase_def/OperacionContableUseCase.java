package com.jhw.gestion.modules.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public interface OperacionContableUseCase extends CRUDUseCase<OperacionContableDomain> {

    public List<OperacionContableDomain> findAll(CuentaContableDomain cuenta) throws Exception;

}
