package com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos;

import com.jhw.gestion.modules.contabilidad.core.domain.TipoOperacionContableDomain;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.OperacionCuadreUI;
import com.jhw.gestion.modules.contabilidad.ui.cuenta_contable.CuentaContableICBS;
import com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.textfield.validated._MaterialTextFieldMoney;
import java.awt.event.ActionEvent;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class OperacionCuadreInputView extends CleanCRUDInputView<OperacionCuadreUI> {

    public OperacionCuadreInputView() {
        this((OperacionCuadreUI) null);
    }

    public OperacionCuadreInputView(TipoOperacionContableDomain opDefecto) {
        this((OperacionCuadreUI) null);
        setTipoOp(opDefecto);
    }

    public OperacionCuadreInputView(OperacionCuadreUI model) {
        super(model, null, OperacionCuadreUI.class);
        initComponents();
        addListeners();
        update();
    }

    private void initComponents() {
        textFieldValor = new _MaterialTextFieldMoney();
        textFieldValor.setLabel("Valor");
        textFieldValor.setHint("Valor de la operación");
        moneda = new MonedaICBS();

        //cuenta
        cuentaICBS = new CuentaContableICBS();
        cuentaICBS.setLabel("Cuenta Inicial");

        //cuadre
        cuentaCuadreICBS = new CuentaContableICBS();
        cuentaCuadreICBS.setLabel("Cuenta Cuadre");

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        HorizontalLayoutContainer.builder hlcDebito = HorizontalLayoutContainer.builder((int) textFieldValor.getPreferredSize().getHeight());
        hlcDebito.add(HorizontalLayoutComponent.builder(textFieldValor).gapRight(5).build());
        hlcDebito.add(HorizontalLayoutComponent.builder(moneda).gapLeft(5).build());
        vlc.add(hlcDebito.build());

        vlc.add(cuentaICBS);
        vlc.add(cuentaCuadreICBS);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private _MaterialTextFieldMoney textFieldValor;
    private MonedaICBS moneda;
    private CuentaContableICBS cuentaICBS;
    private CuentaContableICBS cuentaCuadreICBS;
    // End of variables declaration                   

    @Override
    public void setObject(OperacionCuadreUI t) {
        setOldModel(t);
        update();
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("valor", textFieldValor);
        bindFields.put("moneda", moneda);
        bindFields.put("cuenta", cuentaICBS);
        bindFields.put("cuadre", cuentaCuadreICBS);
        return bindFields;
    }

    private void addListeners() {
        cuentaICBS.getComboBox().addActionListener((ActionEvent e) -> {
            updateCuadreICBS();
        });
    }

    private void updateCuadreICBS() {
        try {
            cuentaCuadreICBS.updateComboBoxCuadre(cuentaICBS.getSelectedItem().getTipoCuentaFk());
        } catch (Exception e) {
        }
    }

    public void setTipoOp(TipoOperacionContableDomain opDefecto) {
        if (opDefecto != null) {
            this.cuentaICBS.setMatchingItem(opDefecto.getTipoCuentaDefectoFk());
            this.cuentaCuadreICBS.setMatchingItem(opDefecto.getTipoCuentaCuadreDefectoFk());
        }
    }

    public MonedaICBS getMoneda() {
        return moneda;
    }

    public CuentaContableICBS getCuentaICBS() {
        return cuentaICBS;
    }

    public CuentaContableICBS getCuentaCuadreICBS() {
        return cuentaCuadreICBS;
    }

    public _MaterialTextFieldMoney getTextFieldValor() {
        return textFieldValor;
    }
}
