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
@SortBy(priority = {"nombreOperacion"})
public class TipoOperacionContableDomain extends EntityDomainObjectValidated {

    private Integer idTipoOperacion;

    @NotEmpty(message = "#msg.module.contabilidad.validation.tipo_operacion_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.tipo_operacion_nombre_largo#")
    private String nombreOperacion;

    @NotEmpty(message = "#msg.module.contabilidad.validation.tipo_operacion_key_enum_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.tipo_operacion_key_enum_largo#")
    private String keyEnum;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public TipoOperacionContableDomain() {
    }

    public TipoOperacionContableDomain(Integer idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public TipoOperacionContableDomain(Integer idTipoOperacion, String nombreOperacion, String keyEnum, String descripcion) {
        this.idTipoOperacion = idTipoOperacion;
        this.nombreOperacion = nombreOperacion;
        this.keyEnum = keyEnum;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(Integer idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public String getKeyEnum() {
        return keyEnum;
    }

    public void setKeyEnum(String keyEnum) {
        this.keyEnum = keyEnum;
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
        hash += (idTipoOperacion != null ? idTipoOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOperacionContableDomain)) {
            return false;
        }
        TipoOperacionContableDomain other = (TipoOperacionContableDomain) object;
        if ((this.idTipoOperacion == null && other.idTipoOperacion != null) || (this.idTipoOperacion != null && !this.idTipoOperacion.equals(other.idTipoOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreOperacion;
    }

}
