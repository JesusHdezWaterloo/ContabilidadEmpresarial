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

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "extraccion_cuenta")
@NamedQueries({
    @NamedQuery(name = "ExtraccionCuenta.findAll", query = "SELECT e FROM ExtraccionCuenta e"),
    @NamedQuery(name = "ExtraccionCuenta.findByIdExtraccionCuenta", query = "SELECT e FROM ExtraccionCuenta e WHERE e.idExtraccionCuenta = :idExtraccionCuenta"),
    @NamedQuery(name = "ExtraccionCuenta.findByNombreExtraccCta", query = "SELECT e FROM ExtraccionCuenta e WHERE e.nombreExtraccCta = :nombreExtraccCta"),
    @NamedQuery(name = "ExtraccionCuenta.findByValor", query = "SELECT e FROM ExtraccionCuenta e WHERE e.valor = :valor"),
    @NamedQuery(name = "ExtraccionCuenta.findByDescripcion", query = "SELECT e FROM ExtraccionCuenta e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "ExtraccionCuenta.findByIdExterno", query = "SELECT e FROM ExtraccionCuenta e WHERE e.idExterno = :idExterno")})
public class ExtraccionCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_extraccion_cuenta", nullable = false)
    private Integer idExtraccionCuenta;
    @Basic(optional = false)
    @Column(name = "nombre_extracc_cta", nullable = false, length = 100)
    private String nombreExtraccCta;
    @Basic(optional = false)
    @Column(name = "valor", nullable = false)
    private float valor;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "id_externo", nullable = false)
    private int idExterno;
    @JoinColumn(name = "cuenta_fk", referencedColumnName = "id_cuenta", nullable = false)
    @ManyToOne(optional = false)
    private Cuenta cuentaFk;
    @JoinColumn(name = "tipo_extraccion", referencedColumnName = "id_tipo_extraccion", nullable = false)
    @ManyToOne(optional = false)
    private TipoExtraccion tipoExtraccion;

    public ExtraccionCuenta() {
    }

    public ExtraccionCuenta(Integer idExtraccionCuenta) {
        this.idExtraccionCuenta = idExtraccionCuenta;
    }

    public ExtraccionCuenta(Integer idExtraccionCuenta, String nombreExtraccCta, float valor, String descripcion, int idExterno) {
        this.idExtraccionCuenta = idExtraccionCuenta;
        this.nombreExtraccCta = nombreExtraccCta;
        this.valor = valor;
        this.descripcion = descripcion;
        this.idExterno = idExterno;
    }

    public Integer getIdExtraccionCuenta() {
        return idExtraccionCuenta;
    }

    public void setIdExtraccionCuenta(Integer idExtraccionCuenta) {
        this.idExtraccionCuenta = idExtraccionCuenta;
    }

    public String getNombreExtraccCta() {
        return nombreExtraccCta;
    }

    public void setNombreExtraccCta(String nombreExtraccCta) {
        this.nombreExtraccCta = nombreExtraccCta;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(int idExterno) {
        this.idExterno = idExterno;
    }

    public Cuenta getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(Cuenta cuentaFk) {
        this.cuentaFk = cuentaFk;
    }

    public TipoExtraccion getTipoExtraccion() {
        return tipoExtraccion;
    }

    public void setTipoExtraccion(TipoExtraccion tipoExtraccion) {
        this.tipoExtraccion = tipoExtraccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExtraccionCuenta != null ? idExtraccionCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExtraccionCuenta)) {
            return false;
        }
        ExtraccionCuenta other = (ExtraccionCuenta) object;
        if ((this.idExtraccionCuenta == null && other.idExtraccionCuenta != null) || (this.idExtraccionCuenta != null && !this.idExtraccionCuenta.equals(other.idExtraccionCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.ExtraccionCuenta[ idExtraccionCuenta=" + idExtraccionCuenta + " ]";
    }
    
}
