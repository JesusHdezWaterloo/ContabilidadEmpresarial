package com.jhw.module.gestion.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaBancariaDomain;
import com.jhw.module.gestion.contabilidad.core.domain.LiquidacionDomain;
import java.util.List;

public interface LiquidacionUseCase extends CRUDUseCase<LiquidacionDomain> {

    public List<LiquidacionDomain> findAll(CuentaBancariaDomain cuenta) throws Exception;

    public LiquidacionDomain getLiquidacion(CuadreDomain cuadre) throws Exception;
}
