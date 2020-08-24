package com.jhw.gestion.modules.contabilidad.ui.moneda;

import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class MonedaInputView extends CleanCRUDInputView<MonedaDomain> {

    public MonedaInputView() {
        this(null);
    }

    public MonedaInputView(MonedaDomain model) {
        super(model, ContabilidadSwingModule.monedaUC, MonedaDomain.class);
        initComponents();
        personalize();
        update();
    }

    private void initComponents() {
        setHeader("Crear Moneda", "Editar Moneda");

        //tipo
        textFieldTipo = new com.jhw.swing.material.components.textfield._MaterialTextField();
        textFieldTipo.setLabel("Moneda");
        textFieldTipo.setHint("Nombre de moneda. Ej.: EUR");

        //compra
        textFieldCompra = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldMoney();
        textFieldCompra.setHint("Precio de compra");
        textFieldCompra.setLabel("Compra");

        //venta
        textFieldVenta = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldMoney();
        textFieldVenta.setHint("Precio de venta");
        textFieldVenta.setLabel("Venta");

        //descripcion
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldTipo);
        HorizontalLayoutContainer.builder hlcCompraVenta = HorizontalLayoutContainer.builder((int) textFieldCompra.getPreferredSize().getHeight());
        hlcCompraVenta.add(HorizontalLayoutComponent.builder(textFieldCompra).gapRight(5).build());
        hlcCompraVenta.add(HorizontalLayoutComponent.builder(textFieldVenta).gapLeft(5).build());
        vlc.add(hlcCompraVenta.build());

        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion textAreaDescripcion;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldMoney textFieldCompra;
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldTipo;
    private com.jhw.swing.material.components.textfield._MaterialTextField textFieldVenta;
    // End of variables declaration                   

    private void personalize() {
        try {
            textFieldCompra.setExtra(MonedaHandler.getMonedaBase().getNombreMoneda());
            textFieldVenta.setExtra(MonedaHandler.getMonedaBase().getNombreMoneda());
        } catch (Exception e) {
        }
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreMoneda", textFieldTipo);
        bindFields.put("compra", textFieldCompra);
        bindFields.put("venta", textFieldVenta);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
