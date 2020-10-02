package com.jhw.module.gestion.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.CRUDUseCase;
import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.jhw.module.gestion.contabilidad.core.domain.Pagable;
import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.usecase_def.CuadreUseCase;

public class DefaultPagableUseCaseImpl<T extends Pagable> extends DefaultCRUDUseCase<T> implements CRUDUseCase<T> {

    private final CuadreUseCase cuadreUC = ContabilidadCoreModule.getInstance().getImplementation(CuadreUseCase.class);

    @Override
    public T destroy(T objectToDestroy) throws Exception {
        //destruye el cuadre y por defecto el gasto. Destruye el cuadre viejo xq el nuevo viene con el valor cambiado
        cuadreUC.destroy(cuadreUC.findBy(objectToDestroy.getCuadreFk().getIdCuadre()));
        return objectToDestroy;
    }

    @Override
    public T edit(T objectToUpdate) throws Exception {
        destroy(objectToUpdate);
        return create(objectToUpdate);
    }

    @Override
    public T create(T newObject) throws Exception {
        CuadreDomain cuadre = cuadreUC.create(newObject.getCuadreFk());
        newObject.setCuadreFk(cuadre);
        return super.create(newObject);
    }

}
