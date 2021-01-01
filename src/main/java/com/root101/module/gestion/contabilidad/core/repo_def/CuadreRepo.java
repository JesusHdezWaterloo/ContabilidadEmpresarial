package com.root101.module.gestion.contabilidad.core.repo_def;

import com.root101.clean.core.app.repo.CRUDRepository;
import com.root101.module.gestion.contabilidad.core.domain.CuadreDomain;
import java.util.List;

public interface CuadreRepo extends CRUDRepository<CuadreDomain> {

    public List<CuadreDomain> findAllPending() throws Exception;

    public List<CuadreDomain> findByLiquidada(boolean liquidada) throws Exception;

    public List<CuadreDomain> findAllLiquidadas() throws Exception;

}
