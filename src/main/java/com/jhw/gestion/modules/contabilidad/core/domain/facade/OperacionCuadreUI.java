/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain.facade;

import com.clean.core.domain.VolatileDomainObject;
import com.jhw.gestion.modules.contabilidad.core.domain.CuadreDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class OperacionCuadreUI extends VolatileDomainObject {

    private double valor;
    private MonedaDomain moneda;
    private CuentaContableDomain cuenta;
    private CuentaContableDomain cuadre;

    public OperacionCuadreUI() {
    }

    public OperacionCuadreUI(double valor, MonedaDomain moneda, CuentaContableDomain cuenta, CuentaContableDomain cuadre) {
        this.valor = valor;
        this.moneda = moneda;
        this.cuenta = cuenta;
        this.cuadre = cuadre;
    }

    public OperacionCuadreUI(CuadreDomain cuadre) {
        this.valor = cuadre.getOperacionContableFk().getCuentaFk().getTipoCuentaFk().getDebitoCredito() ? cuadre.getOperacionContableFk().getDebito() : cuadre.getOperacionContableFk().getCredito();
        this.moneda = cuadre.getOperacionContableFk().getCuentaFk().getMonedaFk();
        this.cuenta = cuadre.getOperacionContableFk().getCuentaFk();
        this.cuadre = cuadre.getOperacionContableCuadreFk().getCuentaFk();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public MonedaDomain getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaDomain moneda) {
        this.moneda = moneda;
    }

    public CuentaContableDomain getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaContableDomain cuenta) {
        this.cuenta = cuenta;
    }

    public CuentaContableDomain getCuadre() {
        return cuadre;
    }

    public void setCuadre(CuentaContableDomain cuadre) {
        this.cuadre = cuadre;
    }
}
