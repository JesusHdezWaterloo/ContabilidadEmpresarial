package com.jhw.gestion.modules.contabilidad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public interface OperacionContableRepo extends CRUDRepository<OperacionContableDomain> {

    public List<OperacionContableDomain> findAll(CuentaContableDomain cuenta) throws Exception;

}
