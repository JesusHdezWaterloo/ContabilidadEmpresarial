package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.usecase_impl.graph.CicloGraph;
import java.util.List;

public class SubcuentaUseCaseImpl extends DefaultCRUDUseCase<SubcuentaDomain> implements SubcuentaUseCase {

    private final SubcuentaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(SubcuentaRepo.class);

    public SubcuentaUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public SubcuentaDomain edit(SubcuentaDomain objectToUpdate) throws Exception {
        if (CicloGraph.exec(objectToUpdate)) {
            throw new RuntimeException("No se puede editar esta subcuenta, forma un ciclo infinito en los depósitos.");
        }
        return super.edit(objectToUpdate);
    }

    @Override
    public SubcuentaDomain create(SubcuentaDomain newObject) throws Exception {
        if (CicloGraph.exec(newObject)) {
            throw new RuntimeException("No se puede crear esta subcuenta, forma un ciclo infinito en los depósitos.");
        }
        return super.create(newObject);
    }

    @Override
    public List<SubcuentaDomain> findSubcuentasDondeSeaHijo(CuentaDomain hijo) {
        return repo.findSubcuentasDondeSeaHijo(hijo);
    }

    @Override
    public List<SubcuentaDomain> findSubcuentasDondeSeaPadre(CuentaDomain padre) {
        return repo.findSubcuentasDondeSeaPadre(padre);
    }

}
