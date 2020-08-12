package com.jhw.gestion.modules.contabilidad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public interface CuentaRepo extends CRUDRepository<CuentaDomain> {

    public CuentaDomain findCuentaDepositoBase(MonedaDomain mon) throws Exception;

    public void destroyCuentaBase(MonedaDomain mon) throws Exception;

    public List<CuentaDomain> findCuentasBase() throws Exception;

    public List<CuentaDomain> findCuentasHijoDelPadre(CuentaDomain padre);

    public List<CuentaDomain> findCuentasPadresDelHijo(CuentaDomain hijo);

    public void updateValues() throws Exception;

    public void checkCuentasBaseIntegrity() throws Exception;
}
