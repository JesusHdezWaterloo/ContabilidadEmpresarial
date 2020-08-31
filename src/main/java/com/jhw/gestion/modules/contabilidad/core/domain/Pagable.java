/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import java.math.BigDecimal;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface Pagable {

    public BigDecimal getValor();

    public void setValor(BigDecimal valor);

    public MonedaDomain getMonedaFk();

    public void setMonedaFk(MonedaDomain monedaFk);

    public CuadreDomain getCuadreFk();

    public void setCuadreFk(CuadreDomain cuadreFk);

}
