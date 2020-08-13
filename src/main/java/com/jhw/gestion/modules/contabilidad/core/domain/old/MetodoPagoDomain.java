package com.jhw.gestion.modules.contabilidad.core.domain.old;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"nombreMetodoPago"})
public class MetodoPagoDomain extends EntityDomainObjectValidated {

    private Integer idMetodoPago;

    @NotEmpty(message = "#msg.module.contabilidad.validation.metodo_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.metodo_nombre_largo#")
    private String nombreMetodoPago;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public MetodoPagoDomain() {
    }

    public MetodoPagoDomain(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public MetodoPagoDomain(String nombreMetodoPago, String descripcion) {
        this.nombreMetodoPago = nombreMetodoPago;
        this.descripcion = descripcion;
        validate();
    }

    public Integer getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getNombreMetodoPago() {
        return nombreMetodoPago;
    }

    public void setNombreMetodoPago(String nombreMetodoPago) {
        this.nombreMetodoPago = nombreMetodoPago;
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
        hash += (idMetodoPago != null ? idMetodoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetodoPagoDomain)) {
            return false;
        }
        MetodoPagoDomain other = (MetodoPagoDomain) object;
        if ((this.idMetodoPago == null && other.idMetodoPago != null) || (this.idMetodoPago != null && !this.idMetodoPago.equals(other.idMetodoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreMetodoPago;
    }

}
