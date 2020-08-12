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
        bind(CuentaUseCase.class).to(CuentaUseCaseImpl.class);
        bind(DepositoCuentaUseCase.class).to(DepositoCuentaUseCaseImpl.class);
        bind(ExtraccionCuentaUseCase.class).to(ExtraccionCuentaUseCaseImpl.class);
        bind(MetodoPagoUseCase.class).to(MetodoPagoUseCaseImpl.class);
        bind(MonedaUseCase.class).to(MonedaUseCaseImpl.class);
        bind(SubcuentaUseCase.class).to(SubcuentaUseCaseImpl.class);
        bind(TipoDepositoUseCase.class).to(TipoDepositoUseCaseImpl.class);
        bind(TipoExtraccionUseCase.class).to(TipoExtraccionUseCaseImpl.class);
    }

}
