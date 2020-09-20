package com.jhw.gestion.modules.contabilidad.ui.moneda;

import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.TitularDomain;
import com.jhw.gestion.modules.contabilidad.ui.titular.TitularInputView;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class MonedaICBS extends InputComboBoxSelection<MonedaDomain> {

    public MonedaICBS() {
        setLabel("Moneda");
        setIcon(null);
    }

    @Override
    public List<MonedaDomain> getList() throws Exception{
        return ContabilidadSwingModule.monedaUC.findAll();
    }

    @Override
    public ModelPanel<MonedaDomain> inputPanel() {
        return MonedaInputView.from();
    }
}
