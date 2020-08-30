package com.jhw.gestion.modules.contabilidad.ui.cuadre;

import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.gestion.modules.contabilidad.core.domain.*;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuadreICBS extends InputComboBoxSelection<CuadreDomain> {

    public CuadreICBS() {
        super("Cuadre");
    }

    @Override
    public void updateComboBox() throws Exception {
        setModel(ContabilidadSwingModule.cuadreUC.findAllPending());
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
        //new DialogInputCBS(this, new MonedaInputView());
    }
}
