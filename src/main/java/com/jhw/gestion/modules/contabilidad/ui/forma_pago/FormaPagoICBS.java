package com.jhw.gestion.modules.contabilidad.ui.forma_pago;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadModuleNavigator;
import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class FormaPagoICBS extends InputComboBoxSelection<FormaPagoDomain> {

    public FormaPagoICBS() {
        super("Forma de Pago");
        setIcon(ContabilidadModuleNavigator.ICON_FORMA_PAGO);
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(ContabilidadSwingModule.formaPagoUC.findAll());
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
        new DialogInputCBS(this, FormaPagoInputView.from());
    }
}
