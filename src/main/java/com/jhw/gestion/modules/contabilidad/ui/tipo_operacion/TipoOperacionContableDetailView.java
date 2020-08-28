package com.jhw.gestion.modules.contabilidad.ui.tipo_operacion;

import com.jhw.gestion.modules.contabilidad.ui.tipo_cuenta.*;
import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.models.detail._MaterialPanelDetail;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoOperacionContableDetailView extends _MaterialPanelDetail<TipoOperacionContableDomain> {

    private static final String COL_NOMBRE = "Tipo";
    private static final String COL_DESC = "Descripción";

    public TipoOperacionContableDetailView() {
        super(
                Column.builder().name(COL_NOMBRE).build(),
                Column.builder().name(COL_DESC).build()
        );

        this.personalize();
    }

    private void personalize() {
        this.setHeaderText("Tipos de operaciones");
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(ContabilidadSwingModule.tipoOperacionContableUC.findAll());
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
    }

    @Override
    public Object[] getRowObject(TipoOperacionContableDomain obj) {
        return new Object[]{
            obj.getNombreOperacion(),
            obj.getDescripcion()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, new TipoOperacionContableInputView());
    }

    @Override
    protected TipoOperacionContableDomain deleteAction(TipoOperacionContableDomain obj) {
        try {
            return ContabilidadSwingModule.tipoOperacionContableUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(TipoOperacionContableDomain obj) {
        new DialogModelInput(this, new TipoOperacionContableInputView(obj));
    }

    @Override
    protected void viewAction(TipoOperacionContableDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

}
