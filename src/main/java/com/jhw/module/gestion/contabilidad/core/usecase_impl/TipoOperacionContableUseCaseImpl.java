package com.jhw.module.gestion.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.TipoOperacionContableDomain;
import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.repo_def.TipoOperacionContableRepo;
import com.jhw.module.gestion.contabilidad.core.usecase_def.TipoOperacionContableUseCase;
import com.jhw.utils.security.SHA;

public class TipoOperacionContableUseCaseImpl extends DefaultCRUDUseCase<TipoOperacionContableDomain> implements TipoOperacionContableUseCase {

    private final TipoOperacionContableRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TipoOperacionContableRepo.class);

    public static TipoOperacionContableDomain MOVIMIENTO_INTERNO;

    public TipoOperacionContableUseCaseImpl() {
        super.setRepo(repo);
        loadTiposStatic();
    }

    @Override
    public TipoOperacionContableDomain create(TipoOperacionContableDomain newObject) throws Exception {
        if (newObject.getKeyEnum() == null || newObject.getKeyEnum().isEmpty()) {
            newObject.setKeyEnum(SHA.hash256(newObject.getNombreOperacion()));
        }
        return super.create(newObject);
    }

    @Override
    public TipoOperacionContableDomain edit(TipoOperacionContableDomain objectToUpdate) throws Exception {
        TipoOperacionContableDomain old = findBy(objectToUpdate.getIdTipoOperacion());
        objectToUpdate.setKeyEnum(old.getKeyEnum());
        return super.edit(objectToUpdate);
    }

    @Override
    public TipoOperacionContableDomain findByKey(String key) {
        try {
            return repo.findByKey(key);
        } catch (Exception e) {
            return null;
        }
    }

    private void loadTiposStatic() {
        MOVIMIENTO_INTERNO = findByKey("tipo_operacion_contable.key.movimiento_interno");
    }

}
