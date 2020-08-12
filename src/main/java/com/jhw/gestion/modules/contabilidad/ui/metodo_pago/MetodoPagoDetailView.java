package com.jhw.gestion.modules.contabilidad.ui.metodo_pago;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.contabilidad.core.domain.CuentaDomain;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.gestion.modules.contabilidad.core.domain.MetodoPagoDomain;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class MetodoPagoDetailView extends _MaterialPanelDetail<MetodoPagoDomain> {

    private static final String COL_PAGO = "Pago";
    private static final String COL_DESC = "Descripción";

    public MetodoPagoDetailView() {
        super(
                Column.builder().name(COL_PAGO).build(),
                Column.builder().name(COL_DESC).build()
        );

        this.personalize();
    }

    private void personalize() {
        this.setHeaderText("Métodos de Pago");
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(ContabilidadSwingModule.metodoPagoUC.findAll());
        } catch (Exception e) {
        }
    }

    @Override
    public Object[] getRowObject(MetodoPagoDomain obj
    ) {
        return new Object[]{obj.getNombreMetodoPago(), obj.getDescripcion()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, new MetodoPagoInputView());
    }

    @Override
    protected MetodoPagoDomain deleteAction(MetodoPagoDomain obj
    ) {
        try {
            ContabilidadSwingModule.metodoPagoUC.destroy(obj);
            return obj;
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(MetodoPagoDomain obj
    ) {
        new DialogModelInput(this, new MetodoPagoInputView(obj));
    }

    @Override
    protected void viewAction(MetodoPagoDomain obj
    ) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

}
