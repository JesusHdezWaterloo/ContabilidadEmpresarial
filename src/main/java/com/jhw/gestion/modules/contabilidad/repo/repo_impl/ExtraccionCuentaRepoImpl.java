package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.ExtraccionCuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.TipoExtraccionDomain;
import com.jhw.gestion.modules.contabilidad.core.repo_def.ExtraccionCuentaRepo;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.Cuenta;
import java.util.List;
import javax.persistence.EntityManager;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.ExtraccionCuenta;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.TipoExtraccion;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jackson.JACKSON;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import java.util.ArrayList;

public class ExtraccionCuentaRepoImpl extends JPACleanCRUDRepo<ExtraccionCuentaDomain, ExtraccionCuenta> implements ExtraccionCuentaRepo {

    private final String ExtraccionCuenta_findExtraccionDe = "SELECT e FROM ExtraccionCuenta e WHERE e.tipoExtraccion = :tipoExtraccion AND e.idExterno = :idExterno";
    private final String ExtraccionCuenta_findExtraccionesOfCuenta = "SELECT e FROM ExtraccionCuenta e WHERE e.cuentaFk = :cuentaFk";

    public ExtraccionCuentaRepoImpl() {
        super(Resources.EMF, ExtraccionCuentaDomain.class, ExtraccionCuenta.class);
    }

    @Override
    public List<ExtraccionCuentaDomain> findExtraccionesOfCuenta(CuentaDomain cuenta) throws Exception {
        EntityManager em = getEntityManager();
        try {
            List list = em.createQuery(ExtraccionCuenta_findExtraccionesOfCuenta, ExtraccionCuenta.class)
                    .setParameter("cuentaFk", JACKSON.convert(cuenta, Cuenta.class)).getResultList();
            return JACKSON.convert(list, ExtraccionCuentaDomain.class);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

    @Override
    public List<ExtraccionCuentaDomain> findExtraccionList(TipoExtraccionDomain tipo, Integer idExterno) throws Exception {
        EntityManager em = getEntityManager();
        try {
            List list = em.createQuery(ExtraccionCuenta_findExtraccionDe, ExtraccionCuenta.class)
                    .setParameter("tipoExtraccion", tipo)
                    .setParameter("idExterno", idExterno).getResultList();
            return JACKSON.convert(list, ExtraccionCuentaDomain.class);
        } finally {
            em.close();
        }
    }

    @Override
    public ExtraccionCuentaDomain findExtraccionSingle(TipoExtraccionDomain tipo, Integer idExterno) throws Exception {
        EntityManager em = getEntityManager();
        try {
            ExtraccionCuenta ext = em.createQuery(ExtraccionCuenta_findExtraccionDe, ExtraccionCuenta.class)
                    .setParameter("tipoExtraccion", JACKSON.convert(tipo, TipoExtraccion.class))
                    .setParameter("idExterno", idExterno).getSingleResult();
            return JACKSON.convert(ext, ExtraccionCuentaDomain.class);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

}
