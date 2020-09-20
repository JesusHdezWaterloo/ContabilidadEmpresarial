package com.jhw.gestion.modules.contabilidad.ui.cuadre;

import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadModuleNavigator;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuadreICBS extends InputComboBoxSelection<CuadreDomain> {

    public CuadreICBS() {
        setLabel("Cuadre");
        setIcon(ContabilidadModuleNavigator.ICON_CUADRE);
    }

    @Override
    public List<CuadreDomain> getList() throws Exception {
        return ContabilidadSwingModule.cuadreUC.findAllPending();
    }

    @Override
    public ModelPanel<CuadreDomain> inputPanel() {
        return CuadreInputView.from();
    }

}
