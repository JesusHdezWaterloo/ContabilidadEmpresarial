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
import com.jhw.swing.material.components.searchfield._MaterialSearchField;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.swing.models.detail.HeaderDetailPanel;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.setBorder(new EmptyBorder(
                MaterialShadow.OFFSET_TOP + 10,
                MaterialShadow.OFFSET_LEFT + 10,
                MaterialShadow.OFFSET_BOTTOM + 10,
                MaterialShadow.OFFSET_RIGHT + 10));

        this.setLayout(new BorderLayout());

        header = new HeaderDetailPanel();
        panelCuentasSingle = new _PanelTransparent();

        this.add(header, BorderLayout.NORTH);

        //panel cuentas
        _MaterialScrollPaneCore scroll = new _MaterialScrollPaneCore();
        scroll.remove(scroll.getHorizontalScrollBar());
        scroll.setViewportView(panelCuentasSingle);
        this.add(scroll, BorderLayout.SOUTH);

        //this.add(panelCuentasSingle);
        //this.add(panelCuentasSingle,BorderLayout.SOUTH);
    }

    private HeaderDetailPanel header;
    private _PanelTransparent panelCuentasSingle;

    protected String getSearchText() {
        return header.getSearchText();
    }

    public void setHeader(String text) {
        header.setHeaderText(text);
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
        header.addButtonNuevoActionListener((ActionEvent e) -> {
            createAction();
        });
        header.setSearchActionListener((ActionEvent e) -> {
            update();
        });
    }

    public abstract void createAction();

}
