package com.jhw.gestion.modules.contabilidad.ui.main_section;

import com.jhw.gestion.modules.contabilidad.core.domain.CuentaDomain;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.utils.interfaces.Update;
import com.jhw.swing.models.input.dialogs.DialogModelMixInput;
import java.awt.GridLayout;
import java.util.List;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.Cuenta;
import com.jhw.gestion.modules.contabilidad.core.usecase_impl.CuentaUseCaseImpl;
import com.jhw.gestion.modules.contabilidad.ui.cuenta.mix.CuentaInputMIXView;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentasMainPanel extends javax.swing.JPanel implements Update {

    private final CuentasChartPanel chart = new CuentasChartPanel();

    public CuentasMainPanel() {
        initComponents();
        addListeners();
        personalize();
        update();
    }

    private void initComponents() {//TODO: Migrar Visual

        panelChart = new com.jhw.swing.material.components.container.panel._PanelComponent();
        panelBackground = new com.jhw.swing.material.components.container.panel._MaterialPanel();
        panelCuentas = new com.jhw.swing.material.components.container.panel._PanelTransparent();
        buttonAddCuenta = new com.jhw.swing.material.components.button.prepared._buttonAddEdit();
        labelCuentas = new com.jhw.swing.material.components.labels._MaterialLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelChartLayout = new javax.swing.GroupLayout(panelChart);
        panelChart.setLayout(panelChartLayout);
        panelChartLayout.setHorizontalGroup(
                panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        panelChartLayout.setVerticalGroup(
                panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 89, Short.MAX_VALUE)
        );

        panelCuentas.setLayout(new java.awt.GridLayout(1, 0));

        buttonAddCuenta.setText("Nuevo");

        labelCuentas.setText("Cuentas");
        labelCuentas.setFont(com.jhw.swing.material.standards.MaterialFontRoboto.BOLD.deriveFont(24f)); // NOI18N

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
                panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBackgroundLayout.createSequentialGroup()
                                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelBackgroundLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(panelCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelBackgroundLayout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(labelCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
                                                .addComponent(buttonAddCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        panelBackgroundLayout.setVerticalGroup(
                panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackgroundLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonAddCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.button.prepared._buttonAddEdit buttonAddCuenta;
    private com.jhw.swing.material.components.labels._MaterialLabel labelCuentas;
    private com.jhw.swing.material.components.container.panel._MaterialPanel panelBackground;
    private com.jhw.swing.material.components.container.panel._PanelComponent panelChart;
    private com.jhw.swing.material.components.container.panel._PanelTransparent panelCuentas;
    // End of variables declaration                   

    @Override
    public void update() {
        rellenarCuentas();
        chart.update();
    }

    private void personalize() {
        panelChart.setComponent(chart);
        this.labelCuentas.setForeground(this.panelBackground.getForeground());
        panelBackground.setBackground(MaterialColors.GREY_200);
    }

    private void addListeners() {
        buttonAddCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onButtonAddCuentaMouseClicked();
            }
        });
    }

    private void onButtonAddCuentaMouseClicked() {
        new DialogModelMixInput<Cuenta>(this, new CuentaInputMIXView(null));
    }

    private void rellenarCuentas() {
        try {
            List<CuentaDomain> cuentas = ContabilidadSwingModule.cuentaUC.findAll();
            panelCuentas.removeAll();

            panelCuentas.setLayout(new GridLayout(cuentas.size() / 4 + 1, 0));
            for (CuentaDomain c : cuentas) {
                panelCuentas.add(new CuentaSinglePanel(c));
            }
            this.revalidate();
        } catch (Exception e) {
        }
    }

}
