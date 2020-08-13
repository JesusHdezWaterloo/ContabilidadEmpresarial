/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.usecase_impl.graph;

import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.old.DepositoCuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.old.ExtraccionCuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.CuentaUseCase;
import com.jhw.gestion.modules.contabilidad.core.usecase_impl.TipoExtraccionUseCaseImpl;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.utils.others.PairDifferent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DepositoCuentaCreateGraph {

    private final List<PairDifferent<DepositoCuentaDomain, ExtraccionCuentaDomain>> extracciones_depositos = new ArrayList<>();
    private final Map<Integer, CuentaDomain> cuentas = new HashMap<>();

    public static DepositoCuentaCreateGraph exec(DepositoCuentaDomain deposito) throws Exception {
        DepositoCuentaCreateGraph thiss = new DepositoCuentaCreateGraph();
        thiss.execute(deposito);
        return thiss;
    }

    public List<PairDifferent<DepositoCuentaDomain, ExtraccionCuentaDomain>> getExtracciones_depositos() {
        return extracciones_depositos;
    }

    public List<CuentaDomain> getCuentas() {
        return new ArrayList<>(cuentas.values());
    }

    private void execute(DepositoCuentaDomain depositoCuenta) throws Exception {
        CuentaDomain cuenta = depositoCuenta.getCuentaFk();
        for (CuentaDomain hijos : ContabilidadCoreModule.getInstance().getImplementation(CuentaUseCase.class).findCuentasHijoDelPadre(cuenta)) {//recorre todos los hijos y propaga el pago
            depositarEnHijos(cuenta, hijos, depositoCuenta);
        }
        updateFor(depositoCuenta);
        for (PairDifferent<DepositoCuentaDomain, ExtraccionCuentaDomain> pair : extracciones_depositos) {
            updateFor(pair.getA());
            updateFor(pair.getB());
        }
    }

    private void depositarEnHijos(CuentaDomain padreActual, CuentaDomain hijoActual, DepositoCuentaDomain depositoPadre) throws Exception {
        float valorReducidoPadre = depositoPadre.getValor() * hijoActual.getPorciento() / 100;

        //le quito ese valor a mi padre
        ExtraccionCuentaDomain ext = new ExtraccionCuentaDomain("Extracción Automática por depósito en sub-cuentas.",
                valorReducidoPadre,
                "Extracción automática por un valor de " + valorReducidoPadre,
                TipoExtraccionUseCaseImpl.EXTRACCION_DEPOSITO_SUB_CUENTA,
                0,
                padreActual);

        //me lo agrego a mi
        DepositoCuentaDomain depositoActual = new DepositoCuentaDomain(
                MonedaHandler.venta(valorReducidoPadre, padreActual.getMonedaFk(), hijoActual.getMonedaFk()),
                hijoActual.getPorciento(),
                hijoActual,
                depositoPadre.getTipoDepositoFk(),
                depositoPadre.getIdExterno()
        );
        
        extracciones_depositos.add(new PairDifferent<>(depositoActual, ext));
        for (CuentaDomain subHijo : ContabilidadCoreModule.getInstance().getImplementation(CuentaUseCase.class).findCuentasHijoDelPadre(hijoActual)) {//recorre todos los hijos y propaga el pago
            depositarEnHijos(hijoActual, subHijo, depositoActual);
        }
    }

    public void updateFor(ExtraccionCuentaDomain extraccionCuenta) throws Exception {
        CuentaDomain c = extraccionCuenta.getCuentaFk();
        if (!cuentas.containsKey(c.getIdCuenta())) {
            cuentas.put(c.getIdCuenta(), c);
        } else {
            c = cuentas.get(c.getIdCuenta());
        }
        double valor = c.getTotalExtracciones();
        valor += extraccionCuenta.getValor();//si estoy creando la extraccion lo sumo, sino lo resto
        c.setTotalExtracciones(valor);
    }

    public void updateFor(DepositoCuentaDomain dep) throws Exception {
        CuentaDomain c = dep.getCuentaFk();
        if (!cuentas.containsKey(c.getIdCuenta())) {
            cuentas.put(c.getIdCuenta(), c);
        } else {
            c = cuentas.get(c.getIdCuenta());
        }
        double valor = c.getTotalDepositos();
        valor += dep.getValor();//si estoy creando el deposito lo sumo, sino lo resto
        c.setTotalDepositos(valor);
    }

}
