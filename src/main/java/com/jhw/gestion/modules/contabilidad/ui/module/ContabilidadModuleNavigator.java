package com.jhw.gestion.modules.contabilidad.ui.module;

import com.clean.core.app.services.NavigationService;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ContabilidadModuleNavigator implements NavigationService {

    public static final String CONTABILIDAD = "Contabilidad";
    public static final String CUENTA = "Cuentas";
    public static final String MONEDA = "Monedas";
    public static final String METODO_PAGO = "Métodos de pago";
    public static final String NAV_CUENTA = "modulos.cuenta.cuentas";
    public static final String NAV_MONEDA = "modulos.cuenta.monedas";
    public static final String NAV_METODO_PAGO = "modulos.cuenta.metodo_pago";

    @Override
    public void navigateTo(String string, Object... os) {
        switch (string) {
            /*case NAV_PAGOS:
                JOP.error("Cree algún almacén");
                break;*/
        }
    }

}
