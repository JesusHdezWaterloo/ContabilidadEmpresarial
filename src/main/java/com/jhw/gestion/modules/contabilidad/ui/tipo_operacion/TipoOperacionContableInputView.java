package com.jhw.gestion.modules.contabilidad.ui.tipo_operacion;

import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.cuenta_contable.CuentaContableICBS;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.gestion.modules.contabilidad.ui.tipo_cuenta.TipoCuentaICBS;
import java.awt.event.ActionEvent;
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
        addListeners();
        update();
    }

    private void initComponents() {
        setHeader("Crear Tipo de Operación", "Editar Tipo de Operación");

        //tipo
        textFieldTipo = new com.jhw.swing.material.components.textfield._MaterialTextField();
        textFieldTipo.setLabel("Tipo de operación");
        textFieldTipo.setHint("Nombre del tipo de operación. Ej.: Gasto");

        //key
        textFieldKey = new com.jhw.swing.material.components.textfield._MaterialTextField();
        textFieldKey.setLabel("Key");
        textFieldKey.setHint("Key");

        //cuenta
        cuentaDefecto = new TipoCuentaICBS();
        cuentaDefecto.setLabel("Cuenta por defecto");

        //cuadre
        cuentaDefectoCuadre = new TipoCuentaICBS();
        cuentaDefectoCuadre.setLabel("Cuenta  de cuadre por defecto");

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldTipo);
        vlc.add(textFieldKey);
        vlc.add(cuentaDefecto);
        vlc.add(cuentaDefectoCuadre);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldTipo;
    private TipoCuentaICBS cuentaDefecto;
    private TipoCuentaICBS cuentaDefectoCuadre;
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldKey;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public void update() {
        super.update();
        textFieldKey.setEnabled(getOldModel() == null);
    }

    @Override
    public TipoOperacionContableDomain getNewModel() throws Exception {
        return super.getNewModel(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreOperacion", textFieldTipo);
        bindFields.put("keyEnum", textFieldKey);
        bindFields.put("tipoCuentaDefectoFk", cuentaDefecto);
        bindFields.put("tipoCuentaCuadreDefectoFk", cuentaDefectoCuadre);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }

    private void addListeners() {
        cuentaDefecto.getComboBox().addActionListener((ActionEvent e) -> {
            updateCuadreICBS();
        });
    }

    private void updateCuadreICBS() {
        try {
            cuentaDefectoCuadre.updateComboBoxCuadre(cuentaDefecto.getSelectedItem());
        } catch (Exception e) {
        }
    }
}
