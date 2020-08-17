package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;

public class TipoOperacionContableUseCaseImpl extends DefaultCRUDUseCase<TipoOperacionContableDomain> implements TipoOperacionContableUseCase {

    private final TipoOperacionContableRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TipoOperacionContableRepo.class);

    public static TipoOperacionContableDomain MOVIMIENTO_INTERNO;

    public TipoOperacionContableUseCaseImpl() {
        super.setRepo(repo);
        loadTiposStatic();
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
