package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.entities.*;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jackson.JACKSON;
import com.jhw.utils.jpa.ConverterService;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import com.jhw.utils.jpa.NonExistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;

public class LiquidacionRepoImpl extends JPACleanCRUDRepo<LiquidacionDomain, Liquidacion> implements LiquidacionRepo {

    private final String Liquidacion_findByCuenta = "SELECT l FROM Liquidacion l WHERE l.cuentaFk = :cuentaFk";

    public LiquidacionRepoImpl() {
        super(Resources.EMF, LiquidacionDomain.class, Liquidacion.class);
    }

    @Override
    public LiquidacionDomain create(LiquidacionDomain domain) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Liquidacion liqEntity = ConverterService.convert(domain, Liquidacion.class);
            em.persist(liqEntity);

            Cuadre cuadreEntity = ConverterService.convert(domain.getCuadreFk(), Cuadre.class);
            em.merge(cuadreEntity);

            em.getTransaction().commit();

            domain = ConverterService.convert(liqEntity, LiquidacionDomain.class);
            domain.setCuadreFk(ConverterService.convert(cuadreEntity, CuadreDomain.class));
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return domain;
    }

    @Override
    public LiquidacionDomain destroy(LiquidacionDomain domain) throws Exception {
        EntityManager em = null;
        Liquidacion persistedObject;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            persistedObject = em.find(Liquidacion.class, domain.getIdLiquidacion());
            if (persistedObject == null) {
                throw new NonExistingEntityException(domain + " no longer exists.");
            }

            em.remove(persistedObject);

            Cuadre cuadreEntity = ConverterService.convert(domain.getCuadreFk(), Cuadre.class);
            em.merge(cuadreEntity);

            em.getTransaction().commit();

            domain = ConverterService.convert(persistedObject, LiquidacionDomain.class);
            domain.setCuadreFk(ConverterService.convert(cuadreEntity, CuadreDomain.class));
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return domain;
    }

    @Override
    public List<LiquidacionDomain> findAll(CuentaBancariaDomain cuenta) throws Exception {
        if (cuenta == null) {
            return findAll();
        } else {
            return findAllByCuenta(cuenta);
        }
    }

    private List<LiquidacionDomain> findAllByCuenta(CuentaBancariaDomain cuenta) throws Exception {
        EntityManager em = getEntityManager();
        try {
            List<Liquidacion> list = em.createQuery(Liquidacion_findByCuenta, Liquidacion.class).setParameter("cuentaFk", cuenta).getResultList();
            return JACKSON.convert(list, LiquidacionDomain.class);
        } finally {
            em.close();
        }
    }

}
