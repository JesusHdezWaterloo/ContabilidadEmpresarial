/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.ui.cuenta_contable;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.gestion.modules.contabilidad.ui.cuenta.CuentaDetailMainPanel;
import com.jhw.gestion.modules.contabilidad.ui.cuenta.CuentaSinglePanel;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogModelInput;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CuentaContableDetailMainPanel extends CuentaDetailMainPanel<CuentaContableDomain> {

    public CuentaContableDetailMainPanel() {
        setHeader("Cuentas Contables");
    }

    @Override
    public void createAction() {
        new DialogModelInput(this, new CuentaContableInputView());
    }

    @Override
    public void update() {
        try {
            rellenarCuentas(ContabilidadSwingModule.cuentaContableUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    protected CuentaSinglePanel buildSingle(CuentaContableDomain cuenta) {
        return new CuentaContableSinglePanel(cuenta);
    }

}
