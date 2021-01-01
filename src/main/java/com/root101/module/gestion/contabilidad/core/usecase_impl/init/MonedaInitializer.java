/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.core.usecase_impl.init;

import com.jhw.module.gestion.contabilidad.core.domain.MonedaDomain;
import com.jhw.module.gestion.contabilidad.core.usecase_def.MonedaUseCase;
import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MonedaInitializer {

    private static final MonedaDomain monedaDEFAULT = new MonedaDomain("MN", BigDecimal.ONE, BigDecimal.ONE, "Moneda por defecto con cambio 1 x 1");

    public static void init(MonedaUseCase monedaUC) {
        try {
            if (monedaUC.count() == 0) {
                monedaUC.create(monedaDEFAULT);
            }
        } catch (Exception e) {
        }
    }
}
