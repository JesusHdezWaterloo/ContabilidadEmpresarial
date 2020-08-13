package com.jhw.gestion.modules.contabilidad.ui.subcuenta;

import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;
import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.Subcuenta;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.gestion.modules.contabilidad.core.domain.old.SubcuentaDomain;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class SubcuentaPadresDetailView extends _MaterialPanelDetail<SubcuentaDomain> {

    private static final String COL_PADRE = "Padre";

    private CuentaDomain cuenta;

    public SubcuentaPadresDetailView(CuentaDomain cuenta) {
        super(
                Column.builder().name(COL_PADRE).build()
        );
        this.cuenta = cuenta;

        this.personalize();
    }

    private void personalize() {
        this.setHeaderText("Padres");

        this.setOptionPanelVisibility(false);//o si se quiere que no se vea ni el boton
        this.setActionColumnVisivility(false);
    }

    @Override
    public void update() {
        setCollection(ContabilidadSwingModule.subcuentaUC.findSubcuentasDondeSeaHijo(cuenta));
    }

    @Override
    public Object[] getRowObject(SubcuentaDomain obj) {
        return new Object[]{obj.getCuentaPadreFk()};
    }

    @Override
    protected void buttonNuevoActionListener() {
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
        //new DialogModelInput(this, new SubCuentaInputView(obj));
    }

    @Override
    protected void viewAction(SubcuentaDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

}
