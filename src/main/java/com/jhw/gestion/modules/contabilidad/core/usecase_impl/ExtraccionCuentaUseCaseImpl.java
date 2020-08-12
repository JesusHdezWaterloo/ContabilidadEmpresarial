package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import java.util.List;

public class ExtraccionCuentaUseCaseImpl extends DefaultCRUDUseCase<ExtraccionCuentaDomain> implements ExtraccionCuentaUseCase {

    private final ExtraccionCuentaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(ExtraccionCuentaRepo.class);

    private final CuentaUseCase cuentaUC = ContabilidadCoreModule.getInstance().getImplementation(CuentaUseCase.class);

    public ExtraccionCuentaUseCaseImpl() {
        setRepo(repo);
    }

    @Override
    public ExtraccionCuentaDomain destroy(ExtraccionCuentaDomain ext) throws Exception {
        cuentaUC.updateFor(ext, false);
        return super.destroy(ext);
    }

    @Override
    public ExtraccionCuentaDomain edit(ExtraccionCuentaDomain extraccionCuenta) throws Exception {
        destroy(extraccionCuenta);
        return super.create(extraccionCuenta);
    }

    @Override
    public ExtraccionCuentaDomain create(ExtraccionCuentaDomain extraccionCuenta) throws Exception {
        extraccionCuenta = super.create(extraccionCuenta);
        cuentaUC.updateFor(extraccionCuenta, true);
        return extraccionCuenta;
    }

    @Override
    public List<ExtraccionCuentaDomain> findExtraccionList(TipoExtraccionDomain tipo, Integer idExterno) throws Exception {
        return repo.findExtraccionList(tipo, idExterno);
    }

    @Override
    public ExtraccionCuentaDomain findExtraccionSingle(TipoExtraccionDomain tipo, Integer idExterno) throws Exception {
        return repo.findExtraccionSingle(tipo, idExterno);
    }

    @Override
    public List<ExtraccionCuentaDomain> findExtraccionesOfCuenta(CuentaDomain cuenta) throws Exception {
        return repo.findExtraccionesOfCuenta(cuenta);
    }
}
