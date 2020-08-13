package com.jhw.gestion.modules.contabilidad.ui.cuenta.mix;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.contabilidad.core.domain.ExtraccionCuentaDomain;
import com.jhw.gestion.modules.contabilidad.repo.entities.old.ExtraccionCuenta;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyCellRender;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import com.jhw.gestion.modules.contabilidad.ui.cuenta.CuentaInputView;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class ExtraccionesDetailView extends _MaterialPanelDetail<ExtraccionCuentaDomain> {

    private static final String COL_VALOR = "Valor";
    private static final String COL_NOMBRE = "Nombre";
    private static final String COL_EXTRACCION = "Extracción";

    private CuentaInputView cuentaIV;

    public ExtraccionesDetailView(CuentaInputView cta) {
        super(
                Column.builder().name(COL_VALOR).build(),
                Column.builder().name(COL_NOMBRE).width(300).build(),
                Column.builder().name(COL_EXTRACCION).build()
        );
        this.cuentaIV = cta;

        this.personalize();
    }

    private void personalize() {
        getTable().getColumn(COL_VALOR).setCellRenderer(new MoneyCellRender());

        this.setHeaderText("Extracciones");
        this.setActionColumnVisivility(false);
        this.setOptionPanelVisibility(false);//o si se quiere que no se vea ni el boton
    }

    @Override
    public void update() {
        this.setEnabled(cuentaIV.getOldModel() != null);//o si se quiere que no se vea ni el boton
        if (!isEnabled()) {
            return;
        }
        try {
            setCollection(ContabilidadSwingModule.extraccionUC.findExtraccionesOfCuenta(cuentaIV.getOldModel()));
        } catch (Exception e) {
        }
    }

    @Override
    public Object[] getRowObject(ExtraccionCuentaDomain obj) {
        return new Object[]{
            new MoneyTableComponent(obj.getValor(), obj.getCuentaFk().getMonedaFk().getTipoMoneda()),
            obj.getNombreExtraccCta(),
            obj.getTipoExtraccion()
        };
    }

    @Override
    protected void buttonNuevoActionListener() {
        //new DialogModelInput(this, new CarroContratoInputView());
    }

    @Override
    protected ExtraccionCuentaDomain deleteAction(ExtraccionCuentaDomain obj) {
        try {
            ContabilidadSwingModule.extraccionUC.destroy(obj);
            return obj;
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(ExtraccionCuentaDomain obj) {
        //new DialogModelInput(this, new CarroContratoInputView(obj));
    }

    @Override
    protected void viewAction(ExtraccionCuentaDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

}
