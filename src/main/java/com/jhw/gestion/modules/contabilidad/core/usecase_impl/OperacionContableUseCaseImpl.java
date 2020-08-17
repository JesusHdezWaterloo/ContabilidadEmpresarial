package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import java.util.List;

public class OperacionContableUseCaseImpl extends DefaultCRUDUseCase<OperacionContableDomain> implements OperacionContableUseCase {

    private final OperacionContableRepo repo = ContabilidadCoreModule.getInstance().getImplementation(OperacionContableRepo.class);

    public OperacionContableUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public List<OperacionContableDomain> findAll(CuentaContableDomain cuenta) throws Exception {
        return repo.findAll(cuenta);
    }

    @Override
    @Deprecated
    public OperacionContableDomain destroyById(Object keyId) throws Exception {
        throw new RuntimeException("No se puede eliminar una operacion directamente.\nTiene que eliminarse todo el ajuste");
    }

    @Override
    @Deprecated
    public OperacionContableDomain destroy(OperacionContableDomain objecttToDestroy) throws Exception {
        throw new RuntimeException("No se puede eliminar una operacion directamente.\nTiene que eliminarse todo el ajuste");
    }

    @Override
    @Deprecated
    public OperacionContableDomain edit(OperacionContableDomain objectToUpdate) throws Exception {
        throw new RuntimeException("No se puede editar una operacion directamente.\nTiene que editarse todo el ajuste");
    }

    @Override
    @Deprecated
    public OperacionContableDomain create(OperacionContableDomain newObject) throws Exception {
        throw new RuntimeException("No se puede crear una operacion directamente.\nTiene que crearse todo el ajuste");
    }

}
