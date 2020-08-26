/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface DebitoCredito {

    public BigDecimal getDebito();

    public void setDebito(BigDecimal debito);

    public BigDecimal getCredito();

    public void setCredito(BigDecimal credito);

    public default void increase(DebitoCredito newObject) {
        setDebito(getDebito().add(newObject.getDebito()));
        setCredito(getCredito().add(newObject.getCredito()));
    }

    public default void decrease(DebitoCredito newObject) {
        setDebito(getDebito().subtract(newObject.getDebito()));
        setCredito(getCredito().subtract(newObject.getCredito()));
    }
}
