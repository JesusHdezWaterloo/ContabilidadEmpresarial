/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class SubcuentaDomain extends EntityDomainObjectValidated {

    private Integer idSubcuenta;

    @Max(value = 100, message = "#msg.module.contabilidad.validation.porciento_mayor_que_100#")
    @PositiveOrZero(message = "#msg.module.contabilidad.validation.porciento_negativo#")
    private float pociento;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.subcuenta_hijo_null#")
    private CuentaContableDomain cuentaHijoFk;

    @NotNull(message = "#msg.module.contabilidad.validation.subcuenta_padre_null#")
    private CuentaContableDomain cuentaPadreFk;

    public SubcuentaDomain() {
    }

    public SubcuentaDomain(Integer idSubcuenta) {
        this.idSubcuenta = idSubcuenta;
    }

    public SubcuentaDomain(float pociento, String descripcion, CuentaContableDomain cuentaHijoFk, CuentaContableDomain cuentaPadreFk) {
        this.pociento = pociento;
        this.descripcion = descripcion;
        this.cuentaHijoFk = cuentaHijoFk;
        this.cuentaPadreFk = cuentaPadreFk;
    }

    public Integer getIdSubcuenta() {
        return idSubcuenta;
    }

    public void setIdSubcuenta(Integer idSubcuenta) {
        this.idSubcuenta = idSubcuenta;
    }

    public float getPociento() {
        return pociento;
    }

    public void setPociento(float pociento) {
        this.pociento = pociento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CuentaContableDomain getCuentaHijoFk() {
        return cuentaHijoFk;
    }

    public void setCuentaHijoFk(CuentaContableDomain cuentaHijoFk) {
        this.cuentaHijoFk = cuentaHijoFk;
    }

    public CuentaContableDomain getCuentaPadreFk() {
        return cuentaPadreFk;
    }

    public void setCuentaPadreFk(CuentaContableDomain cuentaPadreFk) {
        this.cuentaPadreFk = cuentaPadreFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubcuenta != null ? idSubcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubcuentaDomain)) {
            return false;
        }
        SubcuentaDomain other = (SubcuentaDomain) object;
        if ((this.idSubcuenta == null && other.idSubcuenta != null) || (this.idSubcuenta != null && !this.idSubcuenta.equals(other.idSubcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Padre: " + cuentaPadreFk + " - Hijo: " + cuentaHijoFk;
    }

}
