/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"codigo", "nombreCuenta"})
public class CuentaBancariaDomain extends EntityDomainObjectValidated implements Cuenta, DebitoCredito {

    private Integer idCuentaBancaria;

    @NotEmpty(message = "#msg.module.contabilidad.validation.cuenta_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.cuenta_nombre_largo#")
    private String nombreCuenta;

    @Size(min = 16, max = 16, message = "#msg.module.contabilidad.validation.cuenta_bancaria_numero_tamanno_incorrecto#")
    private String numeroCuenta;

    @Size(max = 16, message = "#msg.module.contabilidad.validation.cuenta_bancaria_tarjeta_tamanno_incorrecto#")
    private String numeroTarjeta;

    @Size(max = 4, message = "#msg.module.contabilidad.validation.cuenta_bancaria_pin_tamanno_incorrecto#")
    private String pin;

    @Size(max = 5, message = "#msg.module.contabilidad.validation.cuenta_codigo_tamanno_incorrecto#")
    private String codigo;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.debito_negativo#")
    private double debito;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.credito_negativo#")
    private double credito;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.cuenta_moneda_null#")
    private MonedaDomain monedaFk;

    public CuentaBancariaDomain() {
    }

    public CuentaBancariaDomain(Integer idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public CuentaBancariaDomain(String nombreCuenta, String numeroCuenta, String numeroTarjeta, String pin, String codigo, double debito, double credito, String descripcion, MonedaDomain monedaFk) {
        this.nombreCuenta = nombreCuenta;
        this.numeroCuenta = numeroCuenta;
        this.numeroTarjeta = numeroTarjeta;
        this.pin = pin;
        this.codigo = codigo;
        this.debito = debito;
        this.credito = credito;
        this.descripcion = descripcion;
        this.monedaFk = monedaFk;
        validate();
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Integer getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(Integer idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    @Override
    public Integer ggetIdCuenta() {
        return getIdCuentaBancaria();
    }

    @Override
    public void ssetIdCuenta(Integer idCuenta) {
        setIdCuentaBancaria(idCuenta);
    }

    @Override
    public String getNombreCuenta() {
        return nombreCuenta;
    }

    @Override
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

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public double getDebito() {
        return debito;
    }

    @Override
    public void setDebito(double debito) {
        this.debito = debito;
    }

    @Override
    public double getCredito() {
        return credito;
    }

    @Override
    public void setCredito(double credito) {
        this.credito = credito;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public MonedaDomain getMonedaFk() {
        return monedaFk;
    }

    @Override
    public void setMonedaFk(MonedaDomain monedaFk) {
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
        if (!(object instanceof CuentaBancariaDomain)) {
            return false;
        }
        CuentaBancariaDomain other = (CuentaBancariaDomain) object;
        if ((this.idCuentaBancaria == null && other.idCuentaBancaria != null) || (this.idCuentaBancaria != null && !this.idCuentaBancaria.equals(other.idCuentaBancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombreCuenta;
    }

}
