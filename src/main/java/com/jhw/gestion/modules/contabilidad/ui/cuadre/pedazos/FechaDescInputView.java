package com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos;

import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.FechaDescUI;
import com.jhw.gestion.modules.contabilidad.ui.forma_pago.FormaPagoICBS;
import com.jhw.swing.material.components.datepicker._MaterialDatePicker;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class FechaDescInputView extends CleanCRUDInputView<FechaDescUI> {

    public static FechaDescInputView from() {
        return new FechaDescInputView(null);
    }

    private FechaDescInputView(FechaDescUI model) {
        super(model, null, FechaDescUI.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("", "");

        //fecha
        datePickerFecha = new _MaterialDatePicker();
        datePickerFecha.setLabel("Fecha");

        //forma de pago
        formaPagoICBS = new FormaPagoICBS();

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(datePickerFecha);
        vlc.add(formaPagoICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private _MaterialDatePicker datePickerFecha;
    private FormaPagoICBS formaPagoICBS;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("fecha", datePickerFecha);
        bindFields.put("pago", formaPagoICBS);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
