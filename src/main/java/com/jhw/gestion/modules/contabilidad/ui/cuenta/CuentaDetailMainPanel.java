/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.ui.cuenta;

import com.jhw.gestion.modules.contabilidad.core.domain.Cuenta;
import com.jhw.swing.material.components.button.prepared._buttonAddEdit;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.labels._MaterialLabel;
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
public class CuentaDetailMainPanel<T extends Cuenta> extends _PanelTransparent implements Update {

    public CuentaDetailMainPanel() {
        initComponents();
        addListeners();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        this.setBorder(new EmptyBorder(
                MaterialShadow.OFFSET_TOP,
                MaterialShadow.OFFSET_LEFT,
                MaterialShadow.OFFSET_BOTTOM,
                MaterialShadow.OFFSET_RIGHT));

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

        panelCuentasSingle = new _PanelTransparent();
        this.add(panelCuentasSingle);
    }

    private _MaterialLabel labelHeader;
    private _buttonAddEdit buttonAddEdit;
    private _PanelTransparent panelCuentasSingle;

    @Override
    public void update() {
    }

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

    protected CuentaSinglePanel buildSingle(T cuenta) {
        return new CuentaSinglePanel(cuenta);
    }

    private void addListeners() {
        buttonAddEdit.addActionListener((ActionEvent e) -> {
            createAction();
        });
    }

    public void createAction() {
    }

}
