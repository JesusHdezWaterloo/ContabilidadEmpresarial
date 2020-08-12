package com.jhw.gestion.modules.contabilidad.repo.repo_impl;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.entities.Cuenta;
import com.jhw.gestion.modules.contabilidad.repo.entities.Moneda;
import com.jhw.gestion.modules.contabilidad.repo.module.ContabilidadRepoModule;
import com.jhw.gestion.modules.contabilidad.repo.utils.Resources;
import com.jhw.utils.jackson.JACKSON;
import com.jhw.utils.jpa.JPACleanCRUDRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;

public class CuentaRepoImpl extends JPACleanCRUDRepo<CuentaDomain, Cuenta> implements CuentaRepo {

    private final String Cuenta_findCuentaDepositoBase = "SELECT c FROM Cuenta c WHERE c.cuentaBase = 1 AND c.monedaFk = :monedaFk ORDER BY c.nombreCuenta";
    private final String Cuenta_findCuentasBase = "SELECT c FROM Cuenta c WHERE c.cuentaBase = 0 ORDER BY c.nombreCuenta";

    private final SubcuentaRepo subcuentaRepo = ContabilidadRepoModule.getInstance().getImplementation(SubcuentaRepo.class);

    public CuentaRepoImpl() {
        super(Resources.EMF, CuentaDomain.class, Cuenta.class);
    }

    @Override
    public CuentaDomain findCuentaDepositoBase(MonedaDomain mon) throws Exception {
        EntityManager em = getEntityManager();
        try {
            Cuenta cuenta = em.createQuery(Cuenta_findCuentaDepositoBase, Cuenta.class).setParameter("monedaFk", JACKSON.convert(mon, Moneda.class)).getSingleResult();
            return JACKSON.convert(cuenta, CuentaDomain.class);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void destroyCuentaBase(MonedaDomain mon) throws Exception {
        CuentaDomain c = findCuentaDepositoBase(mon);
        destroy(c);
    }

    @Override
    public List<CuentaDomain> findCuentasBase() throws Exception {
        EntityManager em = getEntityManager();
        try {
            List<Cuenta> list = em.createQuery(Cuenta_findCuentasBase, Cuenta.class).getResultList();
            return JACKSON.convert(list, CuentaDomain.class);
        } finally {
            em.close();
        }
    }

    @Override
    public List<CuentaDomain> findCuentasHijoDelPadre(CuentaDomain padre) {
        List<SubcuentaDomain> relacion = subcuentaRepo.findSubcuentasDondeSeaPadre(padre);

        List<CuentaDomain> hijos = new ArrayList<>(relacion.size());
        for (SubcuentaDomain subcuenta : relacion) {
            hijos.add(subcuenta.getCuentaHijoFk());
        }

        return hijos;
    }

    @Override
    public List<CuentaDomain> findCuentasPadresDelHijo(CuentaDomain hijo) {
        List<SubcuentaDomain> relacion = subcuentaRepo.findSubcuentasDondeSeaHijo(hijo);

        List<CuentaDomain> padre = new ArrayList<>(relacion.size());
        for (SubcuentaDomain subcuenta : relacion) {
            padre.add(subcuenta.getCuentaHijoFk());
        }

        return padre;
    }

    @Override
    public void updateValues() throws Exception {
        checkCuentasBaseIntegrity();
        HashMap<Integer, CuentaDomain> map = new HashMap<>();
        for (CuentaDomain c : findAll()) {
            c.setTotalExtracciones(0d);
            c.setTotalDepositos(0d);
            map.put(c.getIdCuenta(), c);
        }

        for (ExtraccionCuentaDomain ext : ContabilidadRepoModule.getInstance().getImplementation(ExtraccionCuentaRepo.class).findAll()) {
            CuentaDomain c = map.get(ext.getCuentaFk().getIdCuenta());
            double valor = c.getTotalExtracciones() + ext.getValor();
            c.setTotalExtracciones(valor);
            map.put(c.getIdCuenta(), c);
        }

        for (DepositoCuentaDomain dep : ContabilidadRepoModule.getInstance().getImplementation(DepositoCuentaRepo.class).findAll()) {
            CuentaDomain c = map.get(dep.getCuentaFk().getIdCuenta());
            double valor = c.getTotalDepositos() + dep.getValor();
            c.setTotalDepositos(valor);
            map.put(c.getIdCuenta(), c);
        }

        for (CuentaDomain cuenta : map.values()) {
            super.edit(cuenta);
        }
    }

    @Override
    public void checkCuentasBaseIntegrity() throws Exception {
        MonedaRepo monedaRepo = ContabilidadRepoModule.getInstance().getImplementation(MonedaRepo.class);

        List<CuentaDomain> base = findCuentasBase();
        int baseCount = findCuentasBase().size();
        int monCount = monedaRepo.count();

        if (monCount > baseCount) {//faltan cuentas base
            List<MonedaDomain> monedas = monedaRepo.findAll();
            for (MonedaDomain mon : monedas) {
                CuentaDomain baseAct = findCuentaDepositoBase(mon);
                if (baseAct == null) {
                    create(
                            new CuentaDomain("Banco " + mon.getTipoMoneda(), 100f, 0d, 0d, "0000111122223333", "1234",
                                    "Cuenta base para los depósitos en moneda " + mon.getTipoMoneda(),
                                    true, mon));
                }
            }
        } else if (monCount > baseCount) {//sobram cuentas base
            for (CuentaDomain c : base) {
                try {
                    MonedaDomain mon = monedaRepo.findBy(c.getMonedaFk().getIdMoneda());
                    if (mon == null) {
                        throw new NullPointerException("Esta Cuenta sobra");
                    }
                } catch (Exception e) {
                    try {
                        super.destroy(c);
                    } catch (Exception ex) {
                        System.out.println("NO SE PUEDE ELIMINAR Cuenta");
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

}
