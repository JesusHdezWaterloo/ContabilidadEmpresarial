package com.jhw.gestion.modules.contabilidad.repo.module;

import com.google.inject.AbstractModule;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.repo_impl.*;

/**
 * Configuracion del injection del modulo de job-repo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ContabilidadRepoInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(CuentaRepo.class).to(CuentaRepoImpl.class);
        bind(DepositoCuentaRepo.class).to(DepositoCuentaRepoImpl.class);
        bind(ExtraccionCuentaRepo.class).to(ExtraccionCuentaRepoImpl.class);
        bind(MetodoPagoRepo.class).to(MetodoPagoRepoImpl.class);
        bind(MonedaRepo.class).to(MonedaRepoImpl.class);
        bind(SubcuentaRepo.class).to(SubcuentaRepoImpl.class);
        bind(TipoDepositoRepo.class).to(TipoDepositoRepoImpl.class);
        bind(TipoExtraccionRepo.class).to(TipoExtraccionRepoImpl.class);
    }

}
