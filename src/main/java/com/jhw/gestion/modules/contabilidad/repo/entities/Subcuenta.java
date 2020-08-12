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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "subcuenta", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cuenta_padre_fk", "cuenta_hijo_fk"})})
@NamedQueries({
    @NamedQuery(name = "Subcuenta.findAll", query = "SELECT s FROM Subcuenta s"),
    @NamedQuery(name = "Subcuenta.findByIdSubcuenta", query = "SELECT s FROM Subcuenta s WHERE s.idSubcuenta = :idSubcuenta"),
    @NamedQuery(name = "Subcuenta.findByDescripcion", query = "SELECT s FROM Subcuenta s WHERE s.descripcion = :descripcion")})
public class Subcuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_subcuenta", nullable = false)
    private Integer idSubcuenta;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    @JoinColumn(name = "cuenta_hijo_fk", referencedColumnName = "id_cuenta", nullable = false)
    @ManyToOne(optional = false)
    private Cuenta cuentaHijoFk;
    @JoinColumn(name = "cuenta_padre_fk", referencedColumnName = "id_cuenta", nullable = false)
    @ManyToOne(optional = false)
    private Cuenta cuentaPadreFk;

    public Subcuenta() {
    }

    public Subcuenta(Integer idSubcuenta) {
        this.idSubcuenta = idSubcuenta;
    }

    public Subcuenta(Integer idSubcuenta, String descripcion) {
        this.idSubcuenta = idSubcuenta;
        this.descripcion = descripcion;
    }

    public Integer getIdSubcuenta() {
        return idSubcuenta;
    }

    public void setIdSubcuenta(Integer idSubcuenta) {
        this.idSubcuenta = idSubcuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cuenta getCuentaHijoFk() {
        return cuentaHijoFk;
    }

    public void setCuentaHijoFk(Cuenta cuentaHijoFk) {
        this.cuentaHijoFk = cuentaHijoFk;
    }

    public Cuenta getCuentaPadreFk() {
        return cuentaPadreFk;
    }

    public void setCuentaPadreFk(Cuenta cuentaPadreFk) {
        this.cuentaPadreFk = cuentaPadreFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubcuenta != null ? idSubcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcuenta)) {
            return false;
        }
        Subcuenta other = (Subcuenta) object;
        if ((this.idSubcuenta == null && other.idSubcuenta != null) || (this.idSubcuenta != null && !this.idSubcuenta.equals(other.idSubcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.Subcuenta[ idSubcuenta=" + idSubcuenta + " ]";
    }
    
}
