package com.jhw.gestion.modules.contabilidad.core.repo_def;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.old.DepositoCuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.old.ExtraccionCuentaDomain;
import com.jhw.utils.others.PairDifferent;
import java.util.List;

public interface DepositoCuentaRepo extends CRUDRepository<DepositoCuentaDomain> {

    public List<DepositoCuentaDomain> findDepositosOfCuenta(CuentaDomain cuenta);

    public DepositoCuentaDomain create(DepositoCuentaDomain deposito, List<PairDifferent<DepositoCuentaDomain, ExtraccionCuentaDomain>> extracciones, List<CuentaDomain> cuentas) throws Exception;

    public void destroy(List<PairDifferent<DepositoCuentaDomain, ExtraccionCuentaDomain>> extracciones, List<CuentaDomain> cuentas) throws Exception;

    public List<DepositoCuentaDomain> findSubDepositos(DepositoCuentaDomain depositoInicial);
}
