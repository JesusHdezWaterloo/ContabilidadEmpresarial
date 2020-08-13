package com.jhw.gestion.modules.contabilidad.ui.cuenta.mix;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.contabilidad.core.domain.old.DepositoCuentaDomain;
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
public class DepositosDetailView extends _MaterialPanelDetail<DepositoCuentaDomain> {

    private static final String COL_VALOR = "Valor";
    private static final String COL_PORCIENTO = "%";
    private static final String COL_TRABAJO = "Trabajo";

    private CuentaInputView cuentaIV;

    public DepositosDetailView(CuentaInputView cta) {
        super(
                Column.builder().name(COL_VALOR).build(),
                Column.builder().name(COL_PORCIENTO).build(),
                Column.builder().name(COL_TRABAJO).build()
        );
        this.cuentaIV = cta;

        this.personalize();
    }

    private void personalize() {
        getTable().getColumn(COL_VALOR).setCellRenderer(new MoneyCellRender());

        this.setHeaderText("Depósitos");
        this.setActionColumnVisivility(false);
        this.setOptionPanelVisibility(false);//o si se quiere que no se vea ni el boton
    }

    @Override
    public void update() {
        this.setEnabled(cuentaIV.getOldModel() != null);//o si se quiere que no se vea ni el boton
        if (!isEnabled()) {
            return;
        }
        setCollection(ContabilidadSwingModule.depositoUC.findDepositosOfCuenta(cuentaIV.getOldModel()));
    }

    @Override
    public Object[] getRowObject(DepositoCuentaDomain obj) {
        return new Object[]{
            new MoneyTableComponent(obj.getValor(), obj.getCuentaFk().getMonedaFk().getTipoMoneda()),
            obj.getPorciento() + "%",
            "--Object external--"};
    }

    @Override
    protected void buttonNuevoActionListener() {
        //new DialogModelInput(this, new CarroContratoInputView());
    }

    @Override
    protected DepositoCuentaDomain deleteAction(DepositoCuentaDomain obj) {
        try {
            ContabilidadSwingModule.depositoUC.destroy(obj);
            return obj;
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(DepositoCuentaDomain obj) {
        //new DialogModelInput(this, new CarroContratoInputView(obj));
    }

    @Override
    protected void viewAction(DepositoCuentaDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }

}
