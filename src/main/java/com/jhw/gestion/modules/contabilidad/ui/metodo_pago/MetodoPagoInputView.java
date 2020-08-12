package com.jhw.gestion.modules.contabilidad.ui.metodo_pago;

import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.MetodoPagoDomain;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class MetodoPagoInputView extends CleanCRUDInputView<MetodoPagoDomain> {

    public MetodoPagoInputView() {
        this(null);
    }

    public MetodoPagoInputView(MetodoPagoDomain model) {
        super(model, ContabilidadSwingModule.metodoPagoUC, MetodoPagoDomain.class);
        initComponents();
        update();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        textFieldNombre = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        setHeader("Nuevo Tipo de Pago", "Editar Tipo de Pago");

        textFieldNombre.setHint("Nombre del tipo de pago. Ej.: Efectivo");
        textFieldNombre.setLabel("Tipo de pago");

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder(300);

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
        bindFields.put("nombreMetodoPago", textFieldNombre);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
