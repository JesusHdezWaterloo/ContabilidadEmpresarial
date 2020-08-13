package com.jhw.gestion.modules.contabilidad.ui.cuenta.mix;

import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;
import com.jhw.swing.models.input.panels.ModelMixPanel;
import com.jhw.gestion.modules.contabilidad.ui.cuenta.CuentaInputView;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentaInputMIXView extends ModelMixPanel {

    private final CuentaDomain cuenta;

    public CuentaInputMIXView(CuentaDomain cta) {
        super();
        this.cuenta = cta;
        init();
    }

    private void init() {
        CuentaInputView ctaIV = new CuentaInputView(cuenta);
        this.setModelPanel(ctaIV);

        DepositosDetailView depDV = new DepositosDetailView(ctaIV);
        this.addExtra(depDV);

        ExtraccionesDetailView extDV = new ExtraccionesDetailView(ctaIV);
        this.addExtra(extDV);

    }

}
