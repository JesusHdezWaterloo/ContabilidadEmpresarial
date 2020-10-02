package com.jhw.module.gestion.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.Cuenta;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaBancariaDomain;
import com.jhw.module.gestion.contabilidad.core.domain.MonedaDomain;
import java.util.List;

public interface CuentaBancariaUseCase extends CRUDUseCase<CuentaBancariaDomain> {

    public List<Cuenta> findAllCuentas() throws Exception;

    public CuentaBancariaDomain findCuentaDefault(MonedaDomain moneda) throws Exception;

    public List<CuentaBancariaDomain> findAll(String searchText) throws Exception;
}
