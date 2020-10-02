package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.SubcuentaDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.SubcuentaRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.Subcuenta;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class SubcuentaRepoImpl extends JPACleanCRUDRepo<SubcuentaDomain, Subcuenta> implements SubcuentaRepo {

    public SubcuentaRepoImpl() {
        super(ResourcesContabilidad.EMF, SubcuentaDomain.class, Subcuenta.class);
    }

}
