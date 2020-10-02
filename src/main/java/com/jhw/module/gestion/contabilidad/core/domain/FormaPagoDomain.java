/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"nombreFormaPago"})
public class FormaPagoDomain extends EntityDomainObjectValidated {

    private Integer idFormaPago;

    @NotEmpty(message = "#msg.module.contabilidad.validation.forma_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.forma_nombre_largo#")
    private String nombreFormaPago;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public FormaPagoDomain() {
    }

    public FormaPagoDomain(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public FormaPagoDomain(String nombreFormaPago, String descripcion) {
        this.nombreFormaPago = nombreFormaPago;
        this.descripcion = descripcion;
    }

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getNombreFormaPago() {
        return nombreFormaPago;
    }

    public void setNombreFormaPago(String nombreFormaPago) {
        this.nombreFormaPago = nombreFormaPago;
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
        hash += (idFormaPago != null ? idFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPagoDomain)) {
            return false;
        }
        FormaPagoDomain other = (FormaPagoDomain) object;
        if ((this.idFormaPago == null && other.idFormaPago != null) || (this.idFormaPago != null && !this.idFormaPago.equals(other.idFormaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreFormaPago;
    }

}
