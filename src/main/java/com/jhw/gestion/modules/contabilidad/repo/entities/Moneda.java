/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.repo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "moneda", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_moneda"})})
@NamedQueries({
    @NamedQuery(name = "Moneda.findAll", query = "SELECT m FROM Moneda m"),
    @NamedQuery(name = "Moneda.findByIdMoneda", query = "SELECT m FROM Moneda m WHERE m.idMoneda = :idMoneda"),
    @NamedQuery(name = "Moneda.findByNombreMoneda", query = "SELECT m FROM Moneda m WHERE m.nombreMoneda = :nombreMoneda"),
    @NamedQuery(name = "Moneda.findByCompra", query = "SELECT m FROM Moneda m WHERE m.compra = :compra"),
    @NamedQuery(name = "Moneda.findByVenta", query = "SELECT m FROM Moneda m WHERE m.venta = :venta"),
    @NamedQuery(name = "Moneda.findByDescripcion", query = "SELECT m FROM Moneda m WHERE m.descripcion = :descripcion")})
public class Moneda implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_moneda", nullable = false)
    private Integer idMoneda;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "nombre_moneda", nullable = false, length = 5)
    private String nombreMoneda;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "compra", nullable = false)
    private double compra;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "venta", nullable = false)
    private double venta;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public Moneda() {
    }

    public Moneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Moneda(Integer idMoneda, String nombreMoneda, double compra, double venta, String descripcion) {
        this.idMoneda = idMoneda;
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
        if (!(object instanceof Moneda)) {
            return false;
        }
        Moneda other = (Moneda) object;
        if ((this.idMoneda == null && other.idMoneda != null) || (this.idMoneda != null && !this.idMoneda.equals(other.idMoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.contabilidad_empresarial.Moneda[ idMoneda=" + idMoneda + " ]";
    }
    
}
