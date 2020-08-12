package com.jhw.gestion.modules.contabilidad.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"tipoMoneda"})
public class MonedaDomain extends EntityDomainObjectValidated {

    private Integer idMoneda;

    @NotEmpty(message = "#msg.module.contabilidad.validation.moneda_nombre_vacio#")
    @Size(max = 3, message = "#msg.module.contabilidad.validation.moneda_nombre_largo#")
    private String tipoMoneda;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.moneda_compra_negativo#")
    private float compra;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.moneda_venta_negativo#")
    private float venta;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public MonedaDomain() {
    }

    public MonedaDomain(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public MonedaDomain(String tipoMoneda, float compra, float venta, String descripcion) {
        this.tipoMoneda = tipoMoneda;
        this.compra = compra;
        this.venta = venta;
        this.descripcion = descripcion;
        validate();
    }

    @Override
    public String toString() {
        return tipoMoneda;
    }

    public Integer getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public float getCompra() {
        return compra;
    }

    public void setCompra(float compra) {
        this.compra = compra;
    }

    public float getVenta() {
        return venta;
    }

    public void setVenta(float venta) {
        this.venta = venta;
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
        hash += (idMoneda != null ? idMoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonedaDomain)) {
            return false;
        }
        MonedaDomain other = (MonedaDomain) object;
        if ((this.idMoneda == null && other.idMoneda != null) || (this.idMoneda != null && !this.idMoneda.equals(other.idMoneda))) {
            return false;
        }
        return true;
    }

}
