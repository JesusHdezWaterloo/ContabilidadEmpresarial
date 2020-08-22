/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.core.domain.facade;

import com.clean.core.domain.VolatileDomainObject;
import com.jhw.gestion.modules.contabilidad.core.domain.CuadreDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.FormaPagoDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.InfoOperacionContableDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.MonedaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.OperacionContableDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.TipoOperacionContableDomain;
import com.jhw.gestion.modules.contabilidad.utils.MonedaHandler;
import java.util.Date;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CuadreUI extends VolatileDomainObject {

    private DocNombreUI docNombre;
    private OperacionCuadreUI op;
    private FechaDescUI fechaDesc;
    private TipoOperacionContableDomain tipoOp;

    public CuadreUI() {
    }

    public CuadreUI(DocNombreUI docNombre, OperacionCuadreUI op, FechaDescUI fechaDesc, TipoOperacionContableDomain tipoOp) {
        this.docNombre = docNombre;
        this.op = op;
        this.fechaDesc = fechaDesc;
        this.tipoOp = tipoOp;
    }

    public CuadreDomain buildCuadre() {
        CuadreDomain cuadreNew = new CuadreDomain();
        double valorConvertidoCuenta = MonedaHandler.venta(getValor(), getMoneda(), getCuenta().getMonedaFk());

        double debito1 = 0;
        double credito1 = 0;
        if (getCuenta().getTipoCuentaFk().getDebitoCredito()) {//debito
            debito1 = valorConvertidoCuenta;
        } else {
            credito1 = valorConvertidoCuenta;
        }
        cuadreNew.setOperacionContableFk(new OperacionContableDomain(debito1, credito1, getCuenta(), getInfo()));

        //debito y credito invertido para mantener equilibrio
        double debito2 = MonedaHandler.compra(credito1, getCuenta().getMonedaFk(), getCuentaCuadre().getMonedaFk());
        double credito2 = MonedaHandler.compra(debito1, getCuenta().getMonedaFk(), getCuentaCuadre().getMonedaFk());
        cuadreNew.setOperacionContableCuadreFk(new OperacionContableDomain(debito2, credito2, getCuentaCuadre(), getInfo()));

        cuadreNew.setLiquidada(false);

        cuadreNew.validate();
        return cuadreNew;
    }

    public InfoOperacionContableDomain getInfo() {
        return new InfoOperacionContableDomain(
                getDocumento(),
                getNombre(),
                getFecha(),
                getDescripcion(),
                tipoOp,
                getFormaPagoFk());
    }

    public TipoOperacionContableDomain getTipoOp() {
        return tipoOp;
    }

    public double getValor() {
        return op.getValor();
    }

    public MonedaDomain getMoneda() {
        return op.getMoneda();
    }

    public CuentaContableDomain getCuenta() {
        return op.getCuenta();
    }

    public CuentaContableDomain getCuentaCuadre() {
        return op.getCuadre();
    }

    public String getDocumento() {
        return docNombre.getDocumento();
    }

    public String getNombre() {
        return docNombre.getNombre();
    }

    public Date getFecha() {
        return fechaDesc.getFecha();
    }

    public String getDescripcion() {
        return fechaDesc.getDescripcion();
    }

    public FormaPagoDomain getFormaPagoFk() {
        return fechaDesc.getPago();
    }

}
