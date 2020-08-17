package com.jhw.gestion.modules.contabilidad.repo.module;

import com.google.inject.AbstractModule;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.repo.repo_impl.*;

/**
 * Configuracion del injection del modulo de contabilidad-repo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ContabilidadRepoInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(CuadreRepo.class).to(CuadreRepoImpl.class);
        bind(CuentaBancariaRepo.class).to(CuentaBancariaRepoImpl.class);
        bind(CuentaContableRepo.class).to(CuentaContableRepoImpl.class);
        bind(InfoOperacionContableRepo.class).to(InfoOperacionContableRepoImpl.class);
        bind(LiquidacionRepo.class).to(LiquidacionRepoImpl.class);
        bind(FormaPagoRepo.class).to(FormaPagoRepoImpl.class);
        bind(MonedaRepo.class).to(MonedaRepoImpl.class);
        bind(OperacionContableRepo.class).to(OperacionContableRepoImpl.class);
        bind(SubcuentaRepo.class).to(SubcuentaRepoImpl.class);
        bind(TipoCuentaRepo.class).to(TipoCuentaRepoImpl.class);
        bind(TipoOperacionContableRepo.class).to(TipoOperacionContableRepoImpl.class);
    }

}
