/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.core.domain.facade;

import com.clean.core.domain.VolatileDomainObject;
import com.jhw.module.gestion.contabilidad.core.domain.InfoOperacionContableDomain;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DocNombreUI extends VolatileDomainObject {

    private String nombre;
    private String documento;

    public DocNombreUI() {
    }

    public DocNombreUI(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public DocNombreUI(InfoOperacionContableDomain info) {
        this.nombre = info.getNombre();
        this.documento = info.getDocumento();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
