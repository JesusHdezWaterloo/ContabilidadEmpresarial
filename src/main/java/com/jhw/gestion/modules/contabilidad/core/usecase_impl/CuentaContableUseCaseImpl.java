package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.clean.core.exceptions.ValidationException;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaContableUseCaseImpl extends DefaultCRUDUseCase<CuentaContableDomain> implements CuentaContableUseCase {

    private final CuentaContableRepo repo = ContabilidadCoreModule.getInstance().getImplementation(CuentaContableRepo.class);

    public CuentaContableUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public CuentaContableDomain edit(CuentaContableDomain objectToUpdate) throws Exception {
        CuentaContableDomain old = findBy(objectToUpdate.getIdCuentaContable());
        if (old.getDebito() != objectToUpdate.getDebito()) {
            throw new ValidationException("debito", "No se puede modificar el débito directamente, solo mediante operaciones.\nProbablemente alguien haya modificado la cuenta externamente.");
        }
        if (old.getCredito()!= objectToUpdate.getCredito()) {
            throw new ValidationException("credito", "No se puede modificar el crédito directamente, solo mediante operaciones.\nProbablemente alguien haya modificado la cuenta externamente.");
        }
        if (!old.getMonedaFk().equals(objectToUpdate.getMonedaFk())) {
            throw new ValidationException("monedaFk", "No se puede cambiar la moneda de la cuenta.");
        }
        if (!old.getTipoCuentaFk().equals(objectToUpdate.getTipoCuentaFk())) {
            throw new ValidationException("tipoCuentaFk", "No se puede cambiar el tipo cuenta.");
        }
        return super.edit(objectToUpdate);
    }

    @Override
    public List<CuentaContableDomain> findAll(String searchText) throws Exception {
        List<CuentaContableDomain> cuentasBancarias = findAll();
        List<CuentaContableDomain> cuentas = new ArrayList<>();
        for (CuentaContableDomain c : cuentasBancarias) {
            if (c.test(searchText)) {
                cuentas.add(c);
            }
        }
        return cuentas;
    }

    @Override
    public List<Cuenta> findAllCuentas() throws Exception {
        List<CuentaContableDomain> cuentasContables = findAll();
        List<Cuenta> cuentas = new ArrayList<>(cuentasContables.size());
        for (CuentaContableDomain c : cuentasContables) {
            cuentas.add(c);
        }
        return cuentas;
    }

    @Override
    public List<CuentaContableDomain> findAllCuadre(TipoCuentaDomain tipo) throws Exception {
        List<CuentaContableDomain> cuentasContables = findAll();
        List<CuentaContableDomain> cuentas = new ArrayList<>(cuentasContables.size());
        for (CuentaContableDomain c : cuentasContables) {
            if (c.getTipoCuentaFk().getDebitoCredito() != tipo.getDebitoCredito() && c.getTipoCuentaFk().isLiquidable()) {
                cuentas.add(c);
            }
        }
        return cuentas;
    }

}
