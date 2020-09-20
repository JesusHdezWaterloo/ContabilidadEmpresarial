package com.jhw.gestion.modules.contabilidad.ui.cuenta_contable;

import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadModuleNavigator;
import com.jhw.gestion.modules.contabilidad.ui.titular.TitularInputView;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentaContableICBS extends InputComboBoxSelection<CuentaContableDomain> {

    private List<CuentaContableDomain> actualList;

    public CuentaContableICBS() {
        setLabel("Cuenta Contable");
        setIcon(ContabilidadModuleNavigator.ICON_CUENTA_CONTABLE);
    }

    @Override
    public List<CuentaContableDomain> getList() throws Exception{
        actualList = ContabilidadSwingModule.cuentaContableUC.findAll();
        return actualList;
    }

    @Override
    public ModelPanel<CuentaContableDomain> inputPanel() {
        return CuentaContableInputView.from();
    }

    public void updateComboBoxCuenta(TipoCuentaDomain tipo) throws Exception {
        actualList = ContabilidadSwingModule.cuentaContableUC.findAllCuenta(tipo);
        setUpList(actualList);
    }

    public void updateComboBoxCuadre(TipoCuentaDomain tipo) throws Exception {
        actualList = ContabilidadSwingModule.cuentaContableUC.findAllCuadre(tipo);
        setUpList(actualList);
    }

    public void setMatchingItem(TipoCuentaDomain tipo, MonedaDomain moneda) {
        for (CuentaContableDomain c : actualList) {
            if (c.getTipoCuentaFk().equals(tipo) && c.getMonedaFk().equals(moneda)) {
                setObject(c);
                break;
            }
        }
    }

}
