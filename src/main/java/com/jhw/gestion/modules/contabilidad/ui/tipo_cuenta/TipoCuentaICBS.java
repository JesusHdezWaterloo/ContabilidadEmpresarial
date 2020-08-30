package com.jhw.gestion.modules.contabilidad.ui.tipo_cuenta;

import com.jhw.gestion.modules.contabilidad.ui.moneda.*;
import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.TipoCuentaDomain;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoCuentaICBS extends InputComboBoxSelection<TipoCuentaDomain> {

    public TipoCuentaICBS() {
        super("Tipo de cuenta");
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(ContabilidadSwingModule.tipoCuentaUC.findAll());
    }

    public void updateComboBoxCuadre(TipoCuentaDomain selectedItem)  throws Exception{
        setModel(ContabilidadSwingModule.tipoCuentaUC.findAllCuadre(selectedItem));
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
        new DialogInputCBS(this, new TipoCuentaInputView());
    }

}
