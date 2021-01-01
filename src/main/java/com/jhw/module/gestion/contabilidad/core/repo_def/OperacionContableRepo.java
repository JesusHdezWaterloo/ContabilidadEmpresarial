package com.jhw.module.gestion.contabilidad.core.repo_def;

import com.root101.clean.core.app.repo.CRUDRepository;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.module.gestion.contabilidad.core.domain.OperacionContableDomain;
import java.util.List;

public interface OperacionContableRepo extends CRUDRepository<OperacionContableDomain> {

    public List<OperacionContableDomain> findAll(CuentaContableDomain cuenta) throws Exception;

}
