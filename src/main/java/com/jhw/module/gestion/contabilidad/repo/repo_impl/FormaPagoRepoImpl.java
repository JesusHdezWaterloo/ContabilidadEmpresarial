package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.FormaPagoDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.FormaPagoRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.FormaPago;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class FormaPagoRepoImpl extends JPACleanCRUDRepo<FormaPagoDomain, FormaPago> implements FormaPagoRepo {

    public FormaPagoRepoImpl() {
        super(ResourcesContabilidad.EMF, FormaPagoDomain.class, FormaPago.class);
    }

}
