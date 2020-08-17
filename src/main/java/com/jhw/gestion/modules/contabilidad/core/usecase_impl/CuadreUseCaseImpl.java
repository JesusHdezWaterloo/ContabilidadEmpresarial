package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import java.util.List;

public class CuadreUseCaseImpl extends DefaultCRUDUseCase<CuadreDomain> implements CuadreUseCase {

    private final CuadreRepo repo = ContabilidadCoreModule.getInstance().getImplementation(CuadreRepo.class);

    public CuadreUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public CuadreDomain create(CuadreDomain newObject) throws Exception {
        newObject.validate();
        //si creo un cuadre, creo la operacion, y los valores de la cuenta suben
        newObject.getOperacionContableFk().getCuentaFk().increase(newObject.getOperacionContableFk());
        newObject.getOperacionContableCuadreFk().getCuentaFk().increase(newObject.getOperacionContableCuadreFk());
        return super.create(newObject);
    }

    @Override
    public CuadreDomain edit(CuadreDomain objectToUpdate) throws Exception {
        if (objectToUpdate.getLiquidada()) {
            throw new RuntimeException("No se puede editar un cuadre que ha sido liquidado.\nElimine primero la liquidación y luego edite el cuadre.");
        }
        //destruyo el viejo y arreglo las cuentas
        CuadreDomain old = findBy(objectToUpdate.getIdCuadre());
        destroy(old);
        
        //corrijo las cuentas
        objectToUpdate.getOperacionContableFk().setCuentaFk(old.getOperacionContableFk().getCuentaFk());
        objectToUpdate.getOperacionContableCuadreFk().setCuentaFk(old.getOperacionContableCuadreFk().getCuentaFk());
        return create(objectToUpdate);
    }

    @Override
    public CuadreDomain destroy(CuadreDomain objectToDestroy) throws Exception {
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

}
