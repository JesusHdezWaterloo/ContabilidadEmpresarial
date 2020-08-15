package com.jhw.gestion.modules.contabilidad.ui.tipo_operacion;

import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoOperacionContableInputView extends CleanCRUDInputView<TipoOperacionContableDomain> {
    
    public TipoOperacionContableInputView() {
        this(null);
    }
    
    public TipoOperacionContableInputView(TipoOperacionContableDomain model) {
        super(model, ContabilidadSwingModule.tipoOperacionContableUC, TipoOperacionContableDomain.class);
        initComponents();
        update();
    }
    
    private void initComponents() {
        setHeader("Crear Tipo de Operación", "Editar Tipo de Operación");

        //tipo
        textFieldTipo = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldTipo.setLabel("Tipo de operación");
        textFieldTipo.setHint("Nombre del tipo de operación. Ej.: Gasto");

        //key
        textFieldKey = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldKey.setLabel("Key");
        textFieldKey.setHint("Key");

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();
        
        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldTipo);
        vlc.add(textFieldKey);
        vlc.add(textAreaDescripcion, true);
        
        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldTipo;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldKey;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public void update() {
        super.update();
        textFieldKey.setEnabled(getOldModel() == null);
    }
    
    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreOperacion", textFieldTipo);
        bindFields.put("keyEnum", textFieldKey);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
