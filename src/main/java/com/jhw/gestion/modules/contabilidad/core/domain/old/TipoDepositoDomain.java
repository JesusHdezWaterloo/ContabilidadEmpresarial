/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain.old;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"nombreTipoDeposito"})
public class TipoDepositoDomain extends EntityDomainObjectValidated {

    private Integer idTipoDeposito;

    @NotEmpty(message = "#msg.module.contabilidad.validation.tipo_deposito_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.tipo_deposito_nombre_largo#")
    private String nombreTipoDeposito;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public TipoDepositoDomain() {
    }

    public TipoDepositoDomain(Integer idTipoDeposito) {
        this.idTipoDeposito = idTipoDeposito;
    }

    public TipoDepositoDomain(String nombreTipoDeposito, String descripcion) {
        this.nombreTipoDeposito = nombreTipoDeposito;
        this.descripcion = descripcion;
        validate();
    }

    public Integer getIdTipoDeposito() {
        return idTipoDeposito;
    }

    public void setIdTipoDeposito(Integer idTipoDeposito) {
        this.idTipoDeposito = idTipoDeposito;
    }

    public String getNombreTipoDeposito() {
        return nombreTipoDeposito;
    }

    public void setNombreTipoDeposito(String nombreTipoDeposito) {
        this.nombreTipoDeposito = nombreTipoDeposito;
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
        hash += (idTipoDeposito != null ? idTipoDeposito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDepositoDomain)) {
            return false;
        }
        TipoDepositoDomain other = (TipoDepositoDomain) object;
        if ((this.idTipoDeposito == null && other.idTipoDeposito != null) || (this.idTipoDeposito != null && !this.idTipoDeposito.equals(other.idTipoDeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTipoDeposito;
    }

}
