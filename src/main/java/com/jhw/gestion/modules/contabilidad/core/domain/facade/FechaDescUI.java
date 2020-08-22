/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain.facade;

import com.clean.core.domain.VolatileDomainObject;
import com.jhw.gestion.modules.contabilidad.core.domain.FormaPagoDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.InfoOperacionContableDomain;
import java.util.Date;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class FechaDescUI extends VolatileDomainObject {

    private Date fecha;
    private FormaPagoDomain pago;
    private String descripcion;

    public FechaDescUI() {
    }

    public FechaDescUI(Date fecha, FormaPagoDomain pago, String descripcion) {
        this.fecha = fecha;
        this.pago = pago;
        this.descripcion = descripcion;
    }

    public FechaDescUI(InfoOperacionContableDomain info) {
        this.fecha = info.getFecha();
        this.pago = info.getFormaPagoFk();
        this.descripcion = info.getDescripcion();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public FormaPagoDomain getPago() {
        return pago;
    }

    public void setPago(FormaPagoDomain pago) {
        this.pago = pago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
