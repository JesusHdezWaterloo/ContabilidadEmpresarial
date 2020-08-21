package com.jhw.gestion.modules.contabilidad.ui.forma_pago;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class FormaPagoDetailView extends _MaterialPanelDetail<FormaPagoDomain> {

    private static final String COL_PAGO = "Pago";
    private static final String COL_DESC = "Descripción";

    public FormaPagoDetailView() {
        super(
                Column.builder().name(COL_PAGO).build(),
                Column.builder().name(COL_DESC).build()
        );

        this.personalize();
    }

    private void personalize() {
        this.setHeaderText("Tipos de Pago");
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(ContabilidadSwingModule.tipoPagoUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(FormaPagoDomain obj) {
        return new Object[]{obj.getNombreFormaPago(), obj.getDescripcion()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, new FormaPagoInputView());
    }

    @Override
    protected FormaPagoDomain deleteAction(FormaPagoDomain obj) {
        try {
            return ContabilidadSwingModule.tipoPagoUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(FormaPagoDomain obj) {
        new DialogModelInput(this, new FormaPagoInputView(obj));
    }

    @Override
    protected void viewAction(FormaPagoDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

}
