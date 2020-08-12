/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.repo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "cuenta", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"nombre_cuenta"})})
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByIdCuenta", query = "SELECT c FROM Cuenta c WHERE c.idCuenta = :idCuenta"),
    @NamedQuery(name = "Cuenta.findByNombreCuenta", query = "SELECT c FROM Cuenta c WHERE c.nombreCuenta = :nombreCuenta"),
    @NamedQuery(name = "Cuenta.findByPorciento", query = "SELECT c FROM Cuenta c WHERE c.porciento = :porciento"),
    @NamedQuery(name = "Cuenta.findByTotalDepositos", query = "SELECT c FROM Cuenta c WHERE c.totalDepositos = :totalDepositos"),
    @NamedQuery(name = "Cuenta.findByTotalExtracciones", query = "SELECT c FROM Cuenta c WHERE c.totalExtracciones = :totalExtracciones"),
    @NamedQuery(name = "Cuenta.findByNumeroCuenta", query = "SELECT c FROM Cuenta c WHERE c.numeroCuenta = :numeroCuenta"),
    @NamedQuery(name = "Cuenta.findByPin", query = "SELECT c FROM Cuenta c WHERE c.pin = :pin"),
    @NamedQuery(name = "Cuenta.findByDescripcion", query = "SELECT c FROM Cuenta c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Cuenta.findByCuentaBase", query = "SELECT c FROM Cuenta c WHERE c.cuentaBase = :cuentaBase")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuenta", nullable = false)
    private Integer idCuenta;
    @Basic(optional = false)
    @Column(name = "nombre_cuenta", nullable = false, length = 100)
    private String nombreCuenta;
    @Basic(optional = false)
    @Column(name = "porciento", nullable = false)
    private float porciento;
    @Basic(optional = false)
    @Column(name = "total_depositos", nullable = false)
    private double totalDepositos;
    @Basic(optional = false)
    @Column(name = "total_extracciones", nullable = false)
    private double totalExtracciones;
    @Basic(optional = false)
    @Column(name = "numero_cuenta", nullable = false, length = 16)
    private String numeroCuenta;
    @Basic(optional = false)
    @Column(name = "pin", nullable = false, length = 4)
    private String pin;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "cuenta_base", nullable = false)
    private boolean cuentaBase;
    @JoinColumn(name = "moneda_fk", referencedColumnName = "id_moneda", nullable = false)
    @ManyToOne(optional = false)
    private Moneda monedaFk;

    public Cuenta() {
    }

    public Cuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cuenta(Integer idCuenta, String nombreCuenta, float porciento, double totalDepositos, double totalExtracciones, String numeroCuenta, String pin, String descripcion, boolean cuentaBase) {
        this.idCuenta = idCuenta;
        this.nombreCuenta = nombreCuenta;
        this.porciento = porciento;
        this.totalDepositos = totalDepositos;
        this.totalExtracciones = totalExtracciones;
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.descripcion = descripcion;
        this.cuentaBase = cuentaBase;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public float getPorciento() {
        return porciento;
    }

    public void setPorciento(float porciento) {
        this.porciento = porciento;
    }

    public double getTotalDepositos() {
        return totalDepositos;
    }

    public void setTotalDepositos(double totalDepositos) {
        this.totalDepositos = totalDepositos;
    }

    public double getTotalExtracciones() {
        return totalExtracciones;
    }

    public void setTotalExtracciones(double totalExtracciones) {
        this.totalExtracciones = totalExtracciones;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getCuentaBase() {
        return cuentaBase;
    }

    public void setCuentaBase(boolean cuentaBase) {
        this.cuentaBase = cuentaBase;
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
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.Cuenta[ idCuenta=" + idCuenta + " ]";
    }

}
