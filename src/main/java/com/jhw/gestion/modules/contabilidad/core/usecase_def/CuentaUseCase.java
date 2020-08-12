package com.jhw.gestion.modules.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public interface CuentaUseCase extends CRUDUseCase<CuentaDomain> {

    public void destroyCuentaBase(MonedaDomain mon) throws Exception;

    public CuentaDomain findCuentaDepositoBase(MonedaDomain mon) throws Exception;

    public List<CuentaDomain> findCuentasBase() throws Exception;

    public List<CuentaDomain> findCuentasHijoDelPadre(CuentaDomain padre) throws Exception;

    public List<CuentaDomain> findCuentasPadresDelHijo(CuentaDomain hijo) throws Exception;

    public void updateFor(ExtraccionCuentaDomain extraccionCuenta, boolean create) throws Exception;

    public void updateFor(DepositoCuentaDomain dep, boolean create) throws Exception;

    public void updateValues() throws Exception;

    public void checkCuentasBaseIntegrity() throws Exception;
}
