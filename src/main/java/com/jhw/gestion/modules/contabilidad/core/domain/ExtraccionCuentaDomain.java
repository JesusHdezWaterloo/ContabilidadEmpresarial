package com.jhw.gestion.modules.contabilidad.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import com.jhw.utils.others.StringFormating;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class ExtraccionCuentaDomain extends EntityDomainObjectValidated {

    private Integer idExtraccionCuenta;

    @NotEmpty(message = "#msg.module.contabilidad.validation.extraccion_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.extraccion_nombre_largo#")
    private String nombreExtraccCta;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.extraccion_valor_negativo#")
    private float valor;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    private int idExterno;

    @NotNull(message = "#msg.module.contabilidad.validation.extraccion_cuenta_null#")
    private CuentaDomain cuentaFk;

    @NotNull(message = "#msg.module.contabilidad.validation.extraccion_tipo_null#")
    private TipoExtraccionDomain tipoExtraccion;

    public ExtraccionCuentaDomain() {
    }

    public ExtraccionCuentaDomain(Integer idExtraccionCuenta) {
        this.idExtraccionCuenta = idExtraccionCuenta;
    }

    public ExtraccionCuentaDomain(String nombreExtraccCta, float valor, String descripcion, TipoExtraccionDomain tipoExtraccion, int idExterno, CuentaDomain cuentaFk) {
        this.nombreExtraccCta = nombreExtraccCta;
        this.valor = valor;
        this.descripcion = descripcion;
        this.tipoExtraccion = tipoExtraccion;
        this.idExterno = idExterno;
        this.cuentaFk = cuentaFk;
        validate();
    }

    public Integer getIdExtraccionCuenta() {
        return idExtraccionCuenta;
    }

    public void setIdExtraccionCuenta(Integer idExtraccionCuenta) {
        this.idExtraccionCuenta = idExtraccionCuenta;
    }

    public String getNombreExtraccCta() {
        return nombreExtraccCta;
    }

    public void setNombreExtraccCta(String nombreExtraccCta) {
        this.nombreExtraccCta = nombreExtraccCta;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(int idExterno) {
        this.idExterno = idExterno;
    }

    public CuentaDomain getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(CuentaDomain cuentaFk) {
        this.cuentaFk = cuentaFk;
    }

    public TipoExtraccionDomain getTipoExtraccion() {
        return tipoExtraccion;
    }

    public void setTipoExtraccion(TipoExtraccionDomain tipoExtraccion) {
        this.tipoExtraccion = tipoExtraccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExtraccionCuenta != null ? idExtraccionCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExtraccionCuentaDomain)) {
            return false;
        }
        ExtraccionCuentaDomain other = (ExtraccionCuentaDomain) object;
        if ((this.idExtraccionCuenta == null && other.idExtraccionCuenta != null) || (this.idExtraccionCuenta != null && !this.idExtraccionCuenta.equals(other.idExtraccionCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Extracción por valor de :" + StringFormating.formatToMoney(valor) + " de la cuenta " + cuentaFk;
    }

}
