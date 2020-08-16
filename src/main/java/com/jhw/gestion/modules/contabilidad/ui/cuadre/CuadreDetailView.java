package com.jhw.gestion.modules.contabilidad.ui.cuadre;

import com.jhw.gestion.modules.contabilidad.ui.liquidacion.*;
import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyCellRender;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.utils.others.SDF;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuadreDetailView extends _MaterialPanelDetail<CuadreDomain> {

    private static final String COL_DCUMENTO = "Documento";
    private static final String COL_NOMBRE = "Nombre";
    private static final String COL_FECHA = "Fecha";
    private static final String COL_CUENTA = "Cuenta";
    private static final String COL_DEBITO1 = "Débito 1";
    private static final String COL_CREDITO1 = "Crédito 1";
    private static final String COL_CUADRE = "Cuadre";
    private static final String COL_DEBITO2 = "Débito 2";
    private static final String COL_CREDITO2 = "Crédito 2";

    public CuadreDetailView() {
        super(
                Column.builder().name(COL_DCUMENTO).build(),
                Column.builder().name(COL_NOMBRE).build(),
                Column.builder().name(COL_FECHA).build(),
                Column.builder().name(COL_CUENTA).build(),
                Column.builder().name(COL_DEBITO1).build(),
                Column.builder().name(COL_CREDITO1).build(),
                Column.builder().name(COL_CUADRE).build(),
                Column.builder().name(COL_DEBITO2).build(),
                Column.builder().name(COL_CREDITO2).build()
        );

        this.personalize();
    }

    private void personalize() {
        setUpEditorsRenders();
        this.setHeaderText("Operaciones - Cuadre");
        this.setOptionPanelVisibility(false);
        this.setActionColumnButtonsVisivility(false, false, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(ContabilidadSwingModule.cuadreUC.findAll());
        } catch (Exception e) {
        }
    }

    @Override
    public Object[] getRowObject(CuadreDomain obj) {
        return new Object[]{
            obj.info().getDocumento(),
            obj.info().getNombre(),
            SDF.format(obj.info().getFecha()),
            obj.getOperacionContableFk().getCuentaFk(),
            MoneyTableComponent.from(obj.getOperacionContableFk().getDebito(), obj.getOperacionContableFk().getCuentaFk().getMonedaFk()),
            MoneyTableComponent.from(obj.getOperacionContableFk().getCredito(), obj.getOperacionContableFk().getCuentaFk().getMonedaFk()),
            obj.getOperacionContableCuadreFk().getCuentaFk(),
            MoneyTableComponent.from(obj.getOperacionContableCuadreFk().getDebito(), obj.getOperacionContableCuadreFk().getCuentaFk().getMonedaFk()),
            MoneyTableComponent.from(obj.getOperacionContableCuadreFk().getCredito(), obj.getOperacionContableCuadreFk().getCuentaFk().getMonedaFk())
        };
    }

    @Override
    protected void buttonNuevoActionListener() {
    }

    @Override
    protected CuadreDomain deleteAction(CuadreDomain obj) {
        try {
            ContabilidadSwingModule.cuadreUC.destroy(obj);
            return obj;
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(CuadreDomain obj) {
    }

    @Override
    protected void viewAction(CuadreDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

    private void setUpEditorsRenders() {
        getTable().getColumn(COL_DEBITO1).setCellRenderer(new MoneyCellRender());
        getTable().getColumn(COL_CREDITO1).setCellRenderer(new MoneyCellRender());
        getTable().getColumn(COL_DEBITO2).setCellRenderer(new MoneyCellRender());
        getTable().getColumn(COL_CREDITO2).setCellRenderer(new MoneyCellRender());
    }
}
