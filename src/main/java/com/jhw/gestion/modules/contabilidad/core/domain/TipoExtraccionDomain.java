package com.jhw.gestion.modules.contabilidad.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"nombreTipoExtraccion"})
public class TipoExtraccionDomain extends EntityDomainObjectValidated {

    private Integer idTipoExtraccion;

    @NotEmpty(message = "#msg.module.contabilidad.validation.tipo_extraccion_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.tipo_extraccion_nombre_largo#")
    private String nombreTipoExtraccion;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public TipoExtraccionDomain() {
    }

    public TipoExtraccionDomain(Integer idTipoExtraccion) {
        this.idTipoExtraccion = idTipoExtraccion;
    }

    public TipoExtraccionDomain(String nombreTipoExtraccion, String descripcion) {
        this.nombreTipoExtraccion = nombreTipoExtraccion;
        this.descripcion = descripcion;
        validate();
    }

    public Integer getIdTipoExtraccion() {
        return idTipoExtraccion;
    }

    public void setIdTipoExtraccion(Integer idTipoExtraccion) {
        this.idTipoExtraccion = idTipoExtraccion;
    }

    public String getNombreTipoExtraccion() {
        return nombreTipoExtraccion;
    }

    public void setNombreTipoExtraccion(String nombreTipoExtraccion) {
        this.nombreTipoExtraccion = nombreTipoExtraccion;
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
        hash += (idTipoExtraccion != null ? idTipoExtraccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoExtraccionDomain)) {
            return false;
        }
        TipoExtraccionDomain other = (TipoExtraccionDomain) object;
        if ((this.idTipoExtraccion == null && other.idTipoExtraccion != null) || (this.idTipoExtraccion != null && !this.idTipoExtraccion.equals(other.idTipoExtraccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreTipoExtraccion;
    }

}
