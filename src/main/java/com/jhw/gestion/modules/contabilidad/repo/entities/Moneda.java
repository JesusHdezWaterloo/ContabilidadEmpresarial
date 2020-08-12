/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.repo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "moneda", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tipo_moneda"})})
@NamedQueries({
    @NamedQuery(name = "Moneda.findAll", query = "SELECT m FROM Moneda m"),
    @NamedQuery(name = "Moneda.findByIdMoneda", query = "SELECT m FROM Moneda m WHERE m.idMoneda = :idMoneda"),
    @NamedQuery(name = "Moneda.findByTipoMoneda", query = "SELECT m FROM Moneda m WHERE m.tipoMoneda = :tipoMoneda"),
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
    @Column(name = "tipo_moneda", nullable = false, length = 3)
    private String tipoMoneda;
    @Basic(optional = false)
    @Column(name = "compra", nullable = false)
    private float compra;
    @Basic(optional = false)
    @Column(name = "venta", nullable = false)
    private float venta;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public Moneda() {
    }

    public Moneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Moneda(Integer idMoneda, String tipoMoneda, float compra, float venta, String descripcion) {
        this.idMoneda = idMoneda;
        this.tipoMoneda = tipoMoneda;
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
        return "testJPA.entities.Moneda[ idMoneda=" + idMoneda + " ]";
    }
    
}
