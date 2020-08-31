/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface TipoPagable {

    public MonedaDomain getMonedaDefectoFk();

    public void setMonedaDefectoFk(MonedaDomain monedaDefectoFk);

    public TipoOperacionContableDomain getTipoOperacionContableDefectoFk();

    public void setTipoOperacionContableDefectoFk(TipoOperacionContableDomain tipoOperacionContableDefectoFk);

    public FormaPagoDomain getFormaPagoFk();

    public void setFormaPagoFk(FormaPagoDomain formaPagoFk);

}
