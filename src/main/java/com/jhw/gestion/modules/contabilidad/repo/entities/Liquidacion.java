/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.repo.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "liquidacion")
@NamedQueries({
    @NamedQuery(name = "Liquidacion.findAll", query = "SELECT l FROM Liquidacion l"),
    @NamedQuery(name = "Liquidacion.findByIdLiquidacion", query = "SELECT l FROM Liquidacion l WHERE l.idLiquidacion = :idLiquidacion"),
    @NamedQuery(name = "Liquidacion.findByDocumento", query = "SELECT l FROM Liquidacion l WHERE l.documento = :documento"),
    @NamedQuery(name = "Liquidacion.findByNombre", query = "SELECT l FROM Liquidacion l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "Liquidacion.findByDebito", query = "SELECT l FROM Liquidacion l WHERE l.debito = :debito"),
    @NamedQuery(name = "Liquidacion.findByCredito", query = "SELECT l FROM Liquidacion l WHERE l.credito = :credito"),
    @NamedQuery(name = "Liquidacion.findByFecha", query = "SELECT l FROM Liquidacion l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "Liquidacion.findByDescripcion", query = "SELECT l FROM Liquidacion l WHERE l.descripcion = :descripcion")})
public class Liquidacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_liquidacion", nullable = false)
    private Integer idLiquidacion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "documento", nullable = false, length = 100)
    private String documento;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Column(name = "debito", nullable = false, precision = 19, scale = 4)
    @PositiveOrZero
    @Max(value = Long.MAX_VALUE)
    private BigDecimal debito;

    @Basic(optional = false)
    @NotNull
    @Column(name = "credito", nullable = false, precision = 19, scale = 4)
    @PositiveOrZero
    @Max(value = Long.MAX_VALUE)
    private BigDecimal credito;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @JoinColumn(name = "cuenta_fk", referencedColumnName = "id_cuenta_bancaria", nullable = false)
    @ManyToOne(optional = false)
    private CuentaBancaria cuentaFk;

    @JoinColumn(name = "cuadre_fk", referencedColumnName = "id_cuadre", nullable = false)
    @ManyToOne(optional = false)
    private Cuadre cuadreFk;

    public Liquidacion() {
    }

    public Liquidacion(Integer idOperacionBancaria) {
        this.idLiquidacion = idOperacionBancaria;
    }

    public Liquidacion(Integer idOperacionBancaria, String documento, String nombre, BigDecimal debito, BigDecimal credito, Date fecha, String descripcion) {
        this.idLiquidacion = idOperacionBancaria;
        this.documento = documento;
        this.nombre = nombre;
        this.debito = debito;
        this.credito = credito;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Integer getIdLiquidacion() {
        return idLiquidacion;
    }

    public void setIdLiquidacion(Integer idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getDebito() {
        return debito;
    }

    public void setDebito(BigDecimal debito) {
        this.debito = debito;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cuadre getCuadreFk() {
        return cuadreFk;
    }

    public void setCuadreFk(Cuadre cuadreFk) {
        this.cuadreFk = cuadreFk;
    }

    public CuentaBancaria getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(CuentaBancaria cuentaFk) {
        this.cuentaFk = cuentaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLiquidacion != null ? idLiquidacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Liquidacion)) {
            return false;
        }
        Liquidacion other = (Liquidacion) object;
        if ((this.idLiquidacion == null && other.idLiquidacion != null) || (this.idLiquidacion != null && !this.idLiquidacion.equals(other.idLiquidacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.contabilidad_empresarial.Liquidacion[ idOperacionBancaria=" + idLiquidacion + " ]";
    }

}
