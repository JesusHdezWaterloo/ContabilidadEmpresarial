package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.CuentaContableRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.CuentaContable;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class CuentaContableRepoImpl extends JPACleanCRUDRepo<CuentaContableDomain, CuentaContable> implements CuentaContableRepo {

    public CuentaContableRepoImpl() {
        super(ResourcesContabilidad.EMF, CuentaContableDomain.class, CuentaContable.class);
    }
}
