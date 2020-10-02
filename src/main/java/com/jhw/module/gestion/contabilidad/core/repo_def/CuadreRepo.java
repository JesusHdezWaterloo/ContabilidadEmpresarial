package com.jhw.module.gestion.contabilidad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.module.gestion.contabilidad.core.domain.CuadreDomain;
import java.util.List;

public interface CuadreRepo extends CRUDRepository<CuadreDomain> {

    public List<CuadreDomain> findAllPending() throws Exception;

    public List<CuadreDomain> findByLiquidada(boolean liquidada) throws Exception;

    public List<CuadreDomain> findAllLiquidadas() throws Exception;

}
