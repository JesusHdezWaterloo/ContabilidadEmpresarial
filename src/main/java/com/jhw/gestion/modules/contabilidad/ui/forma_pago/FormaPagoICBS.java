package com.jhw.gestion.modules.contabilidad.ui.forma_pago;

import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadModuleNavigator;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class FormaPagoICBS extends InputComboBoxSelection<FormaPagoDomain> {

    public FormaPagoICBS() {
        setLabel("Forma de Pago");
        setIcon(ContabilidadModuleNavigator.ICON_FORMA_PAGO);
    }

    @Override
    public List<FormaPagoDomain> getList() throws Exception{
        return ContabilidadSwingModule.formaPagoUC.findAll();
    }

    @Override
    public ModelPanel<FormaPagoDomain> inputPanel() {
        return FormaPagoInputView.from();
    }

    @Override
    protected void addPropertyChange() {
        ContabilidadSwingModule.formaPagoUC.addPropertyChangeListener(this);
    }
}
