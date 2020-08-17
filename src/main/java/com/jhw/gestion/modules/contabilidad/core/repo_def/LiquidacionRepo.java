package com.jhw.gestion.modules.contabilidad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public interface LiquidacionRepo extends CRUDRepository<LiquidacionDomain> {

    public List<LiquidacionDomain> findAll(CuentaBancariaDomain cuenta) throws Exception;

}
