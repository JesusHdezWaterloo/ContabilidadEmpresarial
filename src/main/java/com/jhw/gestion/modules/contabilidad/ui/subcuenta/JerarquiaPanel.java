package com.jhw.gestion.modules.contabilidad.ui.subcuenta;

import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class JerarquiaPanel extends javax.swing.JPanel {

    private final CuentaDomain c;

    public JerarquiaPanel(CuentaDomain c) {
        initComponents();
        this.c = c;
        personalize();
    }

    private void initComponents() {//TODO: Migrar Visual

        labelJerarquia = new com.jhw.swing.material.components.labels._MaterialLabel();
        panelSubcuentas = new com.jhw.swing.material.components.container.panel._PanelTransparent();

        setBackground(new java.awt.Color(255, 255, 255));

        labelJerarquia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJerarquia.setText("Jerarquía");
        labelJerarquia.setFont(com.jhw.swing.material.standards.MaterialFontRoboto.BOLD.deriveFont(24f)); // NOI18N

        panelSubcuentas.setLayout(new java.awt.GridLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelJerarquia, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelSubcuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelJerarquia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelSubcuentas, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }// </editor-fold>                        

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.labels._MaterialLabel labelJerarquia;
    private com.jhw.swing.material.components.container.panel._PanelTransparent panelSubcuentas;
    // End of variables declaration                   

    private void personalize() {
        panelSubcuentas.add(new SubcuentaPadresDetailView(c));
        panelSubcuentas.add(new SubcuentaHijosDetailView(c));
    }

}
