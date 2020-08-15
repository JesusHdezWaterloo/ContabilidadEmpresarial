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
@Table(name = "metodo_pago", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_metodo_pago"})})
@NamedQueries({
    @NamedQuery(name = "MetodoPago.findAll", query = "SELECT m FROM MetodoPago m"),
    @NamedQuery(name = "MetodoPago.findByIdMetodoPago", query = "SELECT m FROM MetodoPago m WHERE m.idMetodoPago = :idMetodoPago"),
    @NamedQuery(name = "MetodoPago.findByNombreMetodoPago", query = "SELECT m FROM MetodoPago m WHERE m.nombreMetodoPago = :nombreMetodoPago"),
    @NamedQuery(name = "MetodoPago.findByDescripcion", query = "SELECT m FROM MetodoPago m WHERE m.descripcion = :descripcion")})
public class MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_metodo_pago", nullable = false)
    private Integer idMetodoPago;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_metodo_pago", nullable = false, length = 100)
    private String nombreMetodoPago;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public MetodoPago() {
    }

    public MetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public MetodoPago(Integer idMetodoPago, String nombreMetodoPago, String descripcion) {
        this.idMetodoPago = idMetodoPago;
        this.nombreMetodoPago = nombreMetodoPago;
        this.descripcion = descripcion;
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
        if (!(object instanceof MetodoPago)) {
            return false;
        }
        MetodoPago other = (MetodoPago) object;
        if ((this.idMetodoPago == null && other.idMetodoPago != null) || (this.idMetodoPago != null && !this.idMetodoPago.equals(other.idMetodoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.contabilidad_empresarial.MetodoPago[ idMetodoPago=" + idMetodoPago + " ]";
    }
    
}
