/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.usecase_impl.graph;

import com.jhw.gestion.modules.contabilidad.core.domain.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.DepositoCuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.ExtraccionCuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.DepositoCuentaUseCase;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.ExtraccionCuentaUseCase;
import com.jhw.gestion.modules.contabilidad.core.usecase_impl.TipoExtraccionUseCaseImpl;
import com.jhw.utils.others.PairDifferent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DepositoCuentaDestroyGraph {

    private final List<PairDifferent<DepositoCuentaDomain, ExtraccionCuentaDomain>> extracciones_depositos = new ArrayList<>();
    private final Map<Integer, CuentaDomain> cuentas = new HashMap<>();

    public static DepositoCuentaDestroyGraph exec(DepositoCuentaDomain deposito) throws Exception {
        DepositoCuentaDestroyGraph thiss = new DepositoCuentaDestroyGraph();
        thiss.execute(deposito);
        return thiss;
    }

    public List<PairDifferent<DepositoCuentaDomain, ExtraccionCuentaDomain>> getExtracciones_depositos() {
        return extracciones_depositos;
    }

    public List<CuentaDomain> getCuentas() {
        return new ArrayList<>(cuentas.values());
    }

    private void execute(DepositoCuentaDomain depositoPadre) throws Exception {
        ExtraccionCuentaUseCase extraccionUC = ContabilidadCoreModule.getInstance().getImplementation(ExtraccionCuentaUseCase.class);

        for (DepositoCuentaDomain dep : ContabilidadCoreModule.getInstance().getImplementation(DepositoCuentaUseCase.class).findSubDepositos(depositoPadre)) {
            ExtraccionCuentaDomain ext = extraccionUC.findExtraccionSingle(
                    TipoExtraccionUseCaseImpl.EXTRACCION_DEPOSITO_SUB_CUENTA,
                    dep.getIdDepositoCuenta());
            extracciones_depositos.add(new PairDifferent<>(dep, ext));
            updateFor(dep);
            updateFor(ext);
        }

    }

    public void updateFor(ExtraccionCuentaDomain extraccionCuenta) throws Exception {
        if (extraccionCuenta == null) {
            return;
        }
        CuentaDomain c = extraccionCuenta.getCuentaFk();
        if (!cuentas.containsKey(c.getIdCuenta())) {
            cuentas.put(c.getIdCuenta(), c);
        } else {
            c = cuentas.get(c.getIdCuenta());
        }
        double valor = c.getTotalExtracciones();
        valor -= extraccionCuenta.getValor();//si estoy creando la extraccion lo sumo, sino lo resto
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
        valor -= dep.getValor();//si estoy creando el deposito lo sumo, sino lo resto
        c.setTotalDepositos(valor);
    }

}
