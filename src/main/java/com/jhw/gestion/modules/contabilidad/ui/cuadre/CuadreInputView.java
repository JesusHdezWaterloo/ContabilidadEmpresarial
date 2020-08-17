package com.jhw.gestion.modules.contabilidad.ui.cuadre;

import com.jhw.gestion.modules.contabilidad.core.domain.facade.CuadreUI;
import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.usecase_impl.TipoOperacionContableUseCaseImpl;
import com.jhw.gestion.modules.contabilidad.ui.cuenta_contable.CuentaContableICBS;
import com.jhw.gestion.modules.contabilidad.ui.info_op.InfoOpInputView;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaICBS;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutComponent;
import com.jhw.swing.material.components.container.layout.HorizontalLayoutContainer;
import com.jhw.swing.material.components.textfield.validated._MaterialTextFieldMoneyPositive;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class CuadreInputView extends CleanCRUDInputView<CuadreDomain> {

    public CuadreInputView() {
        this(null);
    }

    public CuadreInputView(CuadreDomain model) {
        super(model, ContabilidadSwingModule.cuadreUC);
        initComponents();
        update();
    }

    private void initComponents() {
        textFieldDebito = new _MaterialTextFieldMoneyPositive();
        textFieldDebito.setLabel("Valor");
        textFieldDebito.setHint("Valor de la operación");
        monedaDebito = new MonedaICBS();

        //cuenta
        cuentaICBS = new CuentaContableICBS();
        cuentaICBS.setHint("Cuenta Inicial");

        //cuadre
        cuentaCuadreICBS = new CuentaContableICBS();
        cuentaCuadreICBS.setHint("Cuenta Cuadre");

        //info
        infoInputView = new InfoOpInputView();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        HorizontalLayoutContainer.builder hlcDebito = HorizontalLayoutContainer.builder((int) textFieldDebito.getPreferredSize().getHeight());
        hlcDebito.add(HorizontalLayoutComponent.builder(textFieldDebito).gapRight(5).build());
        hlcDebito.add(HorizontalLayoutComponent.builder(monedaDebito).gapLeft(5).build());
        vlc.add(hlcDebito.build());

        vlc.add(cuentaICBS);
        vlc.add(cuentaCuadreICBS);
        vlc.add(infoInputView, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private _MaterialTextFieldMoneyPositive textFieldDebito;
    private MonedaICBS monedaDebito;
    private CuentaContableICBS cuentaICBS;
    private CuentaContableICBS cuentaCuadreICBS;
    private InfoOpInputView infoInputView;
    // End of variables declaration                   

    @Override
    public void update() {
        monedaDebito.update();
        cuentaICBS.update();
        cuentaCuadreICBS.update();
        if (getOldModel() == null) {
            setHeader("Crear Cuadre");
        } else {
            setHeader("Editar Cuadre");
            textFieldDebito.setMoney(getOldModel().getOperacionContableFk().getDebito(), getOldModel().getOperacionContableFk().getCuentaFk().getMonedaFk().toString());
            monedaDebito.setSelectedItem(getOldModel().getOperacionContableFk().getCuentaFk().getMonedaFk());

            cuentaICBS.setSelectedItem(getOldModel().getOperacionContableFk().getCuentaFk());
            cuentaCuadreICBS.setSelectedItem(getOldModel().getOperacionContableCuadreFk().getCuentaFk());

            infoInputView.setObject(getOldModel().info());
        }
    }

    @Override
    public CuadreDomain getNewModel() throws Exception {
        double debito = textFieldDebito.getMoney();
        MonedaDomain monedaDebito1 = monedaDebito.getSelectedItem();

        CuentaContableDomain cuenta = cuentaICBS.getSelectedItem();
        CuentaContableDomain cuentaCuadre = cuentaCuadreICBS.getSelectedItem();

        InfoOperacionContableDomain info = infoInputView.getNewModel();
        info.setTipoOperacionFk(TipoOperacionContableUseCaseImpl.MOVIMIENTO_INTERNO);

        CuadreUI cuadre = new CuadreUI(debito, monedaDebito1, cuenta, cuentaCuadre, info);
        if (getOldModel() == null) {
            return new CuadreDomain(cuadre);
        } else {
            getOldModel().updateWith(cuadre);
            return getOldModel();
        }
    }

}
