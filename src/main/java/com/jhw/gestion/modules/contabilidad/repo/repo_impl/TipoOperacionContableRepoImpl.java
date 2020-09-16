package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.entities.*;
import com.jhw.gestion.modules.contabilidad.repo.utils.ResourcesContabilidad;
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
