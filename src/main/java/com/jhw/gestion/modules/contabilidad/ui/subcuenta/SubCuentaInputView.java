package com.jhw.gestion.modules.contabilidad.ui.subcuenta;

import com.jhw.gestion.modules.contabilidad.core.domain.CuentaDomain;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.SubcuentaDomain;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class SubCuentaInputView extends CleanCRUDInputView<SubcuentaDomain> {

    private CuentaDomain c;

    public SubCuentaInputView(CuentaDomain padre) {
        super(null, ContabilidadSwingModule.subcuentaUC, SubcuentaDomain.class);
        this.c = padre;
        initComponents();
        update();
    }

    public SubCuentaInputView(SubcuentaDomain model) {
        super(model, ContabilidadSwingModule.subcuentaUC, SubcuentaDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {

        cuentaICBS = new com.jhw.gestion.modules.contabilidad.ui.cuenta.CuentaICBS();
        labelPadre = new com.jhw.swing.material.components.labels._MaterialLabel();
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        cuentaICBS.setLabel("Cuenta hijo");

        setHeader("Nueva SubCuenta", "Editar SubCuenta");

        labelPadre.setText("Padre");
        labelPadre.setFont(com.jhw.swing.material.standards.MaterialFontRoboto.BOLD.deriveFont(28f)); // NOI18N

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(labelPadre);
        vlc.add(cuentaICBS);
        vlc.add(textAreaDescripcion, true);
        setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.gestion.modules.contabilidad.ui.cuenta.CuentaICBS cuentaICBS;
    private com.jhw.swing.material.components.labels._MaterialLabel labelPadre;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public void update() {
        super.update();
        if (getOldModel() == null) {
            labelPadre.setText("Padre: " + c);
        } else {
            labelPadre.setText("Padre: " + getOldModel());
        }
    }

    @Override
    public SubcuentaDomain getNewModel() throws Exception {
        SubcuentaDomain sub = super.getNewModel();
        if (getOldModel() == null) {
            sub.setCuentaPadreFk(c);
        }
        return sub;
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("cuentaHijoFk", cuentaICBS);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }

}
