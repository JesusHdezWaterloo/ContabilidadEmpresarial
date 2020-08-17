package com.jhw.gestion.modules.contabilidad.ui.cuenta_contable;

import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.material.components.combobox.icbs.validated.ICBSNotEmptySeleccionable;
import com.jhw.gestion.modules.contabilidad.core.domain.*;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentaContableICBS extends ICBSNotEmptySeleccionable<CuentaContableDomain> {

    public CuentaContableICBS() {
        super("Cuenta Contable");
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(ContabilidadSwingModule.cuentaContableUC.findAll());
    }

    public void updateComboBoxCuadre(TipoCuentaDomain tipo) throws Exception {
        setModel(ContabilidadSwingModule.cuentaContableUC.findAllCuadre(tipo));
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
        new DialogInputCBS(this, new CuentaContableInputView());
    }
}
