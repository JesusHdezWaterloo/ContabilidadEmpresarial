package com.jhw.gestion.modules.contabilidad.ui.tipo_operacion;

import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.material.components.combobox.icbs.validated.ICBSNotEmptySeleccionable;
import com.jhw.gestion.modules.contabilidad.core.domain.TipoOperacionContableDomain;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoOperacionContableICBS extends ICBSNotEmptySeleccionable<TipoOperacionContableDomain> {

    public TipoOperacionContableICBS() {
        super("Operación");
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(ContabilidadSwingModule.tipoOperacionContableUC.findAll());
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
        new DialogInputCBS(this, new TipoOperacionContableInputView());
    }
}
