/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import com.jhw.gestion.modules.contabilidad.repo.entities.*;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CuadreDomain extends EntityDomainObjectValidated {

    private static final long serialVersionUID = 1L;

    private Integer idCuadre;

    private boolean liquidada;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.cuadre_operacion_contable_null#")
    private OperacionContable operacionContableCuadreFk;

    @NotNull(message = "#msg.module.contabilidad.validation.cuadre_operacion_contable_null#")
    private OperacionContable operacionContableFk;

    public CuadreDomain() {
    }

    public CuadreDomain(Integer idCuadre) {
        this.idCuadre = idCuadre;
    }

    public CuadreDomain(boolean liquidada, String descripcion, OperacionContable operacionContableCuadreFk, OperacionContable operacionContableFk) {
        this.liquidada = liquidada;
        this.descripcion = descripcion;
        this.operacionContableCuadreFk = operacionContableCuadreFk;
        this.operacionContableFk = operacionContableFk;
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

    public OperacionContable getOperacionContableCuadreFk() {
        return operacionContableCuadreFk;
    }

    public void setOperacionContableCuadreFk(OperacionContable operacionContableCuadreFk) {
        this.operacionContableCuadreFk = operacionContableCuadreFk;
    }

    public OperacionContable getOperacionContableFk() {
        return operacionContableFk;
    }

    public void setOperacionContableFk(OperacionContable operacionContableFk) {
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
        return "testJPA.entities.contabilidad_empresarial.Cuadre[ idCuadre=" + idCuadre + " ]";
    }

}
