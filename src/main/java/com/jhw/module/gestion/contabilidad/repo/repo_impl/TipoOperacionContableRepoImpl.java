package com.jhw.module.gestion.contabilidad.repo.repo_impl;

import com.jhw.module.gestion.contabilidad.core.domain.TipoOperacionContableDomain;
import com.jhw.module.gestion.contabilidad.core.repo_def.TipoOperacionContableRepo;
import com.jhw.module.gestion.contabilidad.repo.entities.TipoOperacionContable;
import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import com.jhw.utils.services.ConverterService;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import javax.persistence.EntityManager;

public class TipoOperacionContableRepoImpl extends JPACleanCRUDRepo<TipoOperacionContableDomain, TipoOperacionContable> implements TipoOperacionContableRepo {

    public TipoOperacionContableRepoImpl() {
        super(ResourcesContabilidad.EMF, TipoOperacionContableDomain.class, TipoOperacionContable.class);
    }

    @Override
    public TipoOperacionContableDomain findByKey(String key) throws Exception {
        EntityManager em = getEntityManager();
        try {
            TipoOperacionContable obj = em.createNamedQuery("TipoOperacionContable.findByKeyEnum", TipoOperacionContable.class).setParameter("keyEnum", key).getSingleResult();
            return ConverterService.convert(obj, TipoOperacionContableDomain.class);
        } finally {
            em.close();
        }
    }
}
