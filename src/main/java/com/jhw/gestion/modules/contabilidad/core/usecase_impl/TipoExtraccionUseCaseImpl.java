package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.TipoExtraccionUseCase;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;

public class TipoExtraccionUseCaseImpl extends DefaultCRUDUseCase<TipoExtraccionDomain> implements TipoExtraccionUseCase {

    public static final TipoExtraccionDomain PAGO_TRABAJO = new TipoExtraccionDomain(1);
    public static final TipoExtraccionDomain PAGO_SALARIO = new TipoExtraccionDomain(2);
    public static final TipoExtraccionDomain PAGO_ONAT = new TipoExtraccionDomain(3);
    public static final TipoExtraccionDomain PAGO_GASTO_REALIZADO = new TipoExtraccionDomain(4);
    public static final TipoExtraccionDomain PAGO_COMPRA_MATERIAL = new TipoExtraccionDomain(5);
    public static final TipoExtraccionDomain EXTRACCION_DEPOSITO_SUB_CUENTA = new TipoExtraccionDomain(6);

    private final TipoExtraccionRepo repo = ContabilidadCoreModule.getInstance().getImplementation(TipoExtraccionRepo.class);

    public TipoExtraccionUseCaseImpl() {
        super.setRepo(repo);
    }

}
