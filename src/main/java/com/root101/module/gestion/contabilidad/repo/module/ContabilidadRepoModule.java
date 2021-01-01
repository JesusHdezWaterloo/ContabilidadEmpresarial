package com.root101.module.gestion.contabilidad.repo.module;

import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.root101.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;

/**
 * Modulo de contabilidad-repo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ContabilidadRepoModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new ContabilidadRepoInjectionConfig());

    private static ContabilidadRepoModule INSTANCE;

    private ContabilidadRepoModule() {
        ResourcesContabilidad.initEMF();
    }

    public static ContabilidadRepoModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de Contabilidad no se ha inicializado");
        }
        return INSTANCE;
    }

    public static ContabilidadRepoModule init() {
        INSTANCE = new ContabilidadRepoModule();
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "Contabilidad Repo Module";
    }

}
