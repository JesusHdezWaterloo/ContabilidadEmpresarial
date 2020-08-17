/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.ui.cuenta;

import com.jhw.gestion.modules.contabilidad.core.domain.Cuenta;
import com.jhw.swing.material.components.button.prepared._buttonAddEdit;
import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.swing.material.components.scrollpane._MaterialScrollPaneCore;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class CuentaDetailMainPanel<T extends Cuenta> extends _MaterialPanel implements Update {

    public CuentaDetailMainPanel() {
        initComponents();
        addListeners();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        this.setBorder(new EmptyBorder(
                MaterialShadow.OFFSET_TOP + 10,
                MaterialShadow.OFFSET_LEFT + 10,
                MaterialShadow.OFFSET_BOTTOM + 10,
                MaterialShadow.OFFSET_RIGHT + 10));

        //actions
        _PanelTransparent header = new _PanelTransparent();
        header.setBorder(new EmptyBorder(0, 10, 0, 0));
        header.setLayout(new BorderLayout());
        labelHeader = new _MaterialLabel();
        labelHeader.setFont(MaterialFontRoboto.BOLD.deriveFont(30f));
        labelHeader.setText("Cuentas");
        header.add(labelHeader, BorderLayout.WEST);

        buttonAddEdit = new _buttonAddEdit();
        buttonAddEdit.isCreated(true);
        header.add(buttonAddEdit, BorderLayout.EAST);
        this.add(header, BorderLayout.NORTH);

        //panel cuentas
        panelCuentasSingle = new _PanelTransparent();

        _MaterialScrollPaneCore scroll = new _MaterialScrollPaneCore();
        scroll.remove(scroll.getHorizontalScrollBar());
        scroll.setViewportView(panelCuentasSingle);
        this.add(scroll);
        //this.add(panelCuentasSingle);
    }

    private _MaterialLabel labelHeader;
    private _buttonAddEdit buttonAddEdit;
    private _PanelTransparent panelCuentasSingle;

    public void setHeader(String text) {
        labelHeader.setText(text);
    }

    public void rellenarCuentas(List<T> cuentas) {
        panelCuentasSingle.removeAll();

        panelCuentasSingle.setLayout(new GridLayout(cuentas.size() / 4 + 1, 0));
        for (T c : cuentas) {
            panelCuentasSingle.add(buildSingle(c));
        }
        this.revalidate();
    }

    protected abstract CuentaSinglePanel buildSingle(T cuenta);

    private void addListeners() {
        buttonAddEdit.addActionListener((ActionEvent e) -> {
            createAction();
        });
    }

    public abstract void createAction();

}
