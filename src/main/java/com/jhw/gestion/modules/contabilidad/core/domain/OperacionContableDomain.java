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
public class OperacionContableDomain extends EntityDomainObjectValidated implements Operacion {

    private Integer idOperacionContable;

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
    private CuentaContableDomain cuentaFk;

    @NotNull(message = "#msg.module.contabilidad.validation.operacion_contable_tipo_op_null#")
    private TipoOperacionContableDomain tipoOperacionContableFk;

    @NotNull(message = "#msg.module.contabilidad.validation.operacion_contable_id_externo_null#")
    private int idExterno;

    public OperacionContableDomain() {
    }

    public OperacionContableDomain(Integer idOperacionContable) {
        this.idOperacionContable = idOperacionContable;
    }

    public OperacionContableDomain(String documento, String nombre, double debito, double credito, Date fecha, String descripcion, CuentaContableDomain cuentaFk, TipoOperacionContableDomain tipoOperacionContableFk, int idExterno) {
        this.documento = documento;
        this.nombre = nombre;
        this.debito = debito;
        this.credito = credito;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cuentaFk = cuentaFk;
        this.tipoOperacionContableFk = tipoOperacionContableFk;
        this.idExterno = idExterno;
    }

    public Integer getIdOperacionContable() {
        return idOperacionContable;
    }

    public void setIdOperacionContable(Integer idOperacionContable) {
        this.idOperacionContable = idOperacionContable;
    }

    @Override
    public Integer getIdOperacion() {
        return getIdOperacionContable();
    }

    @Override
    public void setIdOperacion(Integer idOperacion) {
        setIdOperacionContable(idOperacion);
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
    public Date getFecha() {
        return fecha;
    }

    @Override
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(int idExterno) {
        this.idExterno = idExterno;
    }

    public CuentaContableDomain getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(CuentaContableDomain cuentaFk) {
        this.cuentaFk = cuentaFk;
    }

    public TipoOperacionContableDomain getTipoOperacionContableFk() {
        return tipoOperacionContableFk;
    }

    public void setTipoOperacionContableFk(TipoOperacionContableDomain tipoOperacionContableFk) {
        this.tipoOperacionContableFk = tipoOperacionContableFk;
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
        return documento;
    }

}
