package com.jhw.gestion.modules.contabilidad.ui.liquidacion;

import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.CuadreICBS;
import com.jhw.gestion.modules.contabilidad.ui.cuenta_bancaria.CuentaBancariaICBS;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.datepicker._MaterialDatePicker;
import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.swing.material.components.labels.prepared.*;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class LiquidacionInputView extends CleanCRUDInputView<LiquidacionDomain> {

    public LiquidacionInputView() {
        this(null);
    }

    public LiquidacionInputView(LiquidacionDomain model) {
        super(model, ContabilidadSwingModule.liquicadionUC, LiquidacionDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Liquidación", "Editar Liquidación");

        //tipo
        textFieldDocumento = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldDocumento.setLabel("Documento");
        textFieldDocumento.setHint("Factura o Transacción asociada");

        //compra
        textFieldNombre = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldNombre.setHint("Nombre");
        textFieldNombre.setLabel("Nombre de la Liquidación");

        //debito
        _MaterialLabel labelDebito = new _MaterialLabel();
        labelDebito.setText("Débito");
        labelDebitoValue = new _labelPositive();

        //credito
        _MaterialLabel labelCredito = new _MaterialLabel();
        labelCredito.setText("Crédito");

        labelCreditoValue = new _labelNegativo();

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
        vlc.add(textFieldDocumento);
        vlc.add(textFieldNombre);

        HorizontalLayoutContainer.builder hlDebito = HorizontalLayoutContainer.builder((int) labelDebito.getPreferredSize().getHeight());
        hlDebito.add(HorizontalLayoutComponent.builder(labelDebito).gapRight(5).build());
        hlDebito.add(HorizontalLayoutComponent.builder(labelDebitoValue).gapLeft(5).build());
        vlc.add(hlDebito.build());

        HorizontalLayoutContainer.builder hlCredito = HorizontalLayoutContainer.builder((int) labelCredito.getPreferredSize().getHeight());
        hlCredito.add(HorizontalLayoutComponent.builder(labelCredito).gapRight(5).build());
        hlCredito.add(HorizontalLayoutComponent.builder(labelCreditoValue).gapLeft(5).build());
        vlc.add(hlCredito.build());

        vlc.add(datePickerFecha, true);
        vlc.add(cuadreICBS, true);
        vlc.add(cuentaICBS, true);

        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldDocumento;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldNombre;
    private _labelPositive labelDebitoValue;
    private _labelNegativo labelCreditoValue;
    private _MaterialDatePicker datePickerFecha;
    private CuentaBancariaICBS cuentaICBS;
    private CuadreICBS cuadreICBS;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public void update() {
        super.update();
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
}
