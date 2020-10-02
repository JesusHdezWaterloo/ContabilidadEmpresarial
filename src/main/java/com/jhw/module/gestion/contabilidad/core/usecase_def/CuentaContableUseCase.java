package com.jhw.module.gestion.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.Cuenta;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.module.gestion.contabilidad.core.domain.TipoCuentaDomain;
import java.util.List;

public interface CuentaContableUseCase extends CRUDUseCase<CuentaContableDomain> {

    public List<Cuenta> findAllCuentas() throws Exception;

    public List<CuentaContableDomain> findAllCuenta(TipoCuentaDomain tipo) throws Exception;

    public List<CuentaContableDomain> findAllCuadre(TipoCuentaDomain tipo) throws Exception;

    public List<CuentaContableDomain> findAll(String text) throws Exception;

}
