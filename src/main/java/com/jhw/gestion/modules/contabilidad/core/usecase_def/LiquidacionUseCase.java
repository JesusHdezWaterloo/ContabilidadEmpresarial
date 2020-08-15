package com.jhw.gestion.modules.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public interface LiquidacionUseCase extends CRUDUseCase<LiquidacionDomain> {

    public List<LiquidacionDomain> findAll(CuentaBancariaDomain cuenta) throws Exception;

}
