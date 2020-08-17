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

    private OperacionCuadreDomain op;
    private InfoOperacionContableDomain info;

    public CuadreUI(OperacionCuadreDomain op, InfoOperacionContableDomain info) {
        this.op = op;
        this.info = info;
    }

    public double getValor() {
        return op.getValor();
    }

    public MonedaDomain getMoneda() {
        return op.getMoneda();
    }

    public CuentaContableDomain getCuenta() {
        return op.getCuenta();
    }

    public CuentaContableDomain getCuentaCuadre() {
        return op.getCuadre();
    }

    public InfoOperacionContableDomain getInfo() {
        return info;
    }

    public OperacionCuadreDomain getOp() {
        return op;
    }

}
