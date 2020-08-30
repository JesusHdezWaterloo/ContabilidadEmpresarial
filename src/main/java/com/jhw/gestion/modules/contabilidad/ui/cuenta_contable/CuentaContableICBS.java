package com.jhw.gestion.modules.contabilidad.ui.cuenta_contable;

import java.awt.event.ActionListener;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.models.input.dialogs.DialogInputCBS;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentaContableICBS extends InputComboBoxSelection<CuentaContableDomain> {
    
    private List<CuentaContableDomain> actualList;
    
    public CuentaContableICBS() {
        super("Cuenta Contable");
    }
    
    @Override
    public void updateComboBox() throws Exception {
        actualList = ContabilidadSwingModule.cuentaContableUC.findAll();
        setModel(actualList);
    }
    
    public void updateComboBoxCuenta(TipoCuentaDomain tipo) throws Exception {
        actualList = ContabilidadSwingModule.cuentaContableUC.findAllCuenta(tipo);
        setModel(actualList);
    }
    
    public void updateComboBoxCuadre(TipoCuentaDomain tipo) throws Exception {
        actualList = ContabilidadSwingModule.cuentaContableUC.findAllCuadre(tipo);
        setModel(actualList);
    }
    
    public void setMatchingItem(TipoCuentaDomain tipo, MonedaDomain moneda) {
        for (CuentaContableDomain c : actualList) {
            if (c.getTipoCuentaFk().equals(tipo) && c.getMonedaFk().equals(moneda)) {
                setSelectedItem(c);
                break;
            }
        }
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
        new DialogInputCBS(this, new CuentaContableInputView());
    }
}
