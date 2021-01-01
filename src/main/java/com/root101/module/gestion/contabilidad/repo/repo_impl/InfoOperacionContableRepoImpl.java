package com.root101.module.gestion.contabilidad.repo.repo_impl;

import com.root101.module.gestion.contabilidad.core.domain.InfoOperacionContableDomain;
import com.root101.module.gestion.contabilidad.core.repo_def.InfoOperacionContableRepo;
import com.root101.module.gestion.contabilidad.repo.entities.InfoOperacionContable;
import com.root101.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class InfoOperacionContableRepoImpl extends JPACleanCRUDRepo<InfoOperacionContableDomain, InfoOperacionContable> implements InfoOperacionContableRepo {

    public InfoOperacionContableRepoImpl() {
        super(ResourcesContabilidad.EMF, InfoOperacionContableDomain.class, InfoOperacionContable.class);
    }

}
