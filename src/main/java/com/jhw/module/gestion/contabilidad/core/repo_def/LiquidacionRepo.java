package com.jhw.module.gestion.contabilidad.core.repo_def;

import com.root101.clean.core.app.repo.CRUDRepository;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaBancariaDomain;
import com.jhw.module.gestion.contabilidad.core.domain.LiquidacionDomain;
import java.util.List;

public interface LiquidacionRepo extends CRUDRepository<LiquidacionDomain> {

    public List<LiquidacionDomain> findAll(CuentaBancariaDomain cuenta) throws Exception;

}
