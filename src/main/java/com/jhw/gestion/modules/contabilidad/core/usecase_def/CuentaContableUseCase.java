package com.jhw.gestion.modules.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public interface CuentaContableUseCase extends CRUDUseCase<CuentaContableDomain> {

    public List<Cuenta> findAllCuentas() throws Exception;

    public List<CuentaContableDomain> findAllCuadre(TipoCuentaDomain tipo) throws Exception;
}
