package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.TipoCuentaDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.TipoCuentaRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.TipoCuenta;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class TipoCuentaRepoImpl extends JPACleanCRUDRepo<TipoCuentaDomain, TipoCuenta> implements TipoCuentaRepo {

    public TipoCuentaRepoImpl() {
        super(ResourcesContabilidad.EMF, TipoCuentaDomain.class, TipoCuenta.class);
    }

}
