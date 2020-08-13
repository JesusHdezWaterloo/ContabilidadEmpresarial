package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.CuentaUseCase;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.Cuenta;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.Moneda;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jackson.JACKSON;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import com.jhw.utils.jpa.NonExistingEntityException;
import com.jhw.utils.others.PairDifferent;
import javax.persistence.EntityManager;

public class MonedaRepoImpl extends JPACleanCRUDRepo<MonedaDomain, Moneda> implements MonedaRepo {

    public MonedaRepoImpl() {
        super(Resources.EMF, MonedaDomain.class, Moneda.class);
    }

    @Override
    public PairDifferent<MonedaDomain, CuentaDomain> create(MonedaDomain moneda, CuentaDomain cuenta) throws Exception {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();

            Moneda monedaEntity = JACKSON.convert(moneda, Moneda.class);
            em.persist(monedaEntity);//salvo la moneda
            em.flush();//flush para que coja id

            Cuenta cuentaEntiy = JACKSON.convert(cuenta, Cuenta.class);
            cuentaEntiy.setMonedaFk(monedaEntity);

            em.persist(cuentaEntiy);
            em.getTransaction().commit();

            moneda = JACKSON.convert(monedaEntity, MonedaDomain.class);
            cuenta = JACKSON.convert(cuentaEntiy, CuentaDomain.class);
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
        PairDifferent<MonedaDomain, CuentaDomain> pair = new PairDifferent(moneda, cuenta);
        return pair;
    }

    /**
     * LLamar directo al destroy de moneda y en cascada elimina la cuenta
     *
     * @param moneda
     * @param cuenta
     * @return
     * @throws Exception
     * @deprecated
     */
    @Deprecated
    @Override
    public PairDifferent<MonedaDomain, CuentaDomain> destroy(MonedaDomain moneda, CuentaDomain cuenta) throws Exception {
        EntityManager em = null;
        Moneda monedaEntity;
        Cuenta cuentaEntity;

        try {
            em = getEntityManager();
            em.getTransaction().begin();

            monedaEntity = em.find(Moneda.class, moneda.getIdMoneda());
            if (monedaEntity == null) {
                throw new NonExistingEntityException(moneda.getIdMoneda() + " no longer exists.");
            }

            cuentaEntity = em.find(Cuenta.class, cuenta.getIdCuenta());
            if (cuentaEntity == null) {
                throw new NonExistingEntityException(cuenta.getIdCuenta() + " no longer exists.");
            }

            em.remove(monedaEntity);

            em.remove(cuentaEntity);

            em.getTransaction().commit();

            moneda = JACKSON.convert(monedaEntity, MonedaDomain.class);
            cuenta = JACKSON.convert(cuentaEntity, CuentaDomain.class);
        } finally {
            if (em != null) {
                em.close();
            }
        }
        PairDifferent<MonedaDomain, CuentaDomain> pair = new PairDifferent(moneda, cuenta);
        return pair;
    }

    @Deprecated
    @Override
    public MonedaDomain create(MonedaDomain moneda) {
        throw new UnsupportedOperationException("msg.module.contabilidad.validation.moneda_cuenta.nueva_moneda_sin_cuenta");
    }

    @Override
    public MonedaDomain destroy(MonedaDomain moneda) throws Exception {
        ContabilidadCoreModule.getInstance().getImplementation(CuentaUseCase.class).destroyCuentaBase(moneda);
        return super.destroy(moneda);
    }

}
