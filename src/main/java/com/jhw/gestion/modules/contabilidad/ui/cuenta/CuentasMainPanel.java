/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.ui.cuenta;

import com.jhw.gestion.modules.contabilidad.ui.cuenta_bancaria.CuentaBancariaDetailMainPanel;
import com.jhw.gestion.modules.contabilidad.ui.cuenta_contable.CuentaContableDetailMainPanel;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CuentasMainPanel extends _PanelTransparent implements Update {

    public CuentasMainPanel() {
        initComponents();
        update();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        _PanelTransparent background = new _PanelTransparent();
        background.setLayout(new BorderLayout());

        //_MaterialScrollPaneCore scroll = new _MaterialScrollPaneCore();
        //scroll.setViewportView(background);
        this.add(background);

        cuentasBancarias = new CuentaBancariaDetailMainPanel();
        background.add(cuentasBancarias, BorderLayout.NORTH);

        cuentasContables = new CuentaContableDetailMainPanel();
        background.add(cuentasContables, BorderLayout.CENTER);
    }
    private CuentaBancariaDetailMainPanel cuentasBancarias;
    private CuentaContableDetailMainPanel cuentasContables;

    @Override
    public void update() {
        cuentasBancarias.update();
        cuentasContables.update();
    }
}