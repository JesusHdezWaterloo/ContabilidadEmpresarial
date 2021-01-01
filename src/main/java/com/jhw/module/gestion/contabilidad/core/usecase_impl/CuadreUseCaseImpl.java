package com.jhw.module.gestion.contabilidad.core.usecase_impl;

import com.root101.clean.core.app.services.ExceptionHandler;
import com.root101.clean.core.app.services.NotificationHandler;
import com.root101.clean.core.app.services.NotificationsGeneralType;
import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.core.utils.Licenced;
import com.jhw.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.repo_def.CuadreRepo;
import com.jhw.module.gestion.contabilidad.core.usecase_def.CuadreUseCase;
import com.jhw.module.gestion.contabilidad.core.usecase_def.CuentaContableUseCase;
import java.util.List;

public class CuadreUseCaseImpl extends DefaultCRUDUseCase<CuadreDomain> implements CuadreUseCase {

    private final CuadreRepo repo = ContabilidadCoreModule.getInstance().getImplementation(CuadreRepo.class);

    public CuadreUseCaseImpl() {
        super.setRepo(repo);
        checkIntegrity();
    }

    @Override
    @Licenced
    public CuadreDomain create(CuadreDomain newObject) throws Exception {
        newObject.validate();

        CuentaContableUseCase cuentaContableUC = ContabilidadCoreModule.getInstance().getImplementation(CuentaContableUseCase.class);
        //si creo un cuadre, creo la operacion, y los valores de la cuenta suben
        CuentaContableDomain cta1 = cuentaContableUC.findBy(newObject.getOperacionContableFk().getCuentaFk().getIdCuentaContable());
        cta1.increase(newObject.getOperacionContableFk());
        newObject.getOperacionContableFk().setCuentaFk(cta1);

        CuentaContableDomain cta2 = cuentaContableUC.findBy(newObject.getOperacionContableCuadreFk().getCuentaFk().getIdCuentaContable());
        cta2.increase(newObject.getOperacionContableCuadreFk());
        newObject.getOperacionContableCuadreFk().setCuentaFk(cta2);

        return super.create(newObject);
    }

    @Override
    @Licenced
    public CuadreDomain edit(CuadreDomain objectToUpdate) throws Exception {
        CuadreDomain old = findBy(objectToUpdate.getIdCuadre());
        if (old.getLiquidada()) {
            throw new RuntimeException("No se puede editar un cuadre que ha sido liquidado.\nElimine primero la liquidación y luego edite el cuadre.");
        }
        //destruyo y creo
        destroy(objectToUpdate);
        return create(objectToUpdate);
    }

    @Override
    @Licenced
    public CuadreDomain destroy(CuadreDomain objectToDestroy) throws Exception {
        //cargo el viejo que es el que tiene los valores correctos
        objectToDestroy = findBy(objectToDestroy.getIdCuadre());
        if (objectToDestroy.getLiquidada()) {
            throw new RuntimeException("No se puede eliminar un cuadre que ha sido liquidado.\nElimine primero la liquidación y luego el cuadre.");
        }
        objectToDestroy.validate();

        //si destruyo un cuadre, destruyo la operacion, y los valores de la cuenta bajan
        objectToDestroy.getOperacionContableFk().getCuentaFk().decrease(objectToDestroy.getOperacionContableFk());
        objectToDestroy.getOperacionContableCuadreFk().getCuentaFk().decrease(objectToDestroy.getOperacionContableCuadreFk());

        return repo.destroy(objectToDestroy);
    }

    @Override
    public List<CuadreDomain> findAllPending() throws Exception {
        return repo.findAllPending();
    }

    @Override
    public List<CuadreDomain> findByLiquidada(boolean liquidada) throws Exception {
        return repo.findByLiquidada(liquidada);
    }

    @Override
    public List<CuadreDomain> findAllLiquidadas() throws Exception {
        return repo.findAllLiquidadas();
    }

    private void checkIntegrity() {
        try {
            for (CuadreDomain cuadreDomain : super.findAll()) {
                try {
                    cuadreDomain.validate();
                } catch (Exception e) {
                    NotificationHandler.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR,
                            "Error en el cuadre con nombre: '" + cuadreDomain.info().getNombre() + "', documento: '" + cuadreDomain.info().getDocumento() + "'.\nAnótelo en una hoja aparte y reviselo cuando el sistema termine de cargar."
                    );
                }
            }
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
            NotificationHandler.showConfirmDialog(NotificationsGeneralType.CONFIRM_WARNING, ResourceHandler.getString("msg.default_config.error.check_integrity"));
        }
    }
}
