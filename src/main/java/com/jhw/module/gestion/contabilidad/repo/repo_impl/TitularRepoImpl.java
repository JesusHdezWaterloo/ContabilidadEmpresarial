package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.TitularDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.TitularRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.Titular;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class TitularRepoImpl extends JPACleanCRUDRepo<TitularDomain, Titular> implements TitularRepo {

    public TitularRepoImpl() {
        super(ResourcesContabilidad.EMF, TitularDomain.class, Titular.class);
    }

}
