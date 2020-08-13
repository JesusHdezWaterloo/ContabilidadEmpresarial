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
@Table(name = "cuenta_bancaria", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"codigo"}),
    @UniqueConstraint(columnNames = {"numero_cuenta"}),
    @UniqueConstraint(columnNames = {"nombre_cuenta"})})
@NamedQueries({
    @NamedQuery(name = "CuentaBancaria.findAll", query = "SELECT c FROM CuentaBancaria c"),
    @NamedQuery(name = "CuentaBancaria.findByIdCuentaBancaria", query = "SELECT c FROM CuentaBancaria c WHERE c.idCuentaBancaria = :idCuentaBancaria"),
    @NamedQuery(name = "CuentaBancaria.findByNombreCuenta", query = "SELECT c FROM CuentaBancaria c WHERE c.nombreCuenta = :nombreCuenta"),
    @NamedQuery(name = "CuentaBancaria.findByNumeroCuenta", query = "SELECT c FROM CuentaBancaria c WHERE c.numeroCuenta = :numeroCuenta"),
    @NamedQuery(name = "CuentaBancaria.findByPin", query = "SELECT c FROM CuentaBancaria c WHERE c.pin = :pin"),
    @NamedQuery(name = "CuentaBancaria.findByCodigo", query = "SELECT c FROM CuentaBancaria c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CuentaBancaria.findByDebito", query = "SELECT c FROM CuentaBancaria c WHERE c.debito = :debito"),
    @NamedQuery(name = "CuentaBancaria.findByCredito", query = "SELECT c FROM CuentaBancaria c WHERE c.credito = :credito"),
    @NamedQuery(name = "CuentaBancaria.findByDescripcion", query = "SELECT c FROM CuentaBancaria c WHERE c.descripcion = :descripcion")})
public class CuentaBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta_bancaria", nullable = false)
    private Integer idCuentaBancaria;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_cuenta", nullable = false, length = 100)
    private String nombreCuenta;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "numero_cuenta", nullable = false, length = 16)
    private String numeroCuenta;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 4)
    @Column(name = "pin", nullable = false, length = 4)
    private String pin;
    
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
    
    @JoinColumn(name = "moneda_fk", referencedColumnName = "id_moneda", nullable = false)
    @ManyToOne(optional = false)
    private Moneda monedaFk;

    public CuentaBancaria() {
    }

    public CuentaBancaria(Integer idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public CuentaBancaria(Integer idCuentaBancaria, String nombreCuenta, String numeroCuenta, String pin, String codigo, double debito, double credito, String descripcion) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.nombreCuenta = nombreCuenta;
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.codigo = codigo;
        this.debito = debito;
        this.credito = credito;
        this.descripcion = descripcion;
    }

    public Integer getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(Integer idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
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

    public Moneda getMonedaFk() {
        return monedaFk;
    }

    public void setMonedaFk(Moneda monedaFk) {
        this.monedaFk = monedaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuentaBancaria != null ? idCuentaBancaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaBancaria)) {
            return false;
        }
        CuentaBancaria other = (CuentaBancaria) object;
        if ((this.idCuentaBancaria == null && other.idCuentaBancaria != null) || (this.idCuentaBancaria != null && !this.idCuentaBancaria.equals(other.idCuentaBancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhw.gestion.modules.contabilidad.repo.entities.CuentaBancaria[ idCuentaBancaria=" + idCuentaBancaria + " ]";
    }
    
}
