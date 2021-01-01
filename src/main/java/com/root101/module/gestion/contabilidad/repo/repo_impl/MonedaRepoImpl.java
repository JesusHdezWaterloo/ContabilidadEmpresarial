package com.root101.module.gestion.contabilidad.repo.repo_impl;

import com.root101.module.gestion.contabilidad.core.domain.MonedaDomain;
import com.root101.module.gestion.contabilidad.core.repo_def.MonedaRepo;
import com.root101.module.gestion.contabilidad.repo.entities.Moneda;
import com.root101.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class MonedaRepoImpl extends JPACleanCRUDRepo<MonedaDomain, Moneda> implements MonedaRepo {

    public MonedaRepoImpl() {
        super(ResourcesContabilidad.EMF, MonedaDomain.class, Moneda.class);
    }

}
