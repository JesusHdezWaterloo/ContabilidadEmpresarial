package com.jhw.gestion.modules.contabilidad.ui.cuenta_contable;

import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS;
import com.jhw.gestion.modules.contabilidad.ui.tipo_cuenta.TipoCuentaICBS;
import com.jhw.gestion.modules.contabilidad.ui.titular.TitularICBS;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentaContableInputView extends CleanCRUDInputView<CuentaContableDomain> {

    public CuentaContableInputView() {
        this(null);
    }

    public CuentaContableInputView(CuentaContableDomain model) {
        super(model, ContabilidadSwingModule.cuentaContableUC, CuentaContableDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        //header
        setHeader("Crear Cuenta Contable", "Editar Cuenta Cpntable");

        //nombre
        textFieldNombreCuenta = new com.jhw.swing.material.components.textfield._MaterialTextField();
        textFieldNombreCuenta.setLabel("Nombre");
        textFieldNombreCuenta.setHint("Nombre de la cuenta");

        //codigo
        textFieldCodigo = new com.jhw.swing.material.components.textfield._MaterialTextField();
        textFieldCodigo.setLabel("Código contable");
        textFieldCodigo.setHint("Código de identificación. Ej: 110");

        //moneda
        monedaICBS = new MonedaICBS();

        //tipo de cuenta
        tipoCuentaICBS = new TipoCuentaICBS();
        
        //titular
        titularICBS = new TitularICBS();

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombreCuenta);
        vlc.add(textFieldCodigo);
        vlc.add(monedaICBS);
        vlc.add(tipoCuentaICBS);
        vlc.add(titularICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldNombreCuenta;
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldCodigo;
    private MonedaICBS monedaICBS;
    private TipoCuentaICBS tipoCuentaICBS;
    private TitularICBS titularICBS;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreCuenta", textFieldNombreCuenta);
        bindFields.put("codigo", textFieldCodigo);
        bindFields.put("monedaFk", monedaICBS);
        bindFields.put("titularFk", titularICBS);
        bindFields.put("tipoCuentaFk", tipoCuentaICBS);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
