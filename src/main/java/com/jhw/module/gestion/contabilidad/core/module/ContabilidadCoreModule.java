package com.jhw.module.gestion.contabilidad.core.module;

import com.clean.core.app.modules.AbstractModule;
import com.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jhw.module.gestion.contabilidad.repo.module.ContabilidadRepoModule;

/**
 * Modulo de contabilidad-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ContabilidadCoreModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new ContabilidadCoreInjectionConfig());

    private static ContabilidadCoreModule INSTANCE;

    public static ContabilidadCoreModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de Contabilidad no se ha inicializado");
        }
        return INSTANCE;
    }

    public static ContabilidadCoreModule init() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new ContabilidadCoreModule();
        INSTANCE.registerModule(ContabilidadRepoModule.init());
        return getInstance();
    }

    /**
     * Usar init() sin repo por parametro para usar el repo por defecto
     *
     * @param repoModule
     * @return
     * @deprecated
     */
    @Deprecated
    public static ContabilidadCoreModule init(AbstractModule repoModule) {
        INSTANCE = new ContabilidadCoreModule();
        INSTANCE.registerModule(repoModule);
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Contabilidad Core Module";
    }

}
