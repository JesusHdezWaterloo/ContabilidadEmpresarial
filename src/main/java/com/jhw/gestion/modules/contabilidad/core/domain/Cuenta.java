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
public interface Cuenta {

    public Integer ggetIdCuenta();

    public void ssetIdCuenta(Integer idCuenta);

    public String getNombreCuenta();

    public void setNombreCuenta(String nombreCuenta);

    public String getCodigo();

    public void setCodigo(String codigo);

    public BigDecimal getDebito();

    public void setDebito(BigDecimal debito);

    public BigDecimal getCredito();

    public void setCredito(BigDecimal credito);

    public default BigDecimal saldo() {
        return getDebito().subtract(getCredito()).abs();
    }

    public String getDescripcion();

    public void setDescripcion(String descripcion);

    public MonedaDomain getMonedaFk();

    public void setMonedaFk(MonedaDomain monedaFk);

}
