package com.jhw.gestion.modules.contabilidad.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class SubcuentaDomain extends EntityDomainObjectValidated {

    private Integer idSubcuenta;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.subcuenta_hijo_null#")
    private CuentaDomain cuentaHijoFk;

    @NotNull(message = "#msg.module.contabilidad.validation.subcuenta_padre_null#")
    private CuentaDomain cuentaPadreFk;

    public SubcuentaDomain() {
    }

    public SubcuentaDomain(Integer idSubcuenta) {
        this.idSubcuenta = idSubcuenta;
    }

    public SubcuentaDomain(String descripcion, CuentaDomain cuentaHijoFk, CuentaDomain cuentaPadreFk) {
        this.descripcion = descripcion;
        this.cuentaHijoFk = cuentaHijoFk;
        this.cuentaPadreFk = cuentaPadreFk;
        validate();
    }

    public Integer getIdSubcuenta() {
        return idSubcuenta;
    }

    public void setIdSubcuenta(Integer idSubcuenta) {
        this.idSubcuenta = idSubcuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CuentaDomain getCuentaHijoFk() {
        return cuentaHijoFk;
    }

    public void setCuentaHijoFk(CuentaDomain cuentaHijoFk) {
        this.cuentaHijoFk = cuentaHijoFk;
    }

    public CuentaDomain getCuentaPadreFk() {
        return cuentaPadreFk;
    }

    public void setCuentaPadreFk(CuentaDomain cuentaPadreFk) {
        this.cuentaPadreFk = cuentaPadreFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubcuenta != null ? idSubcuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubcuentaDomain)) {
            return false;
        }
        SubcuentaDomain other = (SubcuentaDomain) object;
        if ((this.idSubcuenta == null && other.idSubcuenta != null) || (this.idSubcuenta != null && !this.idSubcuenta.equals(other.idSubcuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Padre: " + cuentaPadreFk + " - Hijo: " + cuentaHijoFk;
    }

}
