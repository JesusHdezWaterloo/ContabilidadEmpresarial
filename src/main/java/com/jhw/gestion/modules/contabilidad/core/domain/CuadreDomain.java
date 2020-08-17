/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain;

import com.clean.core.exceptions.ValidationException;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.CuadreUI;
import com.clean.core.utils.SortBy;
import com.clean.core.utils.validation.ValidationMessage;
import com.clean.core.utils.validation.ValidationResult;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@SortBy(priority = {"liquidada"}, order = SortBy.ASCENDING)
public class CuadreDomain extends EntityDomainObjectValidated {

    private static final long serialVersionUID = 1L;

    private Integer idCuadre;

    private boolean liquidada;

    @NotNull(message = "#msg.module.contabilidad.validation.cuadre_operacion_contable_null#")
    private OperacionContableDomain operacionContableCuadreFk;

    @NotNull(message = "#msg.module.contabilidad.validation.cuadre_operacion_contable_null#")
    private OperacionContableDomain operacionContableFk;

    public CuadreDomain() {
    }

    public CuadreDomain(Integer idCuadre) {
        this.idCuadre = idCuadre;
    }

    public CuadreDomain(boolean liquidada, OperacionContableDomain operacionContableCuadreFk, OperacionContableDomain operacionContableFk) {
        this.liquidada = liquidada;
        this.operacionContableCuadreFk = operacionContableCuadreFk;
        this.operacionContableFk = operacionContableFk;
    }

    public CuadreDomain(CuadreUI cuadre) {
        updateWith(cuadre);
    }

    public void updateWith(CuadreUI cuadre) {
        double valorConvertidoCuenta = MonedaHandler.venta(cuadre.getValor(), cuadre.getMoneda(), cuadre.getCuenta().getMonedaFk());

        double debito1 = 0;
        double credito1 = 0;
        if (cuadre.getCuenta().getTipoCuentaFk().getDebitoCredito()) {//debito
            debito1 = valorConvertidoCuenta;
        } else {
            credito1 = valorConvertidoCuenta;
        }
        operacionContableFk = new OperacionContableDomain(debito1, credito1, cuadre.getCuenta(), cuadre.getInfo());

        //debito y credito invertido para mantener equilibrio
        double debito2 = MonedaHandler.compra(credito1, cuadre.getCuenta().getMonedaFk(), cuadre.getCuentaCuadre().getMonedaFk());
        double credito2 = MonedaHandler.compra(debito1, cuadre.getCuenta().getMonedaFk(), cuadre.getCuentaCuadre().getMonedaFk());
        operacionContableCuadreFk = new OperacionContableDomain(debito2, credito2, cuadre.getCuentaCuadre(), cuadre.getInfo());

        liquidada = false;

        validate();
    }

    public InfoOperacionContableDomain info() {
        return operacionContableCuadreFk.getInfoOperacionContableFk();
    }

    public Integer getIdCuadre() {
        return idCuadre;
    }

    public void setIdCuadre(Integer idCuadre) {
        this.idCuadre = idCuadre;
    }

    public boolean getLiquidada() {
        return liquidada;
    }

    public void setLiquidada(boolean liquidada) {
        this.liquidada = liquidada;
    }

    public OperacionContableDomain getOperacionContableCuadreFk() {
        return operacionContableCuadreFk;
    }

    public void setOperacionContableCuadreFk(OperacionContableDomain operacionContableCuadreFk) {
        this.operacionContableCuadreFk = operacionContableCuadreFk;
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
        hash += (idCuadre != null ? idCuadre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CuadreDomain)) {
            return false;
        }
        CuadreDomain other = (CuadreDomain) object;
        if ((this.idCuadre == null && other.idCuadre != null) || (this.idCuadre != null && !this.idCuadre.equals(other.idCuadre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return operacionContableCuadreFk.toString();
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult v = super.validate();

        //debito-credito
        if (getOperacionContableFk().getDebito() != MonedaHandler.venta(getOperacionContableCuadreFk().getCredito(), getOperacionContableCuadreFk().getCuentaFk().getMonedaFk(), getOperacionContableFk().getCuentaFk().getMonedaFk())) {
            v.add(ValidationMessage.from("operacionContableFk", "Lo que se debita en la cuenta inicial no coincide con lo que se acredita en el cuadre."));
        }
        if (getOperacionContableFk().getCredito() != MonedaHandler.venta(getOperacionContableCuadreFk().getDebito(), getOperacionContableCuadreFk().getCuentaFk().getMonedaFk(), getOperacionContableFk().getCuentaFk().getMonedaFk())) {
            v.add(ValidationMessage.from("operacionContableFk", "Lo que se acredita en la cuenta inicial no coincide con lo que se debita en el cuadre."));
        }
        //diferentes tipos
        if (getOperacionContableFk().getCuentaFk().getTipoCuentaFk().getDebitoCredito() == getOperacionContableCuadreFk().getCuentaFk().getTipoCuentaFk().getDebitoCredito()) {
            v.add(ValidationMessage.from("operacionContableCuadreFk", "No se puede crear un cuadre entre 2 cuentas del mismo tipo.\nUna tiene que ser deudora y otra acreedora para mantenerse cuadradas. ☺"));
        }
        //liquidable
        if (!getOperacionContableCuadreFk().getCuentaFk().getTipoCuentaFk().isLiquidable()) {
            v.add(ValidationMessage.from("operacionContableCuadreFk", "No se puede hacer un cuadre contra una cuenta que no sea liquidable."));
        }
        return v.throwException();
    }

}
