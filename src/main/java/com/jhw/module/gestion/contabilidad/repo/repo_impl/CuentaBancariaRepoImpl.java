package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.CuentaBancariaDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.CuentaBancariaRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.CuentaBancaria;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.jhw.utils.jpa.JPACleanCRUDRepo;

public class CuentaBancariaRepoImpl extends JPACleanCRUDRepo<CuentaBancariaDomain, CuentaBancaria> implements CuentaBancariaRepo {

    public CuentaBancariaRepoImpl() {
        super(ResourcesContabilidad.EMF, CuentaBancariaDomain.class, CuentaBancaria.class);
    }

}
