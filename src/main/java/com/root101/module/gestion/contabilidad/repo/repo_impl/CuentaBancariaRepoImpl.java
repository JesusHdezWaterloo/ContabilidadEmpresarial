package com.root101.module.gestion.contabilidad.repo.repo_impl;

import com.root101.module.gestion.contabilidad.core.domain.CuentaBancariaDomain;
import com.root101.module.gestion.contabilidad.core.repo_def.CuentaBancariaRepo;
import com.root101.module.gestion.contabilidad.repo.entities.CuentaBancaria;
import com.root101.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.root101.repo.jpa.JPACleanCRUDRepo;

public class CuentaBancariaRepoImpl extends JPACleanCRUDRepo<CuentaBancariaDomain, CuentaBancaria> implements CuentaBancariaRepo {

    public CuentaBancariaRepoImpl() {
        super(ResourcesContabilidad.EMF, CuentaBancariaDomain.class, CuentaBancaria.class);
    }

}
