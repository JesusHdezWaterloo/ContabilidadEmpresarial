package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.DepositoCuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.ExtraccionCuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.repo_def.DepositoCuentaRepo;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.Cuenta;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.DepositoCuenta;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.ExtraccionCuenta;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.TipoDeposito;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jackson.JACKSON;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import com.jhw.utils.jpa.NonExistingEntityException;
import com.jhw.utils.others.PairDifferent;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class DepositoCuentaRepoImpl extends JPACleanCRUDRepo<DepositoCuentaDomain, DepositoCuenta> implements DepositoCuentaRepo {

    private final String Deposito_findDepositosOfCuenta = "SELECT d FROM DepositoCuenta d WHERE d.cuentaFk = :cuentaFk";
    private final String Deposito_findSubDepositos = "SELECT d FROM DepositoCuenta d WHERE d.tipoDepositoFk = :tipoDepositoFk AND d.idExterno = :idExterno";

    public DepositoCuentaRepoImpl() {
        super(Resources.EMF, DepositoCuentaDomain.class, DepositoCuenta.class);
    }

    @Override
    public DepositoCuentaDomain create(DepositoCuentaDomain deposito, List<PairDifferent<DepositoCuentaDomain, ExtraccionCuentaDomain>> extracciones_depositos, List<CuentaDomain> cuentas) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            //salva al padre
            DepositoCuenta depPadre = JACKSON.convert(deposito, DepositoCuenta.class);
            em.persist(depPadre);
            em.flush();
            deposito = JACKSON.convert(depPadre, DepositoCuentaDomain.class);

            for (PairDifferent<DepositoCuentaDomain, ExtraccionCuentaDomain> pair : extracciones_depositos) {
                DepositoCuenta dep = JACKSON.convert(pair.getA(), DepositoCuenta.class);

                em.persist(dep);
                em.flush();

                ExtraccionCuenta ext = JACKSON.convert(pair.getB(), ExtraccionCuenta.class);
                ext.setIdExterno(dep.getIdDepositoCuenta());

                em.persist(ext);
            }

            List<Cuenta> cuent = JACKSON.convert(cuentas, Cuenta.class);
            for (Cuenta c : cuent) {
                em.merge(c);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return deposito;
    }

    @Deprecated
    @Override
    public DepositoCuentaDomain destroy(DepositoCuentaDomain domain) throws Exception {
        throw new UnsupportedOperationException("No se puede eliminar un deposito solo.");
    }

    @Override
    public void destroy(List<PairDifferent<DepositoCuentaDomain, ExtraccionCuentaDomain>> extracciones_depositos, List<CuentaDomain> cuentas) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            for (PairDifferent<DepositoCuentaDomain, ExtraccionCuentaDomain> pair : extracciones_depositos) {
                DepositoCuenta dep = em.find(DepositoCuenta.class, pair.getA().getIdDepositoCuenta());
                if (dep == null) {
                    throw new NonExistingEntityException(pair.getA() + " ya no existe.");
                }
                em.remove(dep);

                if (pair.getB() != null) {
                    ExtraccionCuenta ext = em.find(ExtraccionCuenta.class, pair.getB().getIdExtraccionCuenta());
                    if (ext == null) {
                        throw new NonExistingEntityException(pair.getB() + " ya no existe.");
                    }
                    em.remove(ext);
                }
            }

            List<Cuenta> cuent = JACKSON.convert(cuentas, Cuenta.class);
            for (Cuenta c : cuent) {
                em.merge(c);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<DepositoCuentaDomain> findDepositosOfCuenta(CuentaDomain cuenta) {
        EntityManager em = getEntityManager();
        try {
            List<DepositoCuenta> list = em.createQuery(Deposito_findDepositosOfCuenta, DepositoCuenta.class).setParameter("cuentaFk", JACKSON.convert(cuenta, DepositoCuenta.class)).getResultList();
            return JACKSON.convert(list, DepositoCuentaDomain.class);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }

    @Override
    public List<DepositoCuentaDomain> findSubDepositos(DepositoCuentaDomain depositoInicial) {
        EntityManager em = getEntityManager();
        try {
            List<DepositoCuenta> list = em.createQuery(Deposito_findSubDepositos, DepositoCuenta.class)
                    .setParameter("tipoDepositoFk", JACKSON.convert(depositoInicial.getTipoDepositoFk(), TipoDeposito.class))
                    .setParameter("idExterno", depositoInicial.getIdExterno()).getResultList();
            return JACKSON.convert(list, DepositoCuentaDomain.class);
        } catch (Exception e) {
            return new ArrayList<>();
        } finally {
            em.close();
        }
    }
}
