package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.module.gestion.contabilidad.core.domain.OperacionContableDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.OperacionContableRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.CuentaContable;
import com.jhw.module.gestion.contabilidad.repo.entities.OperacionContable;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.jhw.utils.services.ConverterService;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import java.util.List;
import javax.persistence.EntityManager;

public class OperacionContableRepoImpl extends JPACleanCRUDRepo<OperacionContableDomain, OperacionContable> implements OperacionContableRepo {

    private final String OperacionContable_findByCuenta = "SELECT o FROM OperacionContable o WHERE o.cuentaFk = :cuentaFk";

    public OperacionContableRepoImpl() {
        super(ResourcesContabilidad.EMF, OperacionContableDomain.class, OperacionContable.class);
    }

    @Override
    public List<OperacionContableDomain> findAll(CuentaContableDomain cuenta) throws Exception {
        if (cuenta == null) {
            return findAll();
        } else {
            return findAllByCuenta(cuenta);
        }
    }

    private List<OperacionContableDomain> findAllByCuenta(CuentaContableDomain cuenta) throws Exception {
        EntityManager em = getEntityManager();
        try {
            List<CuentaContable> list = em.createQuery(OperacionContable_findByCuenta, CuentaContable.class).setParameter("cuentaFk", ConverterService.convert(cuenta, CuentaContable.class)).getResultList();
            return ConverterService.convert(list, OperacionContableDomain.class);
        } finally {
            em.close();
        }
    }
}
