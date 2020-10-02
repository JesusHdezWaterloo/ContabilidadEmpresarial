/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.core.domain.facade;

import com.clean.core.domain.VolatileDomainObject;
import com.jhw.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.module.gestion.contabilidad.core.domain.MonedaDomain;
import com.jhw.module.gestion.contabilidad.core.domain.TipoOperacionContableDomain;
import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class OperacionCuadreUI extends VolatileDomainObject {

    private BigDecimal valor;
    private MonedaDomain moneda;
    private CuentaContableDomain cuenta;
    private CuentaContableDomain cuadre;
    private TipoOperacionContableDomain tipoOp;

    public OperacionCuadreUI() {
    }

    public OperacionCuadreUI(BigDecimal valor, MonedaDomain moneda, CuentaContableDomain cuenta, CuentaContableDomain cuadre, TipoOperacionContableDomain tipoOp) {
        this.valor = valor;
        this.moneda = moneda;
        this.cuenta = cuenta;
        this.cuadre = cuadre;
        this.tipoOp = tipoOp;
    }

    public OperacionCuadreUI(CuadreDomain cuadre) {
        this.valor = cuadre.getOperacionContableFk().getCuentaFk().getTipoCuentaFk().getDebitoCredito() ? cuadre.getOperacionContableFk().getDebito() : cuadre.getOperacionContableFk().getCredito();
        this.moneda = cuadre.getOperacionContableFk().getCuentaFk().getMonedaFk();
        this.cuenta = cuadre.getOperacionContableFk().getCuentaFk();
        this.cuadre = cuadre.getOperacionContableCuadreFk().getCuentaFk();
        this.tipoOp = cuadre.info().getTipoOperacionFk();
    }

    public TipoOperacionContableDomain getTipoOp() {
        return tipoOp;
    }

    public void setTipoOp(TipoOperacionContableDomain tipoOp) {
        this.tipoOp = tipoOp;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
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
