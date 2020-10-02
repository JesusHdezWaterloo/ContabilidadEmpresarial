package com.jhw.gestion.modules.contabilidad.ui.cuenta_bancaria;

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
public class CuentaBancariaICBS extends InputComboBoxSelection<CuentaBancariaDomain> {

    public CuentaBancariaICBS() {
        setLabel("Cuenta bancaria");
        setIcon(ContabilidadModuleNavigator.ICON_CUENTA_BANCARIA);
    }

    @Override
    public List<CuentaBancariaDomain> getList() throws Exception{
        return ContabilidadSwingModule.cuentaBancariaUC.findAll();
    }

    @Override
    public ModelPanel<CuentaBancariaDomain> inputPanel() {
        return CuentaBancariaInputView.from();
    }

    @Override
    protected void addPropertyChange() {
        ContabilidadSwingModule.cuentaBancariaUC.addPropertyChangeListener(this);
    }
}
