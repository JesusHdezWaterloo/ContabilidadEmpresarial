/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain.old;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface PagoParaDepositar {

    public MonedaDomain getMoneda();

    public TipoDepositoDomain getTipoDeposito();

    public double getValor();

    public Integer getId();
}
