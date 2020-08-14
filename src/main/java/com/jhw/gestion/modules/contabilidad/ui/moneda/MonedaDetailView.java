package com.jhw.gestion.modules.contabilidad.ui.moneda;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.models.detail._MaterialPanelDetail;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class MonedaDetailView extends _MaterialPanelDetail<MonedaDomain> {

    private static final String COL_MONEDA = "Moneda";
    private static final String COL_COMPRA = "Compra";
    private static final String COL_VENTA = "Venta";

    public MonedaDetailView() {
        super(
                Column.builder().name(COL_MONEDA).build(),
                Column.builder().name(COL_COMPRA).build(),
                Column.builder().name(COL_VENTA).build()
        );

        this.personalize();
    }

    private void personalize() {
        this.setHeaderText("Monedas");
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(ContabilidadSwingModule.monedaUC.findAll());
        } catch (Exception e) {
        }
    }

    @Override
    public Object[] getRowObject(MonedaDomain obj) {
        return new Object[]{obj.getNombreMoneda(), obj.getCompra(), obj.getVenta()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, new MonedaInputView());
    }

    @Override
    protected MonedaDomain deleteAction(MonedaDomain obj) {
        try {
            ContabilidadSwingModule.monedaUC.destroy(obj);
            return obj;
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(MonedaDomain obj) {
        new DialogModelInput(this, new MonedaInputView(obj));
    }

    @Override
    protected void viewAction(MonedaDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

}
