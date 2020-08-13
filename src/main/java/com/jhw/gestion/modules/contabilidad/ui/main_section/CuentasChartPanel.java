package com.jhw.gestion.modules.contabilidad.ui.main_section;

import com.clean.core.app.services.ExceptionHandler;
import java.util.List;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.utils.interfaces.Update;
import com.jaga.swing.chart._MaterialBarChart;
import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.old.MonedaDomain;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.utils.others.Misc;
import java.util.ArrayList;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentasChartPanel extends _MaterialBarChart implements Update {

    public CuentasChartPanel() {
        addCategory("Depositos", MaterialColors.GREENA_700);
        addCategory("Extracciones", MaterialColors.REDA_700);

        //coje una moneda para convertilas todas
        MonedaDomain monBase = MonedaHandler.getMonedaBase();
        if (monBase == null) {
            return;
        }

        this.setChartTitle("Balances de cuentas (Conversión a " + monBase + ")");
        update();
    }

    @Override
    public void update() {
        try {
            removeAllBars();
            List<CuentaDomain> cta = ContabilidadSwingModule.cuentaUC.findAll();
            //coje una moneda para convertilas todas
            MonedaDomain monBase = MonedaHandler.getMonedaBase();
            if (monBase == null) {
                return;
            }

            for (CuentaDomain g : cta) {
                addBar(MonedaHandler.venta(Misc.round2f(g.getTotalDepositos()), g.getMonedaFk(), monBase), 0, g.getNombreCuenta());
            }
            for (CuentaDomain g : cta) {
                addBar(MonedaHandler.compra(Misc.round2f(g.getTotalExtracciones()), g.getMonedaFk(), monBase), 1, g.getNombreCuenta());
            }
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

}
