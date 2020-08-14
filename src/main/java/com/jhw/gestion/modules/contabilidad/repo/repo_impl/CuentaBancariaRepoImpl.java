package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.entities.*;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class CuentaBancariaRepoImpl extends JPACleanCRUDRepo<CuentaBancariaDomain, CuentaBancaria> implements CuentaBancariaRepo {

    public CuentaBancariaRepoImpl() {
        super(Resources.EMF, CuentaBancariaDomain.class, CuentaBancaria.class);
    }

}
