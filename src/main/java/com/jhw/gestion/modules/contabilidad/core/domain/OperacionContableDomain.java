/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class OperacionContableDomain extends EntityDomainObjectValidated implements DebitoCredito {

    private Integer idOperacionContable;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.debito_negativo#")
    @Max(value = Long.MAX_VALUE, message = "#msg.module.contabilidad.validation.valor_muy_grande#")
    private BigDecimal debito;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.credito_negativo#")
    @Max(value = Long.MAX_VALUE, message = "#msg.module.contabilidad.validation.valor_muy_grande#")
    private BigDecimal credito;

    @NotNull(message = "#msg.module.contabilidad.validation.operacion_cuenta_null#")
    private CuentaContableDomain cuentaFk;

    @NotNull(message = "#msg.module.contabilidad.validation.operacion_info_null#")
    private InfoOperacionContableDomain infoOperacionContableFk;

    public OperacionContableDomain() {
    }

    public OperacionContableDomain(Integer idOperacionContable) {
        this.idOperacionContable = idOperacionContable;
    }

    public OperacionContableDomain(BigDecimal debito, BigDecimal credito, CuentaContableDomain cuentaFk, InfoOperacionContableDomain infoOperacionContableFk) {
        this.debito = debito;
        this.credito = credito;
        this.cuentaFk = cuentaFk;
        this.infoOperacionContableFk = infoOperacionContableFk;
    }

    public Integer getIdOperacionContable() {
        return idOperacionContable;
    }

    public void setIdOperacionContable(Integer idOperacionContable) {
        this.idOperacionContable = idOperacionContable;
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

    public CuentaContableDomain getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(CuentaContableDomain cuentaFk) {
        this.cuentaFk = cuentaFk;
    }

    public InfoOperacionContableDomain getInfoOperacionContableFk() {
        return infoOperacionContableFk;
    }

    public void setInfoOperacionContableFk(InfoOperacionContableDomain infoOperacionContableFk) {
        this.infoOperacionContableFk = infoOperacionContableFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacionContable != null ? idOperacionContable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperacionContableDomain)) {
            return false;
        }
        OperacionContableDomain other = (OperacionContableDomain) object;
        if ((this.idOperacionContable == null && other.idOperacionContable != null) || (this.idOperacionContable != null && !this.idOperacionContable.equals(other.idOperacionContable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return infoOperacionContableFk.getDocumento();
    }

}
