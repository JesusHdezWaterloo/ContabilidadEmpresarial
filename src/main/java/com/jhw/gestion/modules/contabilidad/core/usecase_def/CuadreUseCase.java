package com.jhw.gestion.modules.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public interface CuadreUseCase extends CRUDUseCase<CuadreDomain> {

    public List<CuadreDomain> findAllPending() throws Exception;

    public List<CuadreDomain> findAllLiquidadas() throws Exception;

    public List<CuadreDomain> findByLiquidada(boolean liquidada) throws Exception;

}
