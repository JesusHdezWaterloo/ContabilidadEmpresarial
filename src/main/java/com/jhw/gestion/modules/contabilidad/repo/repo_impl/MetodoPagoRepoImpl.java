package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.repo.entities.old.MetodoPago;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class MetodoPagoRepoImpl extends JPACleanCRUDRepo<MetodoPagoDomain, MetodoPago> implements MetodoPagoRepo {

    public MetodoPagoRepoImpl() {
        super(Resources.EMF, MetodoPagoDomain.class, MetodoPago.class);
    }

}
