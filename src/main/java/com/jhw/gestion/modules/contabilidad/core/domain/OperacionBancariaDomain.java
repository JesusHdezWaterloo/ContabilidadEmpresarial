/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import com.clean.core.utils.SortBy;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"documento", "nombre"})
public class OperacionBancariaDomain extends EntityDomainObjectValidated implements Operacion {

    private Integer idOperacionBancaria;

    @NotEmpty(message = "#msg.module.contabilidad.validation.operacion_documento_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.operacion_documento_largo#")
    private String documento;

    @NotEmpty(message = "#msg.module.contabilidad.validation.operacion_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.operacion_nombre_largo#")
    private String nombre;

    private double debito;

    private double credito;

    @NotNull(message = "#msg.module.contabilidad.validation.operacion_fecha_null#")
    private Date fecha;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.operacion_cuenta_null#")
    private CuentaBancariaDomain cuentaFk;

    @NotNull(message = "#msg.module.contabilidad.validation.operacion_bancaria_operacion_contable_null#")
    private OperacionContableDomain operacionContableFk;

    public OperacionBancariaDomain() {
    }

    public OperacionBancariaDomain(Integer idOperacionBancaria) {
        this.idOperacionBancaria = idOperacionBancaria;
    }

    public OperacionBancariaDomain(String documento, String nombre, double debito, double credito, Date fecha, String descripcion, CuentaBancariaDomain cuentaFk, OperacionContableDomain operacionContableFk) {
        this.documento = documento;
        this.nombre = nombre;
        this.debito = debito;
        this.credito = credito;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cuentaFk = cuentaFk;
        this.operacionContableFk = operacionContableFk;
    }

    public Integer getIdOperacionBancaria() {
        return idOperacionBancaria;
    }

    public void setIdOperacionBancaria(Integer idOperacionBancaria) {
        this.idOperacionBancaria = idOperacionBancaria;
    }

    @Override
    public Integer getIdOperacion() {
        return getIdOperacionBancaria();
    }

    @Override
    public void setIdOperacion(Integer idOperacion) {
        setIdOperacionBancaria(idOperacion);
    }

    @Override
    public String getDocumento() {
        return documento;
    }

    @Override
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public Date getFecha() {
        return fecha;
    }

    @Override
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public CuentaBancariaDomain getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(CuentaBancariaDomain cuentaFk) {
        this.cuentaFk = cuentaFk;
    }

    public OperacionContableDomain getOperacionContableFk() {
        return operacionContableFk;
    }

    public void setOperacionContableFk(OperacionContableDomain operacionContableFk) {
        this.operacionContableFk = operacionContableFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacionBancaria != null ? idOperacionBancaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperacionBancariaDomain)) {
            return false;
        }
        OperacionBancariaDomain other = (OperacionBancariaDomain) object;
        if ((this.idOperacionBancaria == null && other.idOperacionBancaria != null) || (this.idOperacionBancaria != null && !this.idOperacionBancaria.equals(other.idOperacionBancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return documento;
    }

}
