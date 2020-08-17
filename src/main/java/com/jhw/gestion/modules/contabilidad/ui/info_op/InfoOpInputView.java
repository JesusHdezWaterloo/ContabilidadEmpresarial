package com.jhw.gestion.modules.contabilidad.ui.info_op;

import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.forma_pago.FormaPagoICBS;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.datepicker._MaterialDatePicker;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class InfoOpInputView extends CleanCRUDInputView<InfoOperacionContableDomain> {

    public InfoOpInputView() {
        this(null);
    }

    private InfoOpInputView(InfoOperacionContableDomain model) {
        super(model, ContabilidadSwingModule.infoOpUC, InfoOperacionContableDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Información", "Información");

        //doc
        textFieldDocumento = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldDocumento.setLabel("Documento");
        textFieldDocumento.setHint("Factura o Transacción asociada");

        //compra
        textFieldNombre = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldNombre.setHint("Nombre");
        textFieldNombre.setLabel("Nombre de la Operación");

        //fecha
        datePickerFecha = new _MaterialDatePicker();
        datePickerFecha.setLabel("Fecha");

        //forma de pago
        formaPagoICBS = new FormaPagoICBS();

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldDocumento);
        vlc.add(textFieldNombre);
        vlc.add(datePickerFecha);
        vlc.add(formaPagoICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldDocumento;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldNombre;
    private _MaterialDatePicker datePickerFecha;
    private FormaPagoICBS formaPagoICBS;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("documento", textFieldDocumento);
        bindFields.put("nombre", textFieldNombre);
        bindFields.put("fecha", datePickerFecha);
        bindFields.put("descripcion", textAreaDescripcion);
        bindFields.put("formaPagoFk", formaPagoICBS);
        return bindFields;
    }
}
