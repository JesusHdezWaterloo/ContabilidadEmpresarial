/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CuentaContableDomain extends EntityDomainObjectValidated {

    private Integer idCuentaContable;

    @NotEmpty(message = "#msg.module.contabilidad.validation.cuenta_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.cuenta_nombre_largo#")
    private String nombreCuenta;

    @Size(max = 5, message = "#msg.module.contabilidad.validation.cuenta_codigo_tamanno_incorrecto#")
    private String codigo;

    private double debito;

    private double credito;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.cuenta_contable_tipo_cuenta_null#")
    private TipoCuentaDomain tipoCuentaFk;

    @NotNull(message = "#msg.module.contabilidad.validation.cuenta_moneda_null#")
    private MonedaDomain monedaFk;

    public CuentaContableDomain() {
    }

    public CuentaContableDomain(Integer idCuentaContable) {
        this.idCuentaContable = idCuentaContable;
    }

    public CuentaContableDomain(String nombreCuenta, String codigo, double debito, double credito, String descripcion, TipoCuentaDomain tipoCuentaFk, MonedaDomain monedaFk) {
        this.nombreCuenta = nombreCuenta;
        this.codigo = codigo;
        this.debito = debito;
        this.credito = credito;
        this.descripcion = descripcion;
        this.tipoCuentaFk = tipoCuentaFk;
        this.monedaFk = monedaFk;
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

    public TipoCuentaDomain getTipoCuentaFk() {
        return tipoCuentaFk;
    }

    public void setTipoCuentaFk(TipoCuentaDomain tipoCuentaFk) {
        this.tipoCuentaFk = tipoCuentaFk;
    }

    public MonedaDomain getMonedaFk() {
        return monedaFk;
    }

    public void setMonedaFk(MonedaDomain monedaFk) {
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
        if (!(object instanceof CuentaContableDomain)) {
            return false;
        }
        CuentaContableDomain other = (CuentaContableDomain) object;
        if ((this.idCuentaContable == null && other.idCuentaContable != null) || (this.idCuentaContable != null && !this.idCuentaContable.equals(other.idCuentaContable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCuenta + " (" + codigo + ")";
    }

}
