package com.jhw.gestion.modules.contabilidad.ui.liquidacion;

import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.CuadreICBS;
import com.jhw.gestion.modules.contabilidad.ui.cuenta_bancaria.CuentaBancariaICBS;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.datepicker._MaterialDatePicker;
import com.jhw.swing.material.components.labels.prepared.*;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class LiquidacionInputView extends CleanCRUDInputView<LiquidacionDomain> {

    public static LiquidacionInputView fromBase(LiquidacionDomain base) {
        return new LiquidacionInputView(base, null);
    }

    public static LiquidacionInputView fromModel(LiquidacionDomain model) {
        return new LiquidacionInputView(null, model);
    }

    public static LiquidacionInputView from() {
        return new LiquidacionInputView(null, null);
    }

    private final LiquidacionDomain base;

    private LiquidacionInputView(LiquidacionDomain base, LiquidacionDomain model) {
        super(model, ContabilidadSwingModule.liquicadionUC, LiquidacionDomain.class);
        if (model != null) {
            this.base = model;
        } else {
            this.base = base;
        }
        initComponents();
        addListeners();
        update();
    }

    private void initComponents() {
        setHeader("Crear Liquidación", "Editar Liquidación");

        //nombre
        textFieldNombre = new com.jhw.swing.material.components.textfield._MaterialTextFieldIcon();
        textFieldNombre.setHint("Nombre");
        textFieldNombre.setLabel("Nombre de la Liquidación");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        //documento
        textFieldDocumento = new com.jhw.swing.material.components.textfield._MaterialTextFieldIcon();
        textFieldDocumento.setLabel("Documento");
        textFieldDocumento.setHint("Factura o Transacción asociada");
        textFieldDocumento.setIcon(MaterialIcons.DRAFTS);

        //debito
        labelDebitoValue = new _labelDoubleMoneyPositive();
        labelDebitoValue.setText("Débito");

        //credito
        labelCreditoValue = new _labelDoubleMoneyNegative();
        labelCreditoValue.setText("Crédito");

        //fecha
        datePickerFecha = new _MaterialDatePicker();
        datePickerFecha.setLabel("Fecha");

        //cuenta
        cuentaICBS = new CuentaBancariaICBS();

        //cuadre
        cuadreICBS = new CuadreICBS();

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombre);
        vlc.add(textFieldDocumento);

        vlc.add(labelDebitoValue);
        vlc.add(labelCreditoValue);

        vlc.add(datePickerFecha, true);
        vlc.add(cuadreICBS, true);
        vlc.add(cuentaICBS, true);

        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield._MaterialTextFieldIcon textFieldDocumento;
    private com.jhw.swing.material.components.textfield._MaterialTextFieldIcon textFieldNombre;
    private _labelDoubleMoneyPositive labelDebitoValue;
    private _labelDoubleMoneyNegative labelCreditoValue;
    private _MaterialDatePicker datePickerFecha;
    private CuentaBancariaICBS cuentaICBS;
    private CuadreICBS cuadreICBS;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public void update() {
        super.update();
        cuadreICBS.setEnabled(base == null);
        if (base == null) {
            labelCreditoValue.setMoney(BigDecimal.ZERO, "");
            labelDebitoValue.setMoney(BigDecimal.ZERO, "");
        } else {
            datePickerFecha.setDate(base.getFecha());
            cuadreICBS.setSelectedItem(base.getCuadreFk());
            cuentaICBS.setSelectedItem(base.getCuentaFk());
            textFieldNombre.setText(base.getNombre());
            labelCreditoValue.setMoney(base.getCredito(), base.getCuentaFk().getMonedaFk());
            labelDebitoValue.setMoney(base.getDebito(), base.getCuentaFk().getMonedaFk());
        }
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("documento", textFieldDocumento);
        bindFields.put("nombre", textFieldNombre);
        bindFields.put("fecha", datePickerFecha);
        bindFields.put("cuentaFk", cuentaICBS);
        bindFields.put("cuadreFk", cuadreICBS);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }

    private void addListeners() {
        cuadreICBS.getComboBox().addActionListener((ActionEvent e) -> {
            onCuadreICBSActionPerformed();
        });
    }

    private void onCuadreICBSActionPerformed() {
        try {
            CuadreDomain cuadre = cuadreICBS.getSelectedItem();
            labelCreditoValue.setMoney(cuadre.getOperacionContableFk().getDebito(), cuadre.getOperacionContableFk().getCuentaFk().getMonedaFk());
            labelDebitoValue.setMoney(cuadre.getOperacionContableFk().getCredito(), cuadre.getOperacionContableFk().getCuentaFk().getMonedaFk());
        } catch (Exception e) {
        }
    }
}
