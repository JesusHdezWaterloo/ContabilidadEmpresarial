package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.entities.*;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jackson.JACKSON;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import java.util.List;
import javax.persistence.EntityManager;

public class LiquidacionRepoImpl extends JPACleanCRUDRepo<LiquidacionDomain, Liquidacion> implements LiquidacionRepo {

    private final String Liquidacion_findByCuenta = "SELECT l FROM Liquidacion l WHERE l.cuentaFk = :cuentaFk";

    public LiquidacionRepoImpl() {
        super(Resources.EMF, LiquidacionDomain.class, Liquidacion.class);
    }

    @Override
    public List<LiquidacionDomain> findAll(CuentaBancariaDomain cuenta) throws Exception {
        if (cuenta == null) {
            return findAll(cuenta);
        } else {
            return findAllByCuenta(cuenta);
        }
    }

    public List<LiquidacionDomain> findAllByCuenta(CuentaBancariaDomain cuenta) throws Exception {
        EntityManager em = getEntityManager();
        try {
            List<Liquidacion> list = em.createQuery(Liquidacion_findByCuenta, Liquidacion.class).setParameter("cuentaFk", cuenta).getResultList();
            return JACKSON.convert(list, LiquidacionDomain.class);
        } finally {
            em.close();
        }
    }

}
