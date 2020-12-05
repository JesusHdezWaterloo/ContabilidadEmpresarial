package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.TipoOperacionContableDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.TipoOperacionContableRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.TipoOperacionContable;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class TipoOperacionContableRepoImpl extends JPACleanCRUDRepo<TipoOperacionContableDomain, TipoOperacionContable> implements TipoOperacionContableRepo {

    public TipoOperacionContableRepoImpl() {
        super(ResourcesContabilidad.EMF, TipoOperacionContableDomain.class, TipoOperacionContable.class);
    }

}
