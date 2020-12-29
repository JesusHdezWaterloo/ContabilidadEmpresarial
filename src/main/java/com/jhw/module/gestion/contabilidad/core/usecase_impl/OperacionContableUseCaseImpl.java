package com.jhw.module.gestion.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.clean.core.utils.Licenced;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.module.gestion.contabilidad.core.domain.OperacionContableDomain;
import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.repo_def.OperacionContableRepo;
import com.jhw.module.gestion.contabilidad.core.usecase_def.CuentaContableUseCase;
import com.jhw.module.gestion.contabilidad.core.usecase_def.OperacionContableUseCase;
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

    /**
     * Delegate de findAll(CuentaContableDomain cuenta)
     *
     * @param idCuentaContable
     * @return
     * @throws Exception
     */
    @Override
    public List<OperacionContableDomain> findAll(Integer idCuentaContable) throws Exception {
        return findAll(ContabilidadCoreModule.getInstance().getImplementation(CuentaContableUseCase.class).findBy(idCuentaContable));
    }

    @Override
    @Deprecated
    @Licenced
    public OperacionContableDomain create(OperacionContableDomain newObject) throws Exception {
        throw new RuntimeException("No se puede crear una operacion directamente.\nTiene que crearse todo el ajuste");
    }

    @Override
    @Deprecated
    @Licenced
    public OperacionContableDomain edit(OperacionContableDomain objectToUpdate) throws Exception {
        throw new RuntimeException("No se puede editar una operacion directamente.\nTiene que editarse todo el ajuste");
    }

    @Override
    @Deprecated
    @Licenced
    public OperacionContableDomain destroy(OperacionContableDomain objecttToDestroy) throws Exception {
        throw new RuntimeException("No se puede eliminar una operacion directamente.\nTiene que eliminarse todo el ajuste");
    }

    @Override
    @Deprecated
    @Licenced
    public OperacionContableDomain destroyById(Object keyId) throws Exception {
        throw new RuntimeException("No se puede eliminar una operacion directamente.\nTiene que eliminarse todo el ajuste");
    }

}
