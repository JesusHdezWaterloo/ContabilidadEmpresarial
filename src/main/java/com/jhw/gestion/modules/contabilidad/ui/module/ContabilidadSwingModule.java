package com.jhw.gestion.modules.contabilidad.ui.module;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.AbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.repo.module.ContabilidadRepoModule;
import com.jhw.gestion.modules.contabilidad.service.ResourceServiceImplementation;
import com.jhw.gestion.modules.contabilidad.ui.cuadre.CuadreDetailView;
import com.jhw.gestion.modules.contabilidad.ui.cuenta.CuentasMainPanel;
import com.jhw.gestion.modules.contabilidad.ui.liquidacion.LiquidacionDetailView;
import com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaDetailView;
import com.jhw.gestion.modules.contabilidad.ui.metodo_pago.MetodoPagoDetailView;
import com.jhw.gestion.modules.contabilidad.ui.operacion_contable.OperacionContableDetailView;
import com.jhw.gestion.modules.contabilidad.ui.tipo_cuenta.TipoCuentaDetailView;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ContabilidadSwingModule implements AbstractSwingMainModule {

    private final ContabilidadModuleNavigator navigator = new ContabilidadModuleNavigator();

    public final static CuadreUseCase cuadreUC;
    public final static CuentaBancariaUseCase cuentaBancariaUC;
    public final static CuentaContableUseCase cuentaContableUC;
    public final static InfoOperacionContableUseCase infoOpUC;
    public final static LiquidacionUseCase liquicadionUC;
    public final static MetodoPagoUseCase metodoPagoUC;
    public final static MonedaUseCase monedaUC;
    public final static OperacionContableUseCase operacionContableUC;
    public final static SubcuentaUseCase subcuentaUC;
    public final static TipoCuentaUseCase tipoCuentaUC;
    public final static TipoOperacionContableUseCase tipoOperacionContableUC;

    static {
        ContabilidadCoreModule.init(ContabilidadRepoModule.init());

        cuadreUC = ContabilidadCoreModule.getInstance().getImplementation(CuadreUseCase.class);
        cuentaBancariaUC = ContabilidadCoreModule.getInstance().getImplementation(CuentaBancariaUseCase.class);
        cuentaContableUC = ContabilidadCoreModule.getInstance().getImplementation(CuentaContableUseCase.class);
        infoOpUC = ContabilidadCoreModule.getInstance().getImplementation(InfoOperacionContableUseCase.class);
        liquicadionUC = ContabilidadCoreModule.getInstance().getImplementation(LiquidacionUseCase.class);
        metodoPagoUC = ContabilidadCoreModule.getInstance().getImplementation(MetodoPagoUseCase.class);
        monedaUC = ContabilidadCoreModule.getInstance().getImplementation(MonedaUseCase.class);
        operacionContableUC = ContabilidadCoreModule.getInstance().getImplementation(OperacionContableUseCase.class);
        subcuentaUC = ContabilidadCoreModule.getInstance().getImplementation(SubcuentaUseCase.class);
        tipoCuentaUC = ContabilidadCoreModule.getInstance().getImplementation(TipoCuentaUseCase.class);
        tipoOperacionContableUC = ContabilidadCoreModule.getInstance().getImplementation(TipoOperacionContableUseCase.class);

        ResourceServiceImplementation.init();
    }

    private ContabilidadSwingModule() {
    }

    public static ContabilidadSwingModule init() {
        return new ContabilidadSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
        System.out.println("Creando 'Cuentas'");
        registerMainElements(app);
    }

    private void registerMainElements(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

        CollapseMenu menu = new CollapseMenu(MaterialIcons.LOCAL_ATM, ContabilidadModuleNavigator.CONTABILIDAD);
        dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, menu);

        dash.addView(ContabilidadModuleNavigator.NAV_CUENTA, new CuentasMainPanel());
        menu.addMenuItem(new AbstractAction(ContabilidadModuleNavigator.CUENTA, MaterialIcons.ACCOUNT_BALANCE) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(ContabilidadModuleNavigator.NAV_CUENTA);
            }
        });
        
        dash.addView(ContabilidadModuleNavigator.NAV_CUADRE, new CuadreDetailView());
        menu.addMenuItem(new AbstractAction(ContabilidadModuleNavigator.CUADRE, MaterialIcons.ASSIGNMENT_TURNED_IN) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(ContabilidadModuleNavigator.NAV_CUADRE);
            }
        });

        dash.addView(ContabilidadModuleNavigator.NAV_MONEDA, new MonedaDetailView());
        menu.addMenuItem(new AbstractAction(ContabilidadModuleNavigator.MONEDA, MaterialIcons.ATTACH_MONEY) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(ContabilidadModuleNavigator.NAV_MONEDA);
            }
        });

        dash.addView(ContabilidadModuleNavigator.NAV_METODO_PAGO, new MetodoPagoDetailView());
        menu.addMenuItem(new AbstractAction(ContabilidadModuleNavigator.METODO_PAGO, MaterialIcons.PAYMENT) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(ContabilidadModuleNavigator.NAV_METODO_PAGO);
            }
        });

        dash.addView(ContabilidadModuleNavigator.NAV_TIPO_CUENTA, new TipoCuentaDetailView());
        menu.addMenuItem(new AbstractAction(ContabilidadModuleNavigator.TIPO_CUENTA, MaterialIcons.NFC) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(ContabilidadModuleNavigator.NAV_TIPO_CUENTA);
            }
        });
    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
