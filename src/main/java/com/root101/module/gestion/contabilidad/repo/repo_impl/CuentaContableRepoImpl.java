package com.root101.module.gestion.contabilidad.repo.repo_impl;

import com.root101.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.root101.module.gestion.contabilidad.core.repo_def.CuentaContableRepo;
import com.root101.module.gestion.contabilidad.repo.entities.CuentaContable;
import com.root101.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class CuentaContableRepoImpl extends JPACleanCRUDRepo<CuentaContableDomain, CuentaContable> implements CuentaContableRepo {

    public CuentaContableRepoImpl() {
        super(ResourcesContabilidad.EMF, CuentaContableDomain.class, CuentaContable.class);
    }
}
