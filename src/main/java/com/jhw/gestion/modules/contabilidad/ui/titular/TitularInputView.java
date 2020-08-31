package com.jhw.gestion.modules.contabilidad.ui.titular;

import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.material.standards.MaterialIcons;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TitularInputView extends CleanCRUDInputView<TitularDomain> {

    public static TitularInputView from() {
        return new TitularInputView(null);
    }
    public static TitularInputView fromModel(TitularDomain model) {
        return new TitularInputView(model);
    }

    private TitularInputView(TitularDomain model) {
        super(model, ContabilidadSwingModule.titularUC, TitularDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Titular", "Editar Titular");

        //tipo
        textFieldNombre = new com.jhw.swing.material.components.textfield._MaterialTextFieldIcon();
        textFieldNombre.setLabel("Titular");
        textFieldNombre.setHint("Nombre del titilar");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombre);

        vlc.add(textAreaDescripcion, true);
        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield._MaterialTextFieldIcon textFieldNombre;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreTitular", textFieldNombre);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
