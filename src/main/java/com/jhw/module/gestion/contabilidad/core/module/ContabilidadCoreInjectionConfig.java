package com.jhw.module.gestion.contabilidad.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.jhw.module.gestion.contabilidad.core.usecase_def.*;
import com.jhw.module.gestion.contabilidad.core.usecase_impl.*;


/**
 * Configuracion del injection del modulo de contabilidad-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ContabilidadCoreInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(CuadreUseCase.class).to(CuadreUseCaseImpl.class).in(Singleton.class);
        bind(CuentaBancariaUseCase.class).to(CuentaBancariaUseCaseImpl.class).in(Singleton.class);
        bind(CuentaContableUseCase.class).to(CuentaContableUseCaseImpl.class).in(Singleton.class);
        bind(InfoOperacionContableUseCase.class).to(InfoOperacionContableUseCaseImpl.class).in(Singleton.class);
        bind(LiquidacionUseCase.class).to(LiquidacionUseCaseImpl.class).in(Singleton.class);
        bind(FormaPagoUseCase.class).to(FormaPagoUseCaseImpl.class).in(Singleton.class);
        bind(MonedaUseCase.class).to(MonedaUseCaseImpl.class).in(Singleton.class);
        bind(OperacionContableUseCase.class).to(OperacionContableUseCaseImpl.class).in(Singleton.class);
        bind(SubcuentaUseCase.class).to(SubcuentaUseCaseImpl.class).in(Singleton.class);
        bind(TipoCuentaUseCase.class).to(TipoCuentaUseCaseImpl.class).in(Singleton.class);
        bind(TipoOperacionContableUseCase.class).to(TipoOperacionContableUseCaseImpl.class).in(Singleton.class);
        bind(TitularUseCase.class).to(TitularUseCaseImpl.class).in(Singleton.class);
    }

}
