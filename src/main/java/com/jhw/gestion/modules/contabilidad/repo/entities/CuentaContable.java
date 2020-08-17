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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "cuenta_contable", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codigo"}),
    @UniqueConstraint(columnNames = {"nombre_cuenta"})})
@NamedQueries({
    @NamedQuery(name = "CuentaContable.findAll", query = "SELECT c FROM CuentaContable c"),
    @NamedQuery(name = "CuentaContable.findByIdCuentaContable", query = "SELECT c FROM CuentaContable c WHERE c.idCuentaContable = :idCuentaContable"),
    @NamedQuery(name = "CuentaContable.findByNombreCuenta", query = "SELECT c FROM CuentaContable c WHERE c.nombreCuenta = :nombreCuenta"),
    @NamedQuery(name = "CuentaContable.findByCodigo", query = "SELECT c FROM CuentaContable c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CuentaContable.findByDebito", query = "SELECT c FROM CuentaContable c WHERE c.debito = :debito"),
    @NamedQuery(name = "CuentaContable.findByCredito", query = "SELECT c FROM CuentaContable c WHERE c.credito = :credito"),
    @NamedQuery(name = "CuentaContable.findByDescripcion", query = "SELECT c FROM CuentaContable c WHERE c.descripcion = :descripcion")})
public class CuentaContable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta_contable", nullable = false)
    private Integer idCuentaContable;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_cuenta", nullable = false, length = 100)
    private String nombreCuenta;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo", nullable = false, length = 5)
    private String codigo;

    @Basic(optional = false)
    @NotNull
    @Column(name = "debito", nullable = false)
    private double debito;

    @Basic(optional = false)
    @NotNull
    @Column(name = "credito", nullable = false)
    private double credito;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @JoinColumn(name = "tipo_cuenta_fk", referencedColumnName = "id_tipo_cuenta", nullable = false)
    @ManyToOne(optional = false)
    private TipoCuenta tipoCuentaFk;

    @JoinColumn(name = "moneda_fk", referencedColumnName = "id_moneda", nullable = false)
    @ManyToOne(optional = false)
    private Moneda monedaFk;

    public CuentaContable() {
    }

    public CuentaContable(Integer idCuentaContable) {
        this.idCuentaContable = idCuentaContable;
    }

    public CuentaContable(Integer idCuentaContable, String nombreCuenta, String codigo, double debito, double credito, String descripcion) {
        this.idCuentaContable = idCuentaContable;
        this.nombreCuenta = nombreCuenta;
        this.codigo = codigo;
        this.debito = debito;
        this.credito = credito;
        this.descripcion = descripcion;
    }

    public Integer getIdCuentaContable() {
        return idCuentaContable;
    }

    public void setIdCuentaContable(Integer idCuentaContable) {
        this.idCuentaContable = idCuentaContable;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoCuenta getTipoCuentaFk() {
        return tipoCuentaFk;
    }

    public void setTipoCuentaFk(TipoCuenta tipoCuentaFk) {
        this.tipoCuentaFk = tipoCuentaFk;
    }

    public Moneda getMonedaFk() {
        return monedaFk;
    }

    public void setMonedaFk(Moneda monedaFk) {
        this.monedaFk = monedaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaContable != null ? idCuentaContable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaContable)) {
            return false;
        }
        CuentaContable other = (CuentaContable) object;
        if ((this.idCuentaContable == null && other.idCuentaContable != null) || (this.idCuentaContable != null && !this.idCuentaContable.equals(other.idCuentaContable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.contabilidad_empresarial.CuentaContable[ idCuentaContable=" + idCuentaContable + " ]";
    }

}
