package com.jhw.gestion.modules.contabilidad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.gestion.modules.contabilidad.core.domain.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.ExtraccionCuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.TipoExtraccionDomain;
import java.util.List;

public interface ExtraccionCuentaRepo extends CRUDRepository<ExtraccionCuentaDomain> {

    public List<ExtraccionCuentaDomain> findExtraccionesOfCuenta(CuentaDomain cuenta) throws Exception;

    public List<ExtraccionCuentaDomain> findExtraccionList(TipoExtraccionDomain tipo, Integer idExterno) throws Exception;

    public ExtraccionCuentaDomain findExtraccionSingle(TipoExtraccionDomain tipo, Integer idExterno) throws Exception;
}
