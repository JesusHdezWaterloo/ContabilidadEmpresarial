package com.root101.module.gestion.contabilidad.repo.repo_impl;

import com.root101.module.gestion.contabilidad.core.domain.FormaPagoDomain;
import com.root101.module.gestion.contabilidad.core.repo_def.FormaPagoRepo;
import com.root101.module.gestion.contabilidad.repo.entities.FormaPago;
import com.root101.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class FormaPagoRepoImpl extends JPACleanCRUDRepo<FormaPagoDomain, FormaPago> implements FormaPagoRepo {

    public FormaPagoRepoImpl() {
        super(ResourcesContabilidad.EMF, FormaPagoDomain.class, FormaPago.class);
    }

}
