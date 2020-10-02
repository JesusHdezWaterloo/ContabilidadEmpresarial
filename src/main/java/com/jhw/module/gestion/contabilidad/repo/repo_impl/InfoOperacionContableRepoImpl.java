package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.InfoOperacionContableDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.InfoOperacionContableRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.InfoOperacionContable;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class InfoOperacionContableRepoImpl extends JPACleanCRUDRepo<InfoOperacionContableDomain, InfoOperacionContable> implements InfoOperacionContableRepo {

    public InfoOperacionContableRepoImpl() {
        super(ResourcesContabilidad.EMF, InfoOperacionContableDomain.class, InfoOperacionContable.class);
    }

}
