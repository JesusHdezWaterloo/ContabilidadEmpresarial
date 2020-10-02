package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.MonedaDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.MonedaRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.Moneda;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class MonedaRepoImpl extends JPACleanCRUDRepo<MonedaDomain, Moneda> implements MonedaRepo {

    public MonedaRepoImpl() {
        super(ResourcesContabilidad.EMF, MonedaDomain.class, Moneda.class);
    }

}
