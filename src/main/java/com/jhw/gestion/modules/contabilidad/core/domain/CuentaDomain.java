package com.jhw.gestion.modules.contabilidad.core.domain;

import com.clean.core.exceptions.ValidationException;
import com.clean.core.utils.SortBy;
import com.clean.core.utils.validation.ValidationMessage;
import com.clean.core.utils.validation.ValidationResult;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"cuentaBase"}, order = SortBy.DESCENDING)
@SortBy(priority = {"nombreCuenta"})
public class CuentaDomain extends EntityDomainObjectValidated {

    private Integer idCuenta;

    @NotEmpty(message = "#msg.module.contabilidad.validation.cuenta_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.cuenta_nombre_largo#")
    private String nombreCuenta;

    @Max(value = 100, message = "#msg.module.contabilidad.validation.porciento_mayor_que_100#")
    @PositiveOrZero(message = "#msg.module.contabilidad.validation.porciento_negativo#")
    private float porciento;

    private double totalDepositos;

    private double totalExtracciones;

    @Size(min = 16, max = 16, message = "#msg.module.contabilidad.validation.cuenta_numero_tamanno_incorrecto#")
    private String numeroCuenta;

    @Size(min = 4, max = 4, message = "#msg.module.contabilidad.validation.cuenta_pin_tamanno_incorrecto#")
    private String pin;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    private boolean cuentaBase;

    @NotNull(message = "#msg.module.contabilidad.validation.cuenta_moneda_null#")
    private MonedaDomain monedaFk;

    public CuentaDomain() {
    }

    public CuentaDomain(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public CuentaDomain(String nombreCuenta, float porciento, double totalDepositos, double totalExtracciones, String numeroCuenta, String pin, String descripcion, boolean cuentaBase, MonedaDomain monedaFk) {
        this.nombreCuenta = nombreCuenta;
        this.porciento = porciento;
        this.totalDepositos = totalDepositos;
        this.totalExtracciones = totalExtracciones;
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.descripcion = descripcion;
        this.cuentaBase = cuentaBase;
        this.monedaFk = monedaFk;
        validate();
    }

    public double saldo() {
        return totalDepositos - totalExtracciones;
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult result = super.validate();

        if (cuentaBase && porciento != 100) {
            result.add(ValidationMessage.from("porciento", porciento, "#msg.module.contabilidad.validation.cuenta_base_porciento_100#"));
        }

        return result.throwException();
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

    public MonedaDomain getMonedaFk() {
        return monedaFk;
    }

    public void setMonedaFk(MonedaDomain monedaFk) {
        this.monedaFk = monedaFk;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuenta != null ? idCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuentaDomain)) {
            return false;
        }
        CuentaDomain other = (CuentaDomain) object;
        if ((this.idCuenta == null && other.idCuenta != null) || (this.idCuenta != null && !this.idCuenta.equals(other.idCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreCuenta;
    }

}
