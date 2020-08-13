package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.old.SubcuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.Cuenta;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.Subcuenta;
import java.util.List;
import javax.persistence.EntityManager;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jackson.JACKSON;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import java.util.ArrayList;

public class SubcuentaRepoImpl extends JPACleanCRUDRepo<SubcuentaDomain, Subcuenta> implements SubcuentaRepo {

    private final String Cuenta_findCuentasPadre = "SELECT s FROM Subcuenta s WHERE s.cuentaPadreFk = :cuentaPadreFk";
    private final String Cuenta_findCuentasHijo = "SELECT s FROM Subcuenta s WHERE s.cuentaHijoFk = :cuentaHijoFk";

    public SubcuentaRepoImpl() {
        super(Resources.EMF, SubcuentaDomain.class, Subcuenta.class);
    }

    @Override
    public List<SubcuentaDomain> findSubcuentasDondeSeaHijo(CuentaDomain hijo) {
        EntityManager em = getEntityManager();
        try {
            List<Subcuenta> list = em.createQuery(Cuenta_findCuentasHijo, Subcuenta.class).setParameter("cuentaHijoFk", JACKSON.convert(hijo, Cuenta.class)).getResultList();
            return JACKSON.convert(list, SubcuentaDomain.class);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

    @Override
    public List<SubcuentaDomain> findSubcuentasDondeSeaPadre(CuentaDomain padre) {
        EntityManager em = getEntityManager();
        try {
            List<Subcuenta> list = em.createQuery(Cuenta_findCuentasPadre, Subcuenta.class).setParameter("cuentaPadreFk", JACKSON.convert(padre, Cuenta.class)).getResultList();
            return JACKSON.convert(list, SubcuentaDomain.class);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

}
