package com.jhw.gestion.modules.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.ExtraccionCuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.TipoExtraccionDomain;
import java.util.List;

public interface ExtraccionCuentaUseCase extends CRUDUseCase<ExtraccionCuentaDomain> {

    public List<ExtraccionCuentaDomain> findExtraccionList(TipoExtraccionDomain tipo, Integer idExterno) throws Exception;

    public ExtraccionCuentaDomain findExtraccionSingle(TipoExtraccionDomain tipo, Integer idExterno) throws Exception;

    public List<ExtraccionCuentaDomain> findExtraccionesOfCuenta(CuentaDomain cuenta) throws Exception;

}
