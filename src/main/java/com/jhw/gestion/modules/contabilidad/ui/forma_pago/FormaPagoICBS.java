package com.jhw.gestion.modules.contabilidad.ui.forma_pago;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.material.components.combobox.icbs.validated.ICBSNotEmptySeleccionable;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class FormaPagoICBS extends ICBSNotEmptySeleccionable<FormaPagoDomain> {

    public FormaPagoICBS() {
        super("Tipo de Pago");
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(ContabilidadSwingModule.tipoPagoUC.findAll());
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
        new DialogInputCBS(this, new FormaPagoInputView());
    }
}
