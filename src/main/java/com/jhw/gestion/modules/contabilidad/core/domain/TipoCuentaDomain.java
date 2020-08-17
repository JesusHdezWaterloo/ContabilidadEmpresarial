/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"nombreTipoCuenta"})
public class TipoCuentaDomain extends EntityDomainObjectValidated {

    private Integer idTipoCuenta;

    @NotEmpty(message = "#msg.module.contabilidad.validation.tipo_cuenta_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.tipo_cuenta_nombre_largo#")
    private String nombreTipoCuenta;

    private boolean debitoCredito;

    private boolean liquidable;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public TipoCuentaDomain() {
    }

    public TipoCuentaDomain(Integer idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public TipoCuentaDomain(String nombreTipoCuenta, boolean debitoCredito, boolean liquidable, String descripcion) {
        this.nombreTipoCuenta = nombreTipoCuenta;
        this.debitoCredito = debitoCredito;
        this.liquidable = liquidable;
        this.descripcion = descripcion;
    }

    public boolean isLiquidable() {
        return liquidable;
    }

    public void setLiquidable(boolean liquidable) {
        this.liquidable = liquidable;
    }

    public Integer getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(Integer idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getNombreTipoCuenta() {
        return nombreTipoCuenta;
    }

    public void setNombreTipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }

    public boolean getDebitoCredito() {
        return debitoCredito;
    }

    public void setDebitoCredito(boolean debitoCredito) {
        this.debitoCredito = debitoCredito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCuenta != null ? idTipoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuentaDomain)) {
            return false;
        }
        TipoCuentaDomain other = (TipoCuentaDomain) object;
        if ((this.idTipoCuenta == null && other.idTipoCuenta != null) || (this.idTipoCuenta != null && !this.idTipoCuenta.equals(other.idTipoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTipoCuenta;
    }

}
