package com.jhw.gestion.modules.contabilidad.ui.operacion_contable;

import com.jhw.gestion.modules.contabilidad.ui.liquidacion.*;
import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyCellRender;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import com.jhw.swing.models.detail._MaterialPanelDetail;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class OperacionContableDetailView extends _MaterialPanelDetail<OperacionContableDomain> {

    private static final String COL_DCUMENTO = "Documento";
    private static final String COL_NOMBRE = "Nombre";
    private static final String COL_DEBITO = "Débito";
    private static final String COL_CREDITO = "Crédito";
    private static final String COL_FECHA = "Fecha";
    private static final String COL_CUENTA = "Cuenta";

    private final CuentaContableDomain cuenta;

    public OperacionContableDetailView() {
        this(null);
    }

    public OperacionContableDetailView(CuentaContableDomain cuenta) {
        super(
                Column.builder().name(COL_DCUMENTO).build(),
                Column.builder().name(COL_NOMBRE).build(),
                Column.builder().name(COL_DEBITO).build(),
                Column.builder().name(COL_CREDITO).build(),
                Column.builder().name(COL_FECHA).build(),
                Column.builder().name(COL_CUENTA).build()
        );

        this.cuenta = cuenta;

        this.personalize();
    }

    private void personalize() {
        setUpEditorsRenders();
        String cuentaStr = cuenta == null ? "" : cuenta.toString();
        this.setHeaderText("Operaciones" + cuentaStr);
        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(ContabilidadSwingModule.operacionContableUC.findAll(cuenta));
        } catch (Exception e) {
        }
    }

    @Override
    public Object[] getRowObject(OperacionContableDomain obj) {
        return new Object[]{obj.getInfoOperacionContableFk().getDocumento(),
            obj.getInfoOperacionContableFk().getNombre(),
            obj.getDebito() == 0 ? "-" : MoneyTableComponent.from(obj.getDebito(), obj.getCuentaFk().getMonedaFk()),
            obj.getCredito() == 0 ? "-" : MoneyTableComponent.from(obj.getCredito(), obj.getCuentaFk().getMonedaFk()),
            obj.getInfoOperacionContableFk().getFecha(),
            obj.getCuentaFk()
        };
    }

    @Override
    protected void buttonNuevoActionListener() {
        //new DialogModelInput(this, new LiquidacionInputView());
    }

    @Override
    protected OperacionContableDomain deleteAction(OperacionContableDomain obj) {
        try {
            ContabilidadSwingModule.operacionContableUC.destroy(obj);
            return obj;
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(OperacionContableDomain obj) {
        //new DialogModelInput(this, new LiquidacionInputView(obj));
    }

    @Override
    protected void viewAction(OperacionContableDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

    private void setUpEditorsRenders() {
        getTable().getColumn(COL_DEBITO).setCellRenderer(new MoneyCellRender());
        getTable().getColumn(COL_CREDITO).setCellRenderer(new MoneyCellRender());
    }
}
