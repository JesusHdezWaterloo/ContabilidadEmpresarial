/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.ui.cuenta_bancaria;

import com.jhw.gestion.modules.contabilidad.core.domain.CuentaBancariaDomain;
import com.jhw.gestion.modules.contabilidad.ui.liquidacion.LiquidacionDetailView;
import com.jhw.gestion.modules.contabilidad.ui.cuenta.CuentaSinglePanel;
import com.jhw.swing.models.detail.DialogDetail;
import com.jhw.swing.models.input.dialogs.DialogModelInput;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CuentaBancariaSinglePanel extends CuentaSinglePanel {

    private final CuentaBancariaDomain cuenta;

    public CuentaBancariaSinglePanel(CuentaBancariaDomain cuenta) {
        super(cuenta);
        this.cuenta = cuenta;
    }

    @Override
    protected void viewAction() {
        new DialogDetail(this, "Liquidaciones", new LiquidacionDetailView(cuenta));
    }

    @Override
    protected void editAction() {
        new DialogModelInput(this, CuentaBancariaInputView.fromModel(cuenta));
    }

}
