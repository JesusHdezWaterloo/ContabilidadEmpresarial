package com.jhw.gestion.modules.contabilidad.ui.cuenta;

import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;
import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.combobox.icbs.validated.ICBSNotEmptySeleccionable;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentaICBS extends ICBSNotEmptySeleccionable<CuentaDomain> {

    public CuentaICBS() {
        super("Cuenta");
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(ContabilidadSwingModule.cuentaBancariaUC.findAll());
    }

    @Override
    public ActionListener buttonAddAction() {
        return new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonAddActionPerformed();
            }
        };
    }

    private void onButtonAddActionPerformed() {
        new DialogInputCBS(this, new CuentaInputView(null));
    }
}
