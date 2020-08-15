package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.entities.*;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import java.util.List;
import javax.persistence.EntityManager;

public class CuadreRepoImpl extends JPACleanCRUDRepo<CuadreDomain, Cuadre> implements CuadreRepo {

    public CuadreRepoImpl() {
        super(Resources.EMF, CuadreDomain.class, Cuadre.class);
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
            return JACKSON.convert(list, CuadreDomain.class);
        } finally {
            em.close();
        }
    }

}
