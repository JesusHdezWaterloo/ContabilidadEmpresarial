package com.jhw.gestion.modules.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public interface CuentaBancariaUseCase extends CRUDUseCase<CuentaBancariaDomain> {

    public List<Cuenta> findAllCuentas() throws Exception;

    public CuentaBancariaDomain findCuentaDefault(MonedaDomain moneda) throws Exception;
}
