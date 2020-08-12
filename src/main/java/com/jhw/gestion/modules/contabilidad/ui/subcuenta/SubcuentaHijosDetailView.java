package com.jhw.gestion.modules.contabilidad.ui.subcuenta;

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
public class SubcuentaHijosDetailView extends _MaterialPanelDetail<SubcuentaDomain> {

    private static final String COL_HIJO = "Hijo";

    private CuentaDomain cuenta;

    public SubcuentaHijosDetailView(CuentaDomain c) {
        super(
            Column.builder().name(COL_HIJO).build()
        );
        this.cuenta = c;

        this.personalize();
    }

    private void personalize() {
        this.setHeaderText("Sub Cuentas");
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        setCollection(ContabilidadSwingModule.subcuentaUC.findSubcuentasDondeSeaPadre(cuenta));
    }

    @Override
    public Object[] getRowObject(SubcuentaDomain obj) {
        return new Object[]{obj.getCuentaHijoFk()};
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput<SubcuentaDomain>(this, new SubCuentaInputView(cuenta));
    }

    @Override
    protected SubcuentaDomain deleteAction(SubcuentaDomain obj) {
        try {
            ContabilidadSwingModule.subcuentaUC.destroy(obj);
            return obj;
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(SubcuentaDomain obj) {
        new DialogModelInput(this, new SubCuentaInputView(obj));
    }

    @Override
    protected void viewAction(SubcuentaDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }
}
