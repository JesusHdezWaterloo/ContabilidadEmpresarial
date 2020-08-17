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

    private double debito;
    private MonedaDomain monedaDebito1;

    private double credito;
    private MonedaDomain monedaCredito1;

    private CuentaContableDomain cuenta;
    private CuentaContableDomain cuentaCuadre;

    private InfoOperacionContableDomain info;

    public CuadreUI(double debito, MonedaDomain monedaDebito1, double credito, MonedaDomain monedaCredito1, CuentaContableDomain cuenta, CuentaContableDomain cuentaCuadre, InfoOperacionContableDomain info) {
        this.debito = debito;
        this.monedaDebito1 = monedaDebito1;
        this.credito = credito;
        this.monedaCredito1 = monedaCredito1;
        this.cuenta = cuenta;
        this.cuentaCuadre = cuentaCuadre;
        this.info = info;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    public MonedaDomain getMonedaDebito1() {
        return monedaDebito1;
    }

    public void setMonedaDebito1(MonedaDomain monedaDebito1) {
        this.monedaDebito1 = monedaDebito1;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public MonedaDomain getMonedaCredito1() {
        return monedaCredito1;
    }

    public void setMonedaCredito1(MonedaDomain monedaCredito1) {
        this.monedaCredito1 = monedaCredito1;
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
