package com.jhw.gestion.modules.contabilidad.ui.tipo_cuenta;

import com.clean.core.exceptions.ValidationException;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.toggle.ToggleGroup;
import com.jhw.swing.material.components.toggle._MaterialCheckBox;
import java.util.Map;

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
        checkBoxDebito.setText("Débito");
        checkBoxDebito.setSelected(true);

        //credito
        checkBoxCredito = new _MaterialCheckBox();
        checkBoxCredito.setText("Crédito");

        ToggleGroup group = new ToggleGroup();
        group.add(checkBoxDebito);
        group.add(checkBoxCredito);

        //liquidable
        checkBoxLiquidable = new _MaterialCheckBox();
        checkBoxLiquidable.setText("Liquidable");

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldTipo);

        HorizontalLayoutContainer.builder hlcDebCred = HorizontalLayoutContainer.builder();
        hlcDebCred.add(checkBoxDebito);
        hlcDebCred.add(checkBoxCredito);
        vlc.add(hlcDebCred.build());
        
        vlc.add(checkBoxLiquidable);

        vlc.add(textAreaDescripcion, true);
        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldTipo;
    private _MaterialCheckBox checkBoxDebito;
    private _MaterialCheckBox checkBoxCredito;
    private _MaterialCheckBox checkBoxLiquidable;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public void update() {
        super.update();
        if (getOldModel() != null) {
            checkBoxDebito.setSelected(getOldModel().getDebitoCredito());
            checkBoxCredito.setSelected(!getOldModel().getDebitoCredito());
        }
    }

    @Override
    public TipoCuentaDomain getNewModel() throws Exception {
        TipoCuentaDomain m = super.getNewModel();
        if (!checkBoxDebito.isSelected() && !checkBoxCredito.isSelected()) {
            throw new ValidationException("La cuenta tiene que ser de débito o de crédito");
        }
        m.setDebitoCredito(checkBoxDebito.isSelected());
        return m;
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreTipoCuenta", textFieldTipo);
        bindFields.put("liquidable", checkBoxLiquidable);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
