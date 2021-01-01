package com.root101.module.gestion.contabilidad.repo.repo_impl;

import com.root101.module.gestion.contabilidad.core.domain.TitularDomain;
import com.root101.module.gestion.contabilidad.core.repo_def.TitularRepo;
import com.root101.module.gestion.contabilidad.repo.entities.Titular;
import com.root101.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class TitularRepoImpl extends JPACleanCRUDRepo<TitularDomain, Titular> implements TitularRepo {

    public TitularRepoImpl() {
        super(ResourcesContabilidad.EMF, TitularDomain.class, Titular.class);
    }

}
