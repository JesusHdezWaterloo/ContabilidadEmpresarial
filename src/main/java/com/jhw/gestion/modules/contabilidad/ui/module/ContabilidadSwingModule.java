package com.jhw.gestion.modules.contabilidad.ui.module;

import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.AbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.repo.module.ContabilidadRepoModule;
import com.jhw.gestion.modules.contabilidad.service.ResourceServiceImplementation;
import com.jhw.gestion.modules.contabilidad.ui.main_section.CuentasMainPanel;
import com.jhw.gestion.modules.contabilidad.ui.moneda.MonedaDetailView;
import com.jhw.gestion.modules.contabilidad.ui.metodo_pago.MetodoPagoDetailView;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class ContabilidadSwingModule implements AbstractSwingMainModule {

    private final ContabilidadModuleNavigator navigator = new ContabilidadModuleNavigator();

    public final static CuentaUseCase cuentaUC;
    public final static DepositoCuentaUseCase depositoUC;
    public final static ExtraccionCuentaUseCase extraccionUC;
    public final static MetodoPagoUseCase metodoPagoUC;
    public final static MonedaUseCase monedaUC;
    public final static SubcuentaUseCase subcuentaUC;
    public final static TipoDepositoUseCase tipoDepositoUC;
    public final static TipoExtraccionUseCase tipoExtraccionUC;

    static {
        ContabilidadCoreModule.init(ContabilidadRepoModule.init());
        
        cuentaUC = ContabilidadCoreModule.getInstance().getImplementation(CuentaUseCase.class);
        depositoUC = ContabilidadCoreModule.getInstance().getImplementation(DepositoCuentaUseCase.class);
        extraccionUC = ContabilidadCoreModule.getInstance().getImplementation(ExtraccionCuentaUseCase.class);
        metodoPagoUC = ContabilidadCoreModule.getInstance().getImplementation(MetodoPagoUseCase.class);
        monedaUC = ContabilidadCoreModule.getInstance().getImplementation(MonedaUseCase.class);
        subcuentaUC = ContabilidadCoreModule.getInstance().getImplementation(SubcuentaUseCase.class);
        tipoDepositoUC = ContabilidadCoreModule.getInstance().getImplementation(TipoDepositoUseCase.class);
        tipoExtraccionUC = ContabilidadCoreModule.getInstance().getImplementation(TipoExtraccionUseCase.class);
    
        ResourceServiceImplementation.init();
    }

    private ContabilidadSwingModule() {
    }

    public static ContabilidadSwingModule init() {
        return new ContabilidadSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
        System.out.println("Creando 'Cuenta'");
        registerMainElements(app);
    }

    private void registerMainElements(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

        CollapseMenu menu = new CollapseMenu(MaterialIcons.LOCAL_ATM, ContabilidadModuleNavigator.CONTABILIDAD);
        dash.addKeyValue(DashboardConstants.MAIN_ELEMENT, menu);

        dash.addView(ContabilidadModuleNavigator.NAV_CUENTA, new CuentasMainPanel());
        menu.addMenuItem(new AbstractAction(ContabilidadModuleNavigator.CUENTA, MaterialIcons.LOCAL_ATM) {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.navigateTo(ContabilidadModuleNavigator.NAV_CUENTA);
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
    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
