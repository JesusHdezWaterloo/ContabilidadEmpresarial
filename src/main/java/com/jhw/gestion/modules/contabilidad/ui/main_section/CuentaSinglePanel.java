package com.jhw.gestion.modules.contabilidad.ui.main_section;

import com.jhw.gestion.modules.contabilidad.core.domain.CuentaDomain;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.gestion.modules.contabilidad.ui.cuenta.mix.CuentaInputMIXView;
import com.jhw.swing.models.input.dialogs.DialogModelMixInput;
import com.jhw.utils.interfaces.Update;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentaSinglePanel extends _MaterialPanel implements Update {

    private final CuentaDomain cuenta;

    public CuentaSinglePanel(CuentaDomain cuenta) {
        this.cuenta = cuenta;
        initComponents();
        addListeners();
        personalize();
        update();
    }

    private void initComponents() {//TODO: Migrar Visual

        labelCuenta = new com.jhw.swing.material.components.labels._MaterialLabel();
        labelPorciento = new com.jhw.swing.material.components.labels._MaterialLabel();
        labelSaldo = new com.jhw.swing.material.components.labels.prepared._labelPositive();
        buttonViewCuenta = new com.jhw.swing.material.components.button.prepared._buttonView();

        labelCuenta.setText("Cuenta");
        labelCuenta.setFont(com.jhw.swing.material.standards.MaterialFontRoboto.BOLD.deriveFont(24f)); // NOI18N

        labelPorciento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPorciento.setText("%");
        labelPorciento.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N

        labelSaldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSaldo.setText("Saldo");
        labelSaldo.setFont(com.jhw.swing.material.standards.MaterialFontRoboto.BOLD.deriveFont(28f)); // NOI18N

        buttonViewCuenta.setText("Ver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(labelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(labelCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                                .addComponent(labelPorciento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonViewCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelPorciento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(labelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonViewCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }                       

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.button.prepared._buttonView buttonViewCuenta;
    private com.jhw.swing.material.components.labels._MaterialLabel labelCuenta;
    private com.jhw.swing.material.components.labels._MaterialLabel labelPorciento;
    private com.jhw.swing.material.components.labels.prepared._labelPositive labelSaldo;
    // End of variables declaration                   

    @Override
    public void update() {

        labelCuenta.setText(cuenta.getNombreCuenta());
        labelSaldo.setMoney(cuenta.saldo(), cuenta.getMonedaFk().getTipoMoneda());

        labelPorciento.setText(cuenta.getPorciento() + "%");
    }

    private void personalize() {
        buttonViewCuenta.setBackground(MaterialColors.BLUEGREY_800);
    }

    private void addListeners() {
        buttonViewCuenta.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onButtonAddCuentaMouseClicked();
            }
        });
    }

    private void onButtonAddCuentaMouseClicked() {
        new DialogModelMixInput<CuentaDomain>((Update) this.getParent().getParent().getParent(), new CuentaInputMIXView(cuenta));
    }
}
