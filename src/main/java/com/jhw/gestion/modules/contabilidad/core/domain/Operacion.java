/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import java.util.Date;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface Operacion {
    
    public Integer getIdOperacion();

    public void setIdOperacion(Integer idOperacion);

    public String getDocumento();

    public void setDocumento(String documento);

    public String getNombre();

    public void setNombre(String nombre);

    public double getDebito();

    public void setDebito(double debito);

    public double getCredito();

    public void setCredito(double credito);

    public String getDescripcion();

    public void setDescripcion(String descripcion);

    public Date getFecha();

    public void setFecha(Date fecha);

}
