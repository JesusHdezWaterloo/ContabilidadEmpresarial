package com.jhw.gestion.modules.contabilidad.ui.cuenta_bancaria;

import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuentaBancariaInputView extends CleanCRUDInputView<CuentaBancariaDomain> {

    public CuentaBancariaInputView() {
        this(null);
    }

    public CuentaBancariaInputView(CuentaBancariaDomain model) {
        super(model, ContabilidadSwingModule.cuentaBancariaUC, CuentaBancariaDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        //header
        setHeader("Crear Cuenta Bancaria", "Editar Cuenta Bancaria");

        //nombre
        textFieldNombreCuenta = new com.jhw.swing.material.components.textfield._MaterialTextField();
        textFieldNombreCuenta.setLabel("Nombre");
        textFieldNombreCuenta.setHint("Nombre de la cuenta");

        //numero cuenta
        textFieldNumeroCuenta = new com.jhw.swing.material.components.textfield._MaterialTextField();
        textFieldNumeroCuenta.setLabel("Número de cuenta");
        textFieldNumeroCuenta.setHint("Número de la cuenta bancaria. Ej: 0598...");

        //numero tarjeta
        textFieldNumeroTarjeta = new com.jhw.swing.material.components.textfield._MaterialTextField();
        textFieldNumeroTarjeta.setLabel("Número de tarjeta");
        textFieldNumeroTarjeta.setHint("Número de la tarjeta magnética asociada");

        //pin
        textFieldPin = new com.jhw.swing.material.components.textfield._MaterialTextField();
        textFieldPin.setLabel("Pin");
        textFieldPin.setHint("Pin de la tarjeta");

        //codigo
        textFieldCodigo = new com.jhw.swing.material.components.textfield._MaterialTextField();
        textFieldCodigo.setLabel("Código contable");
        textFieldCodigo.setHint("Código de identificación. Ej: 110");

        //moneda
        monedaICBS = new MonedaICBS();

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombreCuenta);
        vlc.add(textFieldNumeroCuenta);

        HorizontalLayoutContainer.builder hlcTarjeta = HorizontalLayoutContainer.builder((int) textFieldNumeroTarjeta.getPreferredSize().getHeight());
        hlcTarjeta.add(HorizontalLayoutComponent.builder(textFieldNumeroTarjeta).gapRight(5).build());
        hlcTarjeta.add(HorizontalLayoutComponent.builder(textFieldPin).gapLeft(5).build());
        vlc.add(hlcTarjeta.build());

        vlc.add(textFieldCodigo);
        vlc.add(monedaICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldNombreCuenta;
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldNumeroCuenta;
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldNumeroTarjeta;
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldPin;
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldCodigo;
    private MonedaICBS monedaICBS;
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    // End of variables declaration                   

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
