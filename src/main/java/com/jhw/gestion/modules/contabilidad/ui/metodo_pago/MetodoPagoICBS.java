package com.jhw.gestion.modules.contabilidad.ui.metodo_pago;

import com.jhw.gestion.modules.contabilidad.core.domain.old.MetodoPagoDomain;
import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.material.components.combobox.icbs.validated.ICBSNotEmptySeleccionable;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class MetodoPagoICBS extends ICBSNotEmptySeleccionable<MetodoPagoDomain> {

    public MetodoPagoICBS() {
        super("Método de Pago");
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(ContabilidadSwingModule.metodoPagoUC.findAll());
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
        new DialogInputCBS(this, new MetodoPagoInputView());
    }
}
