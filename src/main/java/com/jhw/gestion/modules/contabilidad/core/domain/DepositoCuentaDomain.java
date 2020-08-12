package com.jhw.gestion.modules.contabilidad.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import com.jhw.utils.others.StringFormating;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class DepositoCuentaDomain extends EntityDomainObjectValidated {

    private Integer idDepositoCuenta;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.deposito_valor_negativo#")
    private float valor;

    @Max(value = 100, message = "#msg.module.contabilidad.validation.porciento_mayor_que_100#")
    @PositiveOrZero(message = "#msg.module.contabilidad.validation.porciento_negativo#")
    private float porciento;

    @NotNull(message = "#msg.module.contabilidad.validation.deposito_cuenta_null#")
    private CuentaDomain cuentaFk;

    @NotNull(message = "#msg.module.contabilidad.validation.deposito_tipo_deposito_null#")
    private TipoDepositoDomain tipoDepositoFk;

    private int idExterno;

    public DepositoCuentaDomain() {
    }

    public DepositoCuentaDomain(Integer idDepositoCuenta) {
        this.idDepositoCuenta = idDepositoCuenta;
    }

    public DepositoCuentaDomain(float valor, float porciento, CuentaDomain cuentaFk, TipoDepositoDomain tipoDepositoFk, int idExterno) {
        this.valor = valor;
        this.porciento = porciento;
        this.cuentaFk = cuentaFk;
        this.tipoDepositoFk = tipoDepositoFk;
        this.idExterno = idExterno;
        validate();
    }

    public TipoDepositoDomain getTipoDepositoFk() {
        return tipoDepositoFk;
    }

    public void setTipoDepositoFk(TipoDepositoDomain tipoDepositoFk) {
        this.tipoDepositoFk = tipoDepositoFk;
    }

    public int getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(int idExterno) {
        this.idExterno = idExterno;
    }

    public Integer getIdDepositoCuenta() {
        return idDepositoCuenta;
    }

    public void setIdDepositoCuenta(Integer idDepositoCuenta) {
        this.idDepositoCuenta = idDepositoCuenta;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getPorciento() {
        return porciento;
    }

    public void setPorciento(float porciento) {
        this.porciento = porciento;
    }

    public CuentaDomain getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(CuentaDomain cuentaFk) {
        this.cuentaFk = cuentaFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepositoCuenta != null ? idDepositoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepositoCuentaDomain)) {
            return false;
        }
        DepositoCuentaDomain other = (DepositoCuentaDomain) object;
        if ((this.idDepositoCuenta == null && other.idDepositoCuenta != null) || (this.idDepositoCuenta != null && !this.idDepositoCuenta.equals(other.idDepositoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Depósito por valor de :" + StringFormating.formatToMoney(valor) + " en la cuenta " + cuentaFk;
    }

}
