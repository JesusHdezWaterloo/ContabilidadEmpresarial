package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.jhw.gestion.modules.contabilidad.core.usecase_impl.graph.DepositoCuentaCreateGraph;
import com.jhw.gestion.modules.contabilidad.core.usecase_impl.graph.DepositoCuentaDestroyGraph;
import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import java.util.List;

public class DepositoCuentaUseCaseImpl extends DefaultCRUDUseCase<DepositoCuentaDomain> implements DepositoCuentaUseCase {

    private final DepositoCuentaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(DepositoCuentaRepo.class);

    private final CuentaUseCase cuentaUC = ContabilidadCoreModule.getInstance().getImplementation(CuentaUseCase.class);

    public DepositoCuentaUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public DepositoCuentaDomain destroy(DepositoCuentaDomain depositoCuenta) throws Exception {
        DepositoCuentaDestroyGraph graph = DepositoCuentaDestroyGraph.exec(depositoCuenta);
        repo.destroy(graph.getExtracciones_depositos(), graph.getCuentas());
        return depositoCuenta;
    }

    @Override
    public DepositoCuentaDomain edit(DepositoCuentaDomain depositoCuenta) throws Exception {
        destroy(depositoCuenta);
        return create(depositoCuenta);
    }

    @Override
    public DepositoCuentaDomain create(DepositoCuentaDomain depositoCuenta) throws Exception {
        DepositoCuentaCreateGraph graph = DepositoCuentaCreateGraph.exec(depositoCuenta);
        return repo.create(depositoCuenta, graph.getExtracciones_depositos(), graph.getCuentas());
    }

    @Override
    public List<DepositoCuentaDomain> findDepositosOfCuenta(CuentaDomain cuenta) {
        return repo.findDepositosOfCuenta(cuenta);
    }

    @Override
    public List<DepositoCuentaDomain> findSubDepositos(DepositoCuentaDomain depositoInicial) {
        return repo.findSubDepositos(depositoInicial);
    }

    @Override
    public DepositoCuentaDomain depositarPagoEnCuentas(PagoParaDepositar pago) throws Exception {
        CuentaDomain base = cuentaUC.findCuentaDepositoBase(pago.getMoneda());
        if (base == null) {
            throw new Exception("NO HAY CUENTA BASE CON LA MONEDA DEL PAGO.");
        }
        return create(new DepositoCuentaDomain((float) pago.getValor(), 100f, base, pago.getTipoDeposito(), pago.getId()));
    }
}
