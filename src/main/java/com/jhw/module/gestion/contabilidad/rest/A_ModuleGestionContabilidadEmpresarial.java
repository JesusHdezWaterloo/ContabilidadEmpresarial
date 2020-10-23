/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.rest;

import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.usecase_def.*;
import com.jhw.module.gestion.contabilidad.repo.module.ContabilidadRepoModule;
import com.jhw.module.gestion.contabilidad.service.ResourceServiceImplementation;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Component
public class A_ModuleGestionContabilidadEmpresarial {

    public static final String BASE_PACKAGE = "com.jhw.module.gestion.contabilidad";

    public final static CuadreUseCase cuadreUC;
    public final static CuentaBancariaUseCase cuentaBancariaUC;
    public final static CuentaContableUseCase cuentaContableUC;
    public final static InfoOperacionContableUseCase infoOpUC;
    public final static LiquidacionUseCase liquicadionUC;
    public final static MonedaUseCase monedaUC;
    public final static OperacionContableUseCase operacionContableUC;
    public final static SubcuentaUseCase subcuentaUC;
    public final static TipoCuentaUseCase tipoCuentaUC;
    public final static TipoOperacionContableUseCase tipoOperacionContableUC;
    public final static FormaPagoUseCase formaPagoUC;
    public final static TitularUseCase titularUC;

    static {
        ResourceServiceImplementation.init();
        ContabilidadCoreModule.init(ContabilidadRepoModule.init());

        cuadreUC = ContabilidadCoreModule.getInstance().getImplementation(CuadreUseCase.class);
        cuentaBancariaUC = ContabilidadCoreModule.getInstance().getImplementation(CuentaBancariaUseCase.class);
        cuentaContableUC = ContabilidadCoreModule.getInstance().getImplementation(CuentaContableUseCase.class);
        infoOpUC = ContabilidadCoreModule.getInstance().getImplementation(InfoOperacionContableUseCase.class);
        liquicadionUC = ContabilidadCoreModule.getInstance().getImplementation(LiquidacionUseCase.class);
        formaPagoUC = ContabilidadCoreModule.getInstance().getImplementation(FormaPagoUseCase.class);
        monedaUC = ContabilidadCoreModule.getInstance().getImplementation(MonedaUseCase.class);
        operacionContableUC = ContabilidadCoreModule.getInstance().getImplementation(OperacionContableUseCase.class);
        subcuentaUC = ContabilidadCoreModule.getInstance().getImplementation(SubcuentaUseCase.class);
        tipoCuentaUC = ContabilidadCoreModule.getInstance().getImplementation(TipoCuentaUseCase.class);
        tipoOperacionContableUC = ContabilidadCoreModule.getInstance().getImplementation(TipoOperacionContableUseCase.class);
        titularUC = ContabilidadCoreModule.getInstance().getImplementation(TitularUseCase.class);

    }
}
