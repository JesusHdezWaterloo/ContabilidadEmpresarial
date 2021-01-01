package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.CuadreRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.Cuadre;
import com.jhw.module.gestion.contabilidad.repo.entities.CuentaContable;
import com.jhw.module.gestion.contabilidad.repo.entities.InfoOperacionContable;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.root101.utils.services.ConverterService;
import com.root101.repo.jpa.JPACleanCRUDRepo;
import com.root101.repo.jpa.NonExistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;

public class CuadreRepoImpl extends JPACleanCRUDRepo<CuadreDomain, Cuadre> implements CuadreRepo {

    public CuadreRepoImpl() {
        super(ResourcesContabilidad.EMF, CuadreDomain.class, Cuadre.class);
    }

    @Override
    public CuadreDomain create(CuadreDomain domain) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Cuadre cuadreEntity = ConverterService.convert(domain, Cuadre.class);

            InfoOperacionContable info = cuadreEntity.getOperacionContableFk().getInfoOperacionContableFk();
            em.persist(info);
            em.flush();

            cuadreEntity.getOperacionContableFk().setInfoOperacionContableFk(info);
            cuadreEntity.getOperacionContableCuadreFk().setInfoOperacionContableFk(info);

            em.persist(cuadreEntity.getOperacionContableFk());
            em.persist(cuadreEntity.getOperacionContableCuadreFk());
            em.flush();

            em.persist(cuadreEntity);

            em.merge(cuadreEntity.getOperacionContableFk().getCuentaFk());
            em.merge(cuadreEntity.getOperacionContableCuadreFk().getCuentaFk());

            em.getTransaction().commit();
            domain = ConverterService.convert(cuadreEntity, CuadreDomain.class);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return domain;
    }

    @Override
    public CuadreDomain edit(CuadreDomain domain) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();

            Cuadre cuadreEntity = ConverterService.convert(domain, Cuadre.class);

            InfoOperacionContable info = cuadreEntity.getOperacionContableFk().getInfoOperacionContableFk();
            em.merge(info);

            em.merge(cuadreEntity.getOperacionContableFk());
            em.merge(cuadreEntity.getOperacionContableCuadreFk());
            em.flush();

            em.persist(cuadreEntity);

            em.merge(cuadreEntity.getOperacionContableFk().getCuentaFk());
            em.merge(cuadreEntity.getOperacionContableCuadreFk().getCuentaFk());

            em.getTransaction().commit();
            domain = ConverterService.convert(cuadreEntity, CuadreDomain.class);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return domain;
    }

    @Override
    public CuadreDomain destroy(CuadreDomain domain) throws Exception {
        EntityManager em = null;
        Cuadre persistedObject;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            persistedObject = em.find(Cuadre.class, domain.getIdCuadre());
            if (persistedObject == null) {
                throw new NonExistingEntityException(domain + " no longer exists.");
            }

            em.merge(ConverterService.convert(domain.getOperacionContableFk().getCuentaFk(), CuentaContable.class));
            em.merge(ConverterService.convert(domain.getOperacionContableCuadreFk().getCuentaFk(), CuentaContable.class));

            em.remove(persistedObject.getOperacionContableFk().getInfoOperacionContableFk());

            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return domain;
    }

    @Override
    public CuadreDomain destroyById(Object keyId) throws Exception {
        throw new RuntimeException("Eliminar directo el objeto completo");
    }

    @Override
    public List<CuadreDomain> findAllPending() throws Exception {
        return findByLiquidada(false);
    }

    @Override
    public List<CuadreDomain> findAllLiquidadas() throws Exception {
        return findByLiquidada(true);
    }

    @Override
    public List<CuadreDomain> findByLiquidada(boolean liquidada) throws Exception {
        EntityManager em = getEntityManager();
        try {
            List<Cuadre> list = em.createNamedQuery("Cuadre.findByLiquidada", Cuadre.class).setParameter("liquidada", liquidada).getResultList();
            return ConverterService.convert(list, CuadreDomain.class);
        } finally {
            em.close();
        }
    }

}
