/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"codigo", "nombreCuenta"})
public class CuentaContableDomain extends EntityDomainObjectValidated implements Cuenta, DebitoCredito {

    private Integer idCuentaContable;

    @NotEmpty(message = "#msg.module.contabilidad.validation.cuenta_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.cuenta_nombre_largo#")
    private String nombreCuenta;

    @Size(max = 5, message = "#msg.module.contabilidad.validation.cuenta_codigo_tamanno_incorrecto#")
    private String codigo;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.debito_negativo#")
    @Max(value = Long.MAX_VALUE, message = "#msg.module.contabilidad.validation.valor_muy_grande#")
    private BigDecimal debito;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.credito_negativo#")
    @Max(value = Long.MAX_VALUE, message = "#msg.module.contabilidad.validation.valor_muy_grande#")
    private BigDecimal credito;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.cuenta_moneda_null#")
    private MonedaDomain monedaFk;

    @NotNull(message = "#msg.module.contabilidad.validation.cuenta_contable_tipo_cuenta_null#")
    private TipoCuentaDomain tipoCuentaFk;

    @NotNull(message = "#msg.module.contabilidad.validation.cuenta_contable_titular_null#")
    private TitularDomain titularFk;

    public CuentaContableDomain() {
    }

    public CuentaContableDomain(Integer idCuentaContable) {
        this.idCuentaContable = idCuentaContable;
    }

    public CuentaContableDomain(String nombreCuenta, String codigo, BigDecimal debito, BigDecimal credito, String descripcion, MonedaDomain monedaFk, TipoCuentaDomain tipoCuentaFk, TitularDomain titularFk) {
        this.nombreCuenta = nombreCuenta;
        this.codigo = codigo;
        this.debito = debito;
        this.credito = credito;
        this.descripcion = descripcion;
        this.monedaFk = monedaFk;
        this.tipoCuentaFk = tipoCuentaFk;
        this.titularFk = titularFk;
    }

    public TitularDomain getTitularFk() {
        return titularFk;
    }

    public void setTitularFk(TitularDomain titularFk) {
        this.titularFk = titularFk;
    }

    public Integer getIdCuentaContable() {
        return idCuentaContable;
    }

    public void setIdCuentaContable(Integer idCuentaContable) {
        this.idCuentaContable = idCuentaContable;
    }

    @Override
    public Integer ggetIdCuenta() {
        return getIdCuentaContable();
    }

    @Override
    public void ssetIdCuenta(Integer idCuenta) {
        setIdCuentaContable(idCuenta);
    }

    @Override
    public String getNombreCuenta() {
        return nombreCuenta;
    }

    @Override
    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
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
    public BigDecimal getDebito() {
        return debito;
    }

    @Override
    public void setDebito(BigDecimal debito) {
        this.debito = debito;
    }

    @Override
    public BigDecimal getCredito() {
        return credito;
    }

    @Override
    public void setCredito(BigDecimal credito) {
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

    public TipoCuentaDomain getTipoCuentaFk() {
        return tipoCuentaFk;
    }

    public void setTipoCuentaFk(TipoCuentaDomain tipoCuentaFk) {
        this.tipoCuentaFk = tipoCuentaFk;
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
        return codigo + " - " + nombreCuenta;
    }

}
