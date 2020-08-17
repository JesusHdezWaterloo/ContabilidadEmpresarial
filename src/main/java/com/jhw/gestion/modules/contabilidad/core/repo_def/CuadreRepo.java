package com.jhw.gestion.modules.contabilidad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public interface CuadreRepo extends CRUDRepository<CuadreDomain> {

    public List<CuadreDomain> findAllPending() throws Exception;

    public List<CuadreDomain> findByLiquidada(boolean liquidada) throws Exception;

    public List<CuadreDomain> findAllLiquidadas() throws Exception;

}
