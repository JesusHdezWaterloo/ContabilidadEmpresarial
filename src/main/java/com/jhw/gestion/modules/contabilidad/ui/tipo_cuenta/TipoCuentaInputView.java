package com.jhw.gestion.modules.contabilidad.ui.tipo_cuenta;

import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.swing.material.components.toggle._MaterialCheckBox;
import java.awt.CheckboxGroup;
import java.util.Map;
import javax.swing.JCheckBox;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoCuentaInputView extends CleanCRUDInputView<TipoCuentaDomain> {

    public TipoCuentaInputView() {
        this(null);
    }

    public TipoCuentaInputView(TipoCuentaDomain model) {
        super(model, ContabilidadSwingModule.tipoCuentaUC, TipoCuentaDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Tipo de Cuenta", "Editar Tipo de Cuenta");

        //tipo
        textFieldTipo = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldTipo.setLabel("Tipo de cuenta");
        textFieldTipo.setHint("Nombre del tipo de cuenta. Ej.: Cuenta por Pagar");

        //debito
        checkBoxDebito = new _MaterialCheckBox();
        checkBoxDebito.setText("Débito (Deseleccionado: Crédito)");

        //liquidable
        checkBoxLiquidable = new _MaterialCheckBox();
        checkBoxLiquidable.setText("Liquidable");

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldTipo);
        vlc.add(checkBoxDebito);
        vlc.add(checkBoxLiquidable);

        vlc.add(textAreaDescripcion, true);
        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldTipo;
    private _MaterialCheckBox checkBoxDebito;
    private _MaterialCheckBox checkBoxLiquidable;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreTipoCuenta", textFieldTipo);
        bindFields.put("debitoCredito", checkBoxDebito);
        bindFields.put("liquidable", checkBoxLiquidable);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
