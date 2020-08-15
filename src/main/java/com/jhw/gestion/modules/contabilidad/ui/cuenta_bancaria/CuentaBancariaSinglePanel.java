/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.ui.main_section;

import com.jhw.gestion.modules.contabilidad.core.domain.Cuenta;
import com.jhw.gestion.modules.contabilidad.core.domain.CuentaBancariaDomain;
import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.material.components.button.prepared._buttonView;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.swing.material.components.labels.prepared._labelDoubleMoney;
import com.jhw.swing.material.components.labels.prepared._labelDoubleMoneyNegative;
import com.jhw.swing.material.components.labels.prepared._labelDoubleMoneyPositive;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CuentaBancariaSinglePanel extends _MaterialPanel implements Update {

    private final Cuenta cuenta;

    public CuentaSinglePanel(Cuenta cuenta) {
        this.cuenta = cuenta;
        initComponents();
        addListeners();
        update();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        this.setBorder(new EmptyBorder(
                MaterialShadow.OFFSET_TOP,
                MaterialShadow.OFFSET_LEFT,
                MaterialShadow.OFFSET_BOTTOM,
                MaterialShadow.OFFSET_RIGHT));

        //actions
        _PanelTransparent actions = new _PanelTransparent();
        actions.setLayout(new BorderLayout());

        buttonEdit = new _MaterialButtonIconTransparent();
        buttonEdit.setIcon(MaterialIcons.EDIT);
        buttonEdit.setRippleColor(MaterialColors.BLUEA_400);
        actions.add(buttonEdit, BorderLayout.WEST);

        buttonView = new _buttonView();
        buttonView.setText("Detalles");
        actions.add(buttonView, BorderLayout.EAST);
        this.add(actions, BorderLayout.SOUTH);

        //background
        _PanelTransparent background = new _PanelTransparent();
        background.setLayout(new BorderLayout());
        background.setBorder(new EmptyBorder(5, 10, 0, 10));

        //nombre
        labelNombreCuenta = new _MaterialLabel();
        labelNombreCuenta.setFont(MaterialFontRoboto.BOLD.deriveFont(24f));
        background.add(labelNombreCuenta, BorderLayout.NORTH);

        debito = new _labelDoubleMoneyPositive();
        debito.setText("Débito");

        credito = new _labelDoubleMoneyNegative();
        credito.setText("Crédito");

        saldo = new _labelDoubleMoney();
        saldo.setText("Saldo");

        //center
        VerticalLayoutContainer.builder center = VerticalLayoutContainer.builder();
        center.add(debito, true);
        center.add(credito, true);
        center.add(saldo, true);

        background.add(center.build());

        this.add(background);
    }
    private _MaterialLabel labelNombreCuenta;

    private _labelDoubleMoneyPositive debito;
    private _labelDoubleMoneyNegative credito;
    private _labelDoubleMoney saldo;
    private _buttonView buttonView;
    private _MaterialButtonIconTransparent buttonEdit;

    private void addListeners() {
        buttonEdit.addActionListener((ActionEvent e) -> {
            editAction();
        });
        buttonView.addActionListener((ActionEvent e) -> {
            viewAction();
        });
    }

    private void editAction() {
    }

    private void viewAction() {
    }

    @Override
    public void update() {
        this.labelNombreCuenta.setText(cuenta.getCodigo() + " - " + cuenta.getNombreCuenta());
        this.debito.setMoney(cuenta.getDebito(), cuenta.getMonedaFk());
        this.credito.setMoney(cuenta.getCredito(), cuenta.getMonedaFk());
        this.saldo.setMoney(cuenta.saldo(), cuenta.getMonedaFk());
    }

}
