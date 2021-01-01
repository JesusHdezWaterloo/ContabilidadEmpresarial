package com.root101.module.gestion.contabilidad.core.usecase_impl;

import com.root101.clean.core.app.usecase.DefaultCRUDUseCase;
import com.root101.module.gestion.contabilidad.core.domain.TipoCuentaDomain;
import com.root101.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.root101.module.gestion.contabilidad.core.repo_def.TipoCuentaRepo;
import com.root101.module.gestion.contabilidad.core.usecase_def.TipoCuentaUseCase;
import java.util.List;
import java.util.stream.Collectors;

public class TipoCuentaUseCaseImpl extends DefaultCRUDUseCase<TipoCuentaDomain> implements TipoCuentaUseCase {

    private final TipoCuentaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TipoCuentaRepo.class);

    public TipoCuentaUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public List<TipoCuentaDomain> findAllEquivalent(TipoCuentaDomain tipo) throws Exception {
        return findAll().stream()
                .filter((TipoCuentaDomain t) -> {
                    return t.equivalent(tipo);
                }).collect(Collectors.toList());
    }

    /**
     * Delegate de findAllEquivalent(TipoCuentaDomain tipo)
     *
     * @param idTipoCuenta
     * @return
     * @throws Exception
     */
    @Override
    public List<TipoCuentaDomain> findAllEquivalent(Integer idTipoCuenta) throws Exception {
        return findAllEquivalent(ContabilidadCoreModule.getInstance().getImplementation(TipoCuentaUseCase.class).findBy(idTipoCuenta));
    }
}
