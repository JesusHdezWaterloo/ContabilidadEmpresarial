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
@Table(name = "tipo_deposito", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_tipo_deposito"})})
@NamedQueries({
    @NamedQuery(name = "TipoDeposito.findAll", query = "SELECT t FROM TipoDeposito t"),
    @NamedQuery(name = "TipoDeposito.findByIdTipoDeposito", query = "SELECT t FROM TipoDeposito t WHERE t.idTipoDeposito = :idTipoDeposito"),
    @NamedQuery(name = "TipoDeposito.findByNombreTipoDeposito", query = "SELECT t FROM TipoDeposito t WHERE t.nombreTipoDeposito = :nombreTipoDeposito"),
    @NamedQuery(name = "TipoDeposito.findByDescripcion", query = "SELECT t FROM TipoDeposito t WHERE t.descripcion = :descripcion")})
public class TipoDeposito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_deposito", nullable = false)
    private Integer idTipoDeposito;
    @Basic(optional = false)
    @Column(name = "nombre_tipo_deposito", nullable = false, length = 100)
    private String nombreTipoDeposito;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public TipoDeposito() {
    }

    public TipoDeposito(Integer idTipoDeposito) {
        this.idTipoDeposito = idTipoDeposito;
    }

    public TipoDeposito(Integer idTipoDeposito, String nombreTipoDeposito, String descripcion) {
        this.idTipoDeposito = idTipoDeposito;
        this.nombreTipoDeposito = nombreTipoDeposito;
        this.descripcion = descripcion;
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
        if (!(object instanceof TipoDeposito)) {
            return false;
        }
        TipoDeposito other = (TipoDeposito) object;
        if ((this.idTipoDeposito == null && other.idTipoDeposito != null) || (this.idTipoDeposito != null && !this.idTipoDeposito.equals(other.idTipoDeposito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.TipoDeposito[ idTipoDeposito=" + idTipoDeposito + " ]";
    }
    
}
