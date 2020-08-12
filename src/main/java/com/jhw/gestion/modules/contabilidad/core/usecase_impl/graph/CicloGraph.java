/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.usecase_impl.graph;

import com.jhw.gestion.modules.contabilidad.core.domain.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.SubcuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.CuentaUseCase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CicloGraph {

    private final Map<Integer, Boolean> visitado = new HashMap<>();
    private final HashMap<Integer, CuentaDomain> cuentas = new HashMap<>();
    private final HashMap<Integer, List<CuentaDomain>> aristas = new HashMap<>();
    private boolean cicle = false;

    private final CuentaUseCase cuentaUC = ContabilidadCoreModule.getInstance().getImplementation(CuentaUseCase.class);

    private CicloGraph() {
    }

    public static boolean exec(SubcuentaDomain sub) throws Exception {
        return new CicloGraph().containCicle(sub);
    }

    private boolean containCicle(SubcuentaDomain sub) throws Exception {
        buildGraph(sub);
        for (CuentaDomain cuenta : cuentas.values()) {
            visit(cuenta);
        }
        return cicle;
    }

    private void visit(CuentaDomain cuentaActual) {
        if (visitado.get(cuentaActual.getIdCuenta())) {
            cicle = true;
            return;
        }
        visitado.put(cuentaActual.getIdCuenta(), true);
        for (CuentaDomain hijo : aristas.get(cuentaActual.getIdCuenta())) {
            visit(hijo);
        }
    }

    private void buildGraph(SubcuentaDomain sub) throws Exception {
        for (CuentaDomain cuenta : cuentaUC.findAll()) {
            cuentas.put(cuenta.getIdCuenta(), cuenta);
            aristas.put(cuenta.getIdCuenta(), cuentaUC.findCuentasHijoDelPadre(cuenta));
        }
        List<CuentaDomain> ar = aristas.get(sub.getCuentaPadreFk().getIdCuenta());
        ar.add(sub.getCuentaHijoFk());
        aristas.put(sub.getCuentaPadreFk().getIdCuenta(), ar);
    }
}
