/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain.facade;

import com.clean.core.domain.VolatileDomainObject;
import com.jhw.gestion.modules.contabilidad.core.domain.TipoOperacionContableDomain;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class InfoOpBaseUI extends VolatileDomainObject {

    private TipoOperacionContableDomain tipoOp;
    private Integer idExterno;

    public InfoOpBaseUI(TipoOperacionContableDomain tipoOp, Integer idExterno) {
        this.tipoOp = tipoOp;
        this.idExterno = idExterno;
    }

    public TipoOperacionContableDomain getTipoOp() {
        return tipoOp;
    }

    public void setTipoOp(TipoOperacionContableDomain tipoOp) {
        this.tipoOp = tipoOp;
    }

    public Integer getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(Integer idExterno) {
        this.idExterno = idExterno;
    }

}
