/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface DebitoCredito {

    public double getDebito();

    public void setDebito(double debito);

    public double getCredito();

    public void setCredito(double credito);

    public default void increase(DebitoCredito newObject) {
        setDebito(getDebito() + newObject.getDebito());
        setCredito(getCredito() + newObject.getCredito());
    }

    public default void decrease(DebitoCredito newObject) {
        setDebito(getDebito() - newObject.getDebito());
        setCredito(getCredito() - newObject.getCredito());
    }
}
