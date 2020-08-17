package com.jhw.gestion.modules.contabilidad.ui.cuadre;

import com.jhw.gestion.modules.contabilidad.ui.liquidacion.*;
import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.forma_pago.FormaPagoInputView;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.swing.material.components.button._MaterialButtonIconTransparent;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.material.components.table.editors_renders.component.ComponentCellEditor;
import com.jhw.swing.material.components.table.editors_renders.component.ComponentCellRender;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyCellRender;
import com.jhw.swing.material.components.table.editors_renders.money.MoneyTableComponent;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;
import com.jhw.swing.models.input.dialogs.DialogModelInput;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.utils.others.SDF;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuadreDetailView extends _MaterialPanelDetail<CuadreDomain> {

    private static final String COL_LIQUIDADO = "Liq.";
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
                Column.builder().name(COL_LIQUIDADO).width(5).build(),
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

        //addOptionsElements();
        addActionsExtra();

        this.setHeaderText("Operaciones - Cuadre");
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
            getLiquidado(obj),
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

    private JPanel getLiquidado(CuadreDomain cuadre) {
        _PanelGradient panel = new _PanelGradient();
        if (cuadre.getLiquidada()) {
            panel.setIcon(MaterialIcons.DONE);
        } else {
            panel.setBackground(MaterialColors.TRANSPARENT);
            panel.setIcon(null);
        }
        return panel;
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, new CuadreInputView());
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
        ComponentCellRender colorRender = new ComponentCellRender(false);
        getTable().getColumn(COL_LIQUIDADO).setCellEditor(new ComponentCellEditor(colorRender, false));
        getTable().getColumn(COL_LIQUIDADO).setCellRenderer(colorRender);

        getTable().getColumn(COL_DEBITO1).setCellRenderer(new MoneyCellRender());
        getTable().getColumn(COL_CREDITO1).setCellRenderer(new MoneyCellRender());
        getTable().getColumn(COL_DEBITO2).setCellRenderer(new MoneyCellRender());
        getTable().getColumn(COL_CREDITO2).setCellRenderer(new MoneyCellRender());
    }

    private void addActionsExtra() {
        _MaterialButtonIconTransparent btnLiquidar = new _MaterialButtonIconTransparent();
        btnLiquidar.setIcon(MaterialIcons.ASSIGNMENT_TURNED_IN.deriveIcon(18f));
        btnLiquidar.addActionListener((ActionEvent e) -> {
            onLiquidarMaterialActionPerformed();
        });
        this.addActionExtra(btnLiquidar);
    }

    private void onLiquidarMaterialActionPerformed() {
        try {
            CuadreDomain obj = getSelectedElement();
            if (obj.getLiquidada()) {
                Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_INFO, "Ya este cuadre se liquidó.");
            } else {
                LiquidacionDomain liq = ContabilidadSwingModule.liquicadionUC.getLiquidacion(obj);
                new DialogModelInput(this, LiquidacionInputView.fromBase(liq));
            }
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    /*private void addOptionsElements() {
        //detalles de todas las operaciones
        _MaterialButtonIconTransparent btnLiquidarAll = new _MaterialButtonIconTransparent();
        btnLiquidarAll.setIcon(MaterialIcons.VISIBILITY.deriveIcon(30f));
        btnLiquidarAll.addActionListener((ActionEvent e) -> {
            onLiquidarAllMaterialActionPerformed();
        });
        this.addOptionElement(btnLiquidarAll);
    }

    private void onLiquidarAllMaterialActionPerformed() {
        System.out.println("Liquidar todo");
    }*/
}
