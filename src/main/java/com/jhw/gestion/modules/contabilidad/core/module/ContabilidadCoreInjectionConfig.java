package com.jhw.gestion.modules.contabilidad.core.module;

import com.google.inject.AbstractModule;

import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.usecase_impl.*;

/**
 * Configuracion del injection del modulo de job-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ContabilidadCoreInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(CuadreUseCase.class).to(CuadreUseCaseImpl.class);
        bind(CuentaBancariaUseCase.class).to(CuentaBancariaUseCaseImpl.class);
        bind(CuentaContableUseCase.class).to(CuentaContableUseCaseImpl.class);
        bind(InfoOperacionContableUseCase.class).to(InfoOperacionContableUseCaseImpl.class);
        bind(LiquidacionUseCase.class).to(LiquidacionUseCaseImpl.class);
        bind(FormaPagoUseCase.class).to(FormaPagoUseCaseImpl.class);
        bind(MonedaUseCase.class).to(MonedaUseCaseImpl.class);
        bind(OperacionContableUseCase.class).to(OperacionContableUseCaseImpl.class);
        bind(SubcuentaUseCase.class).to(SubcuentaUseCaseImpl.class);
        bind(TipoCuentaUseCase.class).to(TipoCuentaUseCaseImpl.class);
        bind(TipoOperacionContableUseCase.class).to(TipoOperacionContableUseCaseImpl.class);
    }

}
