package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.old.TipoDepositoDomain;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.TipoDeposito;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class TipoDepositoRepoImpl extends JPACleanCRUDRepo<TipoDepositoDomain, TipoDeposito> implements TipoDepositoRepo {

    public TipoDepositoRepoImpl() {
        super(Resources.EMF, TipoDepositoDomain.class, TipoDeposito.class);
    }

}
