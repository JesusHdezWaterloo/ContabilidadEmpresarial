package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.entities.*;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class SubcuentaRepoImpl extends JPACleanCRUDRepo<SubcuentaDomain, Subcuenta> implements SubcuentaRepo {

    public SubcuentaRepoImpl() {
        super(Resources.EMF, SubcuentaDomain.class, Subcuenta.class);
    }

}
