package com.jhw.gestion.modules.contabilidad.ui.forma_pago;

import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class FormaPagoInputView extends CleanCRUDInputView<FormaPagoDomain> {

    public FormaPagoInputView() {
        this(null);
    }

    public FormaPagoInputView(FormaPagoDomain model) {
        super(model, ContabilidadSwingModule.formaPagoUC, FormaPagoDomain.class);
        initComponents();
        update();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        //header
        setHeader("Crear Tipo de Pago", "Editar Tipo de Pago");

        //nombre
        textFieldNombre = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldNombre.setLabel("Tipo de pago");
        textFieldNombre.setHint("Nombre del tipo de pago. Ej: Efectivo");

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(textFieldNombre);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldNombre;
    // End of variables declaration                   

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreFormaPago", textFieldNombre);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
