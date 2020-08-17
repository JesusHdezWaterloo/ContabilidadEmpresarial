/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain.facade;

import com.clean.core.domain.VolatileDomainObject;
import com.jhw.gestion.modules.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.InfoOperacionContableDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CuadreUI extends VolatileDomainObject {

    private double valor;
    private MonedaDomain moneda;

    private CuentaContableDomain cuenta;
    private CuentaContableDomain cuentaCuadre;

    private InfoOperacionContableDomain info;

    public CuadreUI(double valor, MonedaDomain moneda, CuentaContableDomain cuenta, CuentaContableDomain cuentaCuadre, InfoOperacionContableDomain info) {
        this.valor = valor;
        this.moneda = moneda;
        this.cuenta = cuenta;
        this.cuentaCuadre = cuentaCuadre;
        this.info = info;
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

    public CuentaContableDomain getCuentaCuadre() {
        return cuentaCuadre;
    }

    public void setCuentaCuadre(CuentaContableDomain cuentaCuadre) {
        this.cuentaCuadre = cuentaCuadre;
    }

    public InfoOperacionContableDomain getInfo() {
        return info;
    }

    public void setInfo(InfoOperacionContableDomain info) {
        this.info = info;
    }

}
