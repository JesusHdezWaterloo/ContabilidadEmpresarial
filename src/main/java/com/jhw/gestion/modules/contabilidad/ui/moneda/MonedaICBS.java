package com.jhw.gestion.modules.contabilidad.ui.moneda;

import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class MonedaICBS extends InputComboBoxSelection<MonedaDomain> {

    public MonedaICBS() {
        super("Moneda");
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(ContabilidadSwingModule.monedaUC.findAll());
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
        new DialogInputCBS(this, MonedaInputView.from());
    }
}
