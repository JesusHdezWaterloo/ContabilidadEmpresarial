package com.jhw.gestion.modules.contabilidad.ui.cuenta_bancaria;

import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadModuleNavigator;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS;
import com.jhw.swing.material.components.textarea.MaterialTextArea;
import com.jhw.swing.material.components.textarea.MaterialTextAreaFactory;
import com.jhw.swing.material.components.textfield.MaterialFormatedTextField;
import com.jhw.swing.material.components.textfield.MaterialFormatedTextFieldIcon;
import com.jhw.swing.material.components.textfield.MaterialTextFactory;
import com.jhw.swing.material.components.textfield.MaterialTextFieldIcon;
import com.jhw.swing.material.standards.MaterialIcons;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentaBancariaInputView extends CleanCRUDInputView<CuentaBancariaDomain> {

    public static CuentaBancariaInputView from() {
        return new CuentaBancariaInputView(null);
    }

    public static CuentaBancariaInputView fromModel(CuentaBancariaDomain model) {
        return new CuentaBancariaInputView(model);
    }

    private CuentaBancariaInputView(CuentaBancariaDomain model) {
        super(model, ContabilidadSwingModule.cuentaBancariaUC, CuentaBancariaDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        //header
        setHeader("Crear Cuenta Bancaria", "Editar Cuenta Bancaria");

        //nombre
        textFieldNombreCuenta = MaterialTextFactory.buildIcon();
        textFieldNombreCuenta.setLabel("Nombre");
        textFieldNombreCuenta.setHint("Nombre de la cuenta");
        textFieldNombreCuenta.setIcon(ContabilidadModuleNavigator.ICON_CUENTA_BANCARIA);

        //numero cuenta
        textFieldNumeroCuenta = MaterialTextFactory.buildFormatedRuntimeIcon(null);
        textFieldNumeroCuenta.setLabel("Número de cuenta");
        textFieldNumeroCuenta.setHint("Número de la cuenta bancaria. Ej: 0598...");
        textFieldNumeroCuenta.setIcon(MaterialIcons.BUSINESS_CENTER);

        //numero tarjeta
        textFieldNumeroTarjeta = MaterialTextFactory.buildFormatedRuntimeIcon(null);
        textFieldNumeroTarjeta.setLabel("Número de tarjeta");
        textFieldNumeroTarjeta.setHint("Número de la tarjeta magnética asociada");
        textFieldNumeroTarjeta.setIcon(MaterialIcons.CREDIT_CARD);

        //pin
        textFieldPin = MaterialTextFactory.buildIcon();
        textFieldPin.setLabel("Pin");
        textFieldPin.setHint("Pin de la tarjeta");
        textFieldPin.setIcon(MaterialIcons.SECURITY);

        //codigo
        textFieldCodigo = MaterialTextFactory.buildIcon();
        textFieldCodigo.setLabel("Código contable");
        textFieldCodigo.setHint("Código de identificación. Ej: 110");
        textFieldCodigo.setIcon(MaterialIcons.GRID_ON);

        //moneda
        monedaICBS = new MonedaICBS();
        monedaICBS.setIcon(MaterialIcons.ATTACH_MONEY);

        //descripcion
        textAreaDescripcion = MaterialTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombreCuenta);
        vlc.add(textFieldCodigo);

        vlc.add(textFieldNumeroCuenta);

        HorizontalLayoutContainer.builder hlcTarjeta = HorizontalLayoutContainer.builder((int) textFieldNumeroTarjeta.getPreferredSize().getHeight());
        hlcTarjeta.add(HorizontalLayoutComponent.builder(textFieldNumeroTarjeta).gapRight(5).build());
        hlcTarjeta.add(HorizontalLayoutComponent.builder(textFieldPin).gapLeft(5).build());
        vlc.add(hlcTarjeta.build());

        vlc.add(monedaICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon<String> textFieldNombreCuenta;
    private MaterialFormatedTextFieldIcon<String> textFieldNumeroCuenta;
    private MaterialFormatedTextFieldIcon<String> textFieldNumeroTarjeta;
    private MaterialTextFieldIcon<String> textFieldPin;
    private MaterialTextFieldIcon<String> textFieldCodigo;
    private MonedaICBS monedaICBS;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public void update() {
        super.update();
        monedaICBS.setEnabled(getOldModel() == null);
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreCuenta", textFieldNombreCuenta);
        bindFields.put("numeroCuenta", textFieldNumeroCuenta);
        bindFields.put("numeroTarjeta", textFieldNumeroTarjeta);
        bindFields.put("pin", textFieldPin);
        bindFields.put("codigo", textFieldCodigo);
        bindFields.put("monedaFk", monedaICBS);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
