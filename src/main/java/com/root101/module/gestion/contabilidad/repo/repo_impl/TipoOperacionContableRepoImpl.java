package com.root101.module.gestion.contabilidad.repo.repo_impl;

import com.root101.module.gestion.contabilidad.core.domain.TipoOperacionContableDomain;
import com.root101.module.gestion.contabilidad.core.repo_def.TipoOperacionContableRepo;
import com.root101.module.gestion.contabilidad.repo.entities.TipoOperacionContable;
import com.root101.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class TipoOperacionContableRepoImpl extends JPACleanCRUDRepo<TipoOperacionContableDomain, TipoOperacionContable> implements TipoOperacionContableRepo {

    public TipoOperacionContableRepoImpl() {
        super(ResourcesContabilidad.EMF, TipoOperacionContableDomain.class, TipoOperacionContable.class);
    }

}
