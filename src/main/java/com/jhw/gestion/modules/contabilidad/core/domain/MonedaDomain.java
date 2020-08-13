/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"nombreMoneda"})
public class MonedaDomain extends EntityDomainObjectValidated {

    private Integer idMoneda;

    @NotEmpty(message = "#msg.module.contabilidad.validation.moneda_nombre_vacio#")
    @Size(max = 3, message = "#msg.module.contabilidad.validation.moneda_nombre_largo#")
    private String nombreMoneda;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.moneda_compra_negativo#")
    private double compra;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.moneda_venta_negativo#")
    private double venta;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    public MonedaDomain() {
    }

    public MonedaDomain(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public MonedaDomain(String nombreMoneda, float compra, float venta, String descripcion) {
        this.nombreMoneda = nombreMoneda;
        this.compra = compra;
        this.venta = venta;
        this.descripcion = descripcion;
    }

    public Integer getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public double getCompra() {
        return compra;
    }

    public void setCompra(double compra) {
        this.compra = compra;
    }

    public double getVenta() {
        return venta;
    }

    public void setVenta(double venta) {
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

    @Override
    public String toString() {
        return nombreMoneda;
    }

}
