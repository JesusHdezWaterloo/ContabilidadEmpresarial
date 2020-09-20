package com.jhw.gestion.modules.contabilidad.ui.tipo_operacion;

import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.gestion.modules.contabilidad.core.domain.TipoOperacionContableDomain;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadModuleNavigator;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoOperacionContableICBS extends InputComboBoxSelection<TipoOperacionContableDomain> {

    public TipoOperacionContableICBS() {
        setLabel("Operación");
        setIcon(ContabilidadModuleNavigator.ICON_TIPO_OPERACION);
    }

    @Override
    public List<TipoOperacionContableDomain> getList() throws Exception{
        return ContabilidadSwingModule.tipoOperacionContableUC.findAll();
    }

    @Override
    public ModelPanel<TipoOperacionContableDomain> inputPanel() {
        return TipoOperacionContableInputView.from();
    }

}
