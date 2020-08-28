package com.jhw.gestion.modules.contabilidad.ui.module;

import com.clean.core.app.services.NavigationService;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ContabilidadModuleNavigator implements NavigationService {

    public static final String CONTABILIDAD = "Contabilidad";
    public static final String CUENTA = "Cuentas";
    public static final String CUADRE = "Cuadre";
    public static final String OPERACIONES = "Operaciones";
    public static final String LIQUIDACIONES = "Liquidaciones";
    public static final String MONEDA = "Monedas";
    public static final String FORMA_PAGO = "Forma de pago";
    public static final String TIPO_CUENTA = "Tipo de cuenta";
    public static final String TITULAR = "Titular";
    public static final String TIPO_OPERACION = "Tipo de operación";
    public static final String NAV_CUENTA = "modulos.cuenta.cuentas";
    public static final String NAV_CUADRE = "modulos.cuenta.cuadre";
    public static final String NAV_MONEDA = "modulos.cuenta.monedas";
    public static final String NAV_FORMA_PAGO = "modulos.cuenta.forma_pago";
    public static final String NAV_TIPO_CUENTA = "modulos.cuenta.tipo_cuenta";
    public static final String NAV_OPERACIONES = "modulos.cuenta.operaciones";
    public static final String NAV_LIQUIDACIONES = "modulos.cuenta.liquidacioens";
    public static final String NAV_TITULAR = "modulos.cuenta.titular";
    public static final String NAV_TIPO_OPERACION = "modulos.cuenta.tipo_operacion";

    @Override
    public void navigateTo(String string, Object... os) {
        switch (string) {
            /*case NAV_PAGOS:
                JOP.error("Cree algún almacén");
                break;*/
        }
    }

}
