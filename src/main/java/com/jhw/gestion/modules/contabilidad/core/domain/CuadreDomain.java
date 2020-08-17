/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import com.jhw.gestion.modules.contabilidad.core.domain.facade.CuadreUI;
import com.clean.core.utils.SortBy;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"liquidada"}, order = SortBy.ASCENDING)
public class CuadreDomain extends EntityDomainObjectValidated {

    private static final long serialVersionUID = 1L;

    private Integer idCuadre;

    private boolean liquidada;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.cuadre_operacion_contable_null#")
    private OperacionContableDomain operacionContableCuadreFk;

    @NotNull(message = "#msg.module.contabilidad.validation.cuadre_operacion_contable_null#")
    private OperacionContableDomain operacionContableFk;

    public CuadreDomain() {
    }

    public CuadreDomain(Integer idCuadre) {
        this.idCuadre = idCuadre;
    }

    public CuadreDomain(boolean liquidada, String descripcion, OperacionContableDomain operacionContableCuadreFk, OperacionContableDomain operacionContableFk) {
        this.liquidada = liquidada;
        this.descripcion = descripcion;
        this.operacionContableCuadreFk = operacionContableCuadreFk;
        this.operacionContableFk = operacionContableFk;
    }

    public CuadreDomain(CuadreUI cuadre) {
        updateWith(cuadre);
    }

    public void updateWith(CuadreUI cuadre) {
        double debitoConvertidoCuenta = MonedaHandler.venta(cuadre.getDebito(), cuadre.getMonedaDebito1(), cuadre.getCuenta().getMonedaFk());
        double creditoConvertidoCuenta = MonedaHandler.venta(cuadre.getCredito(), cuadre.getMonedaCredito1(), cuadre.getCuenta().getMonedaFk());
        operacionContableFk = new OperacionContableDomain(debitoConvertidoCuenta, creditoConvertidoCuenta, cuadre.getCuenta(), cuadre.getInfo());

        double debitoConvertidoCuentaCuadre = MonedaHandler.venta(cuadre.getDebito(), cuadre.getMonedaDebito1(), cuadre.getCuentaCuadre().getMonedaFk());
        double creditoConvertidoCuentaCuadre = MonedaHandler.venta(cuadre.getCredito(), cuadre.getMonedaCredito1(), cuadre.getCuentaCuadre().getMonedaFk());
        //debito y credito invertido para mantener equilibrio
        operacionContableFk = new OperacionContableDomain(creditoConvertidoCuentaCuadre, debitoConvertidoCuentaCuadre, cuadre.getCuentaCuadre(), cuadre.getInfo());

        descripcion = cuadre.getInfo().getDescripcion();
        liquidada = false;
        
        validate();
    }

    public InfoOperacionContableDomain info() {
        return operacionContableCuadreFk.getInfoOperacionContableFk();
    }

    public Integer getIdCuadre() {
        return idCuadre;
    }

    public void setIdCuadre(Integer idCuadre) {
        this.idCuadre = idCuadre;
    }

    public boolean getLiquidada() {
        return liquidada;
    }

    public void setLiquidada(boolean liquidada) {
        this.liquidada = liquidada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public OperacionContableDomain getOperacionContableCuadreFk() {
        return operacionContableCuadreFk;
    }

    public void setOperacionContableCuadreFk(OperacionContableDomain operacionContableCuadreFk) {
        this.operacionContableCuadreFk = operacionContableCuadreFk;
    }

    public OperacionContableDomain getOperacionContableFk() {
        return operacionContableFk;
    }

    public void setOperacionContableFk(OperacionContableDomain operacionContableFk) {
        this.operacionContableFk = operacionContableFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuadre != null ? idCuadre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuadreDomain)) {
            return false;
        }
        CuadreDomain other = (CuadreDomain) object;
        if ((this.idCuadre == null && other.idCuadre != null) || (this.idCuadre != null && !this.idCuadre.equals(other.idCuadre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return operacionContableCuadreFk.toString();
    }

}
