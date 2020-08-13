package com.jhw.gestion.modules.contabilidad.ui.moneda;

import com.jhw.gestion.modules.contabilidad.core.usecase_impl.MonedaUseCaseImpl;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.Moneda;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.old.MonedaDomain;
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

        textFieldTipo = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty();
        textFieldCompra = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldMoneyPositive();
        textFieldVenta = new com.jhw.swing.material.components.textfield.validated._MaterialTextFieldMoneyPositive();
        textAreaDescripcion = new com.jhw.swing.material.components.textarea.prepared._MaterialTextAreaDescripcion();

        setHeader("Nueva Moneda", "Editar Moneda");

        textFieldTipo.setHint("Tipo de moneda. Ej.: EUR");
        textFieldTipo.setLabel("Moneda");

        textFieldCompra.setHint("Precio de compra");
        textFieldCompra.setLabel("Compra");

        textFieldVenta.setHint("Precio de venta");
        textFieldVenta.setLabel("Venta");
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
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldMoneyPositive textFieldCompra;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldStringNotEmpty textFieldTipo;
    private com.jhw.swing.material.components.textfield.validated._MaterialTextFieldMoneyPositive textFieldVenta;
    // End of variables declaration                   

    private void personalize() {
        textFieldCompra.setExtra(MonedaHandler.getMonedaBase().getTipoMoneda());
        textFieldVenta.setExtra(MonedaHandler.getMonedaBase().getTipoMoneda());
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("tipoMoneda", textFieldTipo);
        bindFields.put("compra", textFieldCompra);
        bindFields.put("venta", textFieldVenta);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }
}
