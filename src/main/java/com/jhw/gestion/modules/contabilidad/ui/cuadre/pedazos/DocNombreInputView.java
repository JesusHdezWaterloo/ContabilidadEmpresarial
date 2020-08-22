package com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos;

import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.DocNombreUI;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class DocNombreInputView extends CleanCRUDInputView<DocNombreUI> {

    public DocNombreInputView() {
        this(null);
    }

    private DocNombreInputView(DocNombreUI model) {
        super(model, null, DocNombreUI.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("", "");

        //compra
        textFieldNombre = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldNombre.setHint("Nombre");
        textFieldNombre.setLabel("Nombre de la Operación");

        //doc
        textFieldDocumento = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldDocumento.setLabel("Documento");
        textFieldDocumento.setHint("Factura o Transacción asociada");

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombre);
        vlc.add(textFieldDocumento);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldNombre;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldDocumento;
    // End of variables declaration                   

    /*@Override
    public void update() {
        if (getOldModel() != null) {
            textFieldDocumento.setText(getOldModel().getDocumento());
            textFieldNombre.setText(getOldModel().getNombre());
        }
    }

    @Override
    public DocNombreUI getNewModel() throws Exception {
        return new DocNombreUI(textFieldNombre.getText(), textFieldDocumento.getText());
    }*/

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombre", textFieldNombre);
        bindFields.put("documento", textFieldDocumento);
        return bindFields;
    }
}
