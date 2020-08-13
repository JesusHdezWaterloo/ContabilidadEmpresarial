package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.old.TipoExtraccionDomain;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.TipoExtraccion;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class TipoExtraccionRepoImpl extends JPACleanCRUDRepo<TipoExtraccionDomain, TipoExtraccion> implements TipoExtraccionRepo {

    public TipoExtraccionRepoImpl() {
        super(Resources.EMF, TipoExtraccionDomain.class, TipoExtraccion.class);
    }

}
