package com.jhw.gestion.modules.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.old.DepositoCuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.old.PagoParaDepositar;
import java.util.List;

public interface DepositoCuentaUseCase extends CRUDUseCase<DepositoCuentaDomain> {

    public DepositoCuentaDomain depositarPagoEnCuentas(PagoParaDepositar pago) throws Exception;

    public List<DepositoCuentaDomain> findDepositosOfCuenta(CuentaDomain cuenta);

    public List<DepositoCuentaDomain> findSubDepositos(DepositoCuentaDomain depositoInicial);
}
