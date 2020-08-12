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
@Table(name = "tipo_extraccion", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_tipo_extraccion"})})
@NamedQueries({
    @NamedQuery(name = "TipoExtraccion.findAll", query = "SELECT t FROM TipoExtraccion t"),
    @NamedQuery(name = "TipoExtraccion.findByIdTipoExtraccion", query = "SELECT t FROM TipoExtraccion t WHERE t.idTipoExtraccion = :idTipoExtraccion"),
    @NamedQuery(name = "TipoExtraccion.findByNombreTipoExtraccion", query = "SELECT t FROM TipoExtraccion t WHERE t.nombreTipoExtraccion = :nombreTipoExtraccion"),
    @NamedQuery(name = "TipoExtraccion.findByDescripcion", query = "SELECT t FROM TipoExtraccion t WHERE t.descripcion = :descripcion")})
public class TipoExtraccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_extraccion", nullable = false)
    private Integer idTipoExtraccion;
    @Basic(optional = false)
    @Column(name = "nombre_tipo_extraccion", nullable = false, length = 100)
    private String nombreTipoExtraccion;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public TipoExtraccion() {
    }

    public TipoExtraccion(Integer idTipoExtraccion) {
        this.idTipoExtraccion = idTipoExtraccion;
    }

    public TipoExtraccion(Integer idTipoExtraccion, String nombreTipoExtraccion, String descripcion) {
        this.idTipoExtraccion = idTipoExtraccion;
        this.nombreTipoExtraccion = nombreTipoExtraccion;
        this.descripcion = descripcion;
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
        if (!(object instanceof TipoExtraccion)) {
            return false;
        }
        TipoExtraccion other = (TipoExtraccion) object;
        if ((this.idTipoExtraccion == null && other.idTipoExtraccion != null) || (this.idTipoExtraccion != null && !this.idTipoExtraccion.equals(other.idTipoExtraccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.TipoExtraccion[ idTipoExtraccion=" + idTipoExtraccion + " ]";
    }
    
}
