package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaBancariaDomain;
import com.jhw.module.gestion.contabilidad.core.domain.LiquidacionDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.LiquidacionRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.Cuadre;
import com.jhw.module.gestion.contabilidad.repo.entities.CuentaBancaria;
import com.jhw.module.gestion.contabilidad.repo.entities.CuentaContable;
import com.jhw.module.gestion.contabilidad.repo.entities.Liquidacion;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.root101.utils.services.ConverterService;
import com.root101.repo.jpa.JPACleanCRUDRepo;
import com.root101.repo.jpa.NonExistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class LiquidacionRepoImpl extends JPACleanCRUDRepo<LiquidacionDomain, Liquidacion> implements LiquidacionRepo {

    private final String Liquidacion_findByCuenta = "SELECT l FROM Liquidacion l WHERE l.cuentaFk = :cuentaFk";

    public LiquidacionRepoImpl() {
        super(ResourcesContabilidad.EMF, LiquidacionDomain.class, Liquidacion.class);
    }

    @Override
    public LiquidacionDomain create(LiquidacionDomain domain) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            //crea la liquidacion
            Liquidacion liqEntity = ConverterService.convert(domain, Liquidacion.class);
            em.persist(liqEntity);

            //update el cuadre
            Cuadre cuadreEntity = ConverterService.convert(domain.getCuadreFk(), Cuadre.class);
            em.merge(cuadreEntity);

            //update la centa bancaria
            CuentaBancaria cuentaBancariaEntity = ConverterService.convert(domain.getCuentaFk(), CuentaBancaria.class);
            em.merge(cuentaBancariaEntity);

            //update la cuenta contable
            CuentaContable cuentaContableEntity = ConverterService.convert(domain.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk(), CuentaContable.class);
            em.merge(cuentaContableEntity);
            cuadreEntity.getOperacionContableCuadreFk().setCuentaFk(cuentaContableEntity);

            em.getTransaction().commit();

            domain = ConverterService.convert(liqEntity, LiquidacionDomain.class);
            domain.setCuadreFk(ConverterService.convert(cuadreEntity, CuadreDomain.class));
            domain.setCuentaFk(ConverterService.convert(cuentaBancariaEntity, CuentaBancariaDomain.class));
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

            CuentaBancaria cuentaBancariaEntity = ConverterService.convert(domain.getCuentaFk(), CuentaBancaria.class);
            em.merge(cuentaBancariaEntity);

            //update la cuenta contable
            CuentaContable cuentaContableEntity = ConverterService.convert(domain.getCuadreFk().getOperacionContableCuadreFk().getCuentaFk(), CuentaContable.class);
            em.merge(cuentaContableEntity);
            cuadreEntity.getOperacionContableCuadreFk().setCuentaFk(cuentaContableEntity);

            em.getTransaction().commit();

            domain = ConverterService.convert(persistedObject, LiquidacionDomain.class);
            domain.setCuadreFk(ConverterService.convert(cuadreEntity, CuadreDomain.class));
            domain.setCuentaFk(ConverterService.convert(cuentaBancariaEntity, CuentaBancariaDomain.class));
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return domain;
    }

    @Override
    public LiquidacionDomain destroyById(Object keyId) throws Exception {
        throw new RuntimeException("Eliminar directo el objeto completo");
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
            List<Liquidacion> list = em.createQuery(Liquidacion_findByCuenta, Liquidacion.class).setParameter("cuentaFk", ConverterService.convert(cuenta, CuentaBancaria.class)).getResultList();
            return ConverterService.convert(list, LiquidacionDomain.class);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

}
