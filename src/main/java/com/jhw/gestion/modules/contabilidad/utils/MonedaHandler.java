package com.jhw.gestion.modules.contabilidad.utils;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.MonedaUseCase;

/**
 *
 * @author Jessica Aidyl García Albalah (jgarciaalbalah@gmail.com)
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class MonedaHandler {

    private static MonedaDomain mon = null;

    /**
     * Conversion para vender una moneda: TENGO 'valor' de la moneda 'desde'
     * para vender y quiero que me den a cambio 'hasta'.<\br>
     * EJ.: Tengo 1 CUC y quiero CUP, por lo tanto me dan 24 CUP. <\br>
     * F(x,y,z) = venta(1, CUC, CUP) = 24
     *
     * @param cantidad Cantidad de lo que tengo.
     * @param tengo Moneda que tengo.
     * @param quiero La moneda que quiero que me den a cambio.
     * @return la cantidad que me van a dar a cambio de lo que tengo.
     */
    public static double venta(double cantidad, MonedaDomain tengo, MonedaDomain quiero) {
        double devol = 0;
        if (tengo.equals(quiero)) {
            devol = cantidad;
        } else {
            devol = cantidad * tengo.getVenta() / quiero.getCompra();
        }
        return devol;
    }

    /**
     * Conversión para comprar una moneda: Quiero 'cant' de la moneda 'quiero' y
     * tengo 'tengo', cuanto tengo que dar de 'tengo' para poder comprar.<\br>
     * EJ.: Quiero 1 CUC, tengo CUP, por lo tento devuelve 25, tengo que dar 25
     * CUP para comprar 1 CUC.<\br>
     * F(x,y,z) = compra(1, CUC, CUP) = 25
     *
     * @param cantidad La cantidad de lo que quiero.
     * @param quiero La moneda que quiero.
     * @param tengo Lo que tengo.
     * @return la cantidad de lo que tengo que tengo que dar para comprar lo que
     * quiero.
     */
    public static double compra(double cantidad, MonedaDomain quiero, MonedaDomain tengo) {
        double devol = 0;
        if (quiero.equals(tengo)) {
            devol = cantidad;
        } else {
            devol = cantidad * quiero.getCompra() / tengo.getVenta();
        }
        return devol;
    }

    public static double ventaFull(double cantidad, MonedaDomain tengo, MonedaDomain quiero) {
        double devol = 0;
        if (tengo.equals(quiero)) {
            devol = cantidad;
        } else {
            devol = cantidad * tengo.getVenta() / quiero.getVenta();
        }
        return devol;
    }

    public static double compraFull(double cantidad, MonedaDomain quiero, MonedaDomain tengo) {
        double devol = 0;
        if (quiero.equals(tengo)) {
            devol = cantidad;
        } else {
            devol = cantidad * quiero.getCompra() / tengo.getCompra();
        }
        return devol;
    }

    public static MonedaDomain getMonedaBase() {
        if (mon != null) {
            return mon;
        }
        try {
            mon = ContabilidadCoreModule.getInstance().getImplementation(MonedaUseCase.class)
                    .findMonedaBase();
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return mon;
    }
}
