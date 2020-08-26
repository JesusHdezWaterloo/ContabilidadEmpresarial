/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.repo.entities;

import com.jhw.gestion.modules.contabilidad.repo.utils.ResourcesContabilidad;
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
@Table(name = "tipo_cuenta", schema = ResourcesContabilidad.SCHEMA,
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"nombre_tipo_cuenta"})})
@NamedQueries({
    @NamedQuery(name = "TipoCuenta.findAll", query = "SELECT t FROM TipoCuenta t"),
    @NamedQuery(name = "TipoCuenta.findByIdTipoCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.idTipoCuenta = :idTipoCuenta"),
    @NamedQuery(name = "TipoCuenta.findByNombreTipoCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.nombreTipoCuenta = :nombreTipoCuenta"),
    @NamedQuery(name = "TipoCuenta.findByDebitoCredito", query = "SELECT t FROM TipoCuenta t WHERE t.debitoCredito = :debitoCredito"),
    @NamedQuery(name = "TipoCuenta.findByLiquidable", query = "SELECT t FROM TipoCuenta t WHERE t.liquidable = :liquidable"),
    @NamedQuery(name = "TipoCuenta.findByDescripcion", query = "SELECT t FROM TipoCuenta t WHERE t.descripcion = :descripcion")})
public class TipoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_cuenta", nullable = false)
    private Integer idTipoCuenta;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_tipo_cuenta", nullable = false, length = 100)
    private String nombreTipoCuenta;

    @Basic(optional = false)
    @NotNull
    @Column(name = "debito_credito", nullable = false)
    private boolean debitoCredito;

    @Basic(optional = false)
    @NotNull
    @Column(name = "liquidable", nullable = false)
    private boolean liquidable;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public TipoCuenta() {
    }

    public TipoCuenta(Integer idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public TipoCuenta(Integer idTipoCuenta, String nombreTipoCuenta, boolean debitoCredito, boolean liquidable, String descripcion) {
        this.idTipoCuenta = idTipoCuenta;
        this.nombreTipoCuenta = nombreTipoCuenta;
        this.debitoCredito = debitoCredito;
        this.liquidable = liquidable;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(Integer idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getNombreTipoCuenta() {
        return nombreTipoCuenta;
    }

    public void setNombreTipoCuenta(String nombreTipoCuenta) {
        this.nombreTipoCuenta = nombreTipoCuenta;
    }

    public boolean getDebitoCredito() {
        return debitoCredito;
    }

    public void setDebitoCredito(boolean debitoCredito) {
        this.debitoCredito = debitoCredito;
    }

    public boolean getLiquidable() {
        return liquidable;
    }

    public void setLiquidable(boolean liquidable) {
        this.liquidable = liquidable;
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
        hash += (idTipoCuenta != null ? idTipoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuenta)) {
            return false;
        }
        TipoCuenta other = (TipoCuenta) object;
        if ((this.idTipoCuenta == null && other.idTipoCuenta != null) || (this.idTipoCuenta != null && !this.idTipoCuenta.equals(other.idTipoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.contabilidad_empresarial.TipoCuenta[ idTipoCuenta=" + idTipoCuenta + " ]";
    }

}
