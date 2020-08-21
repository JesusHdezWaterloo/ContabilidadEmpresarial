package com.jhw.gestion.modules.contabilidad.core.usecase_impl;

import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import com.clean.core.app.usecase.DefaultCRUDUseCase;
import com.clean.core.domain.services.Resource;
import com.clean.core.exceptions.ValidationException;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.gestion.modules.contabilidad.core.usecase_def.*;
import com.jhw.gestion.modules.contabilidad.core.repo_def.*;
import java.util.ArrayList;
import java.util.List;

public class CuentaBancariaUseCaseImpl extends DefaultCRUDUseCase<CuentaBancariaDomain> implements CuentaBancariaUseCase {

    private final CuentaBancariaRepo repo = ContabilidadCoreModule.getInstance().getImplementation(CuentaBancariaRepo.class);

    public CuentaBancariaUseCaseImpl() {
        super.setRepo(repo);
        checkIntegrity();
    }

    @Override
    public CuentaBancariaDomain edit(CuentaBancariaDomain objectToUpdate) throws Exception {
        CuentaBancariaDomain old = findBy(objectToUpdate.getIdCuentaBancaria());
        if (old.getDebito() != objectToUpdate.getDebito()) {
            throw new ValidationException("debito", "No se puede modificar el débito directamente, solo mediante operaciones.\nProbablemente alguien haya modificado la cuenta externamente.");
        }
        if (old.getCredito() != objectToUpdate.getCredito()) {
            throw new ValidationException("credito", "No se puede modificar el crédito directamente, solo mediante operaciones.\nProbablemente alguien haya modificado la cuenta externamente.");
        }
        if (!old.getMonedaFk().equals(objectToUpdate.getMonedaFk())) {
            throw new ValidationException("monedaFk", "No se puede cambiar la moneda de la cuenta.");
        }
        return super.edit(objectToUpdate);
    }

    @Override
    public List<CuentaBancariaDomain> findAll(String searchText) throws Exception {
        List<CuentaBancariaDomain> cuentasBancarias = findAll();
        List<CuentaBancariaDomain> cuentas = new ArrayList<>();
        for (CuentaBancariaDomain c : cuentasBancarias) {
            if (c.test(searchText)) {
                cuentas.add(c);
            }
        }
        return cuentas;
    }

    @Override
    public CuentaBancariaDomain findCuentaDefault(MonedaDomain moneda) throws Exception {
        List<CuentaBancariaDomain> all = findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("No hay ninguna cuenta bancaria creada.");
        }
        for (CuentaBancariaDomain c : all) {
            if (c.getMonedaFk().equals(moneda)) {
                return c;
            }
        }
        return all.get(0);
    }

    @Override
    public CuentaBancariaDomain create(CuentaBancariaDomain cuenta) throws Exception {
        cuenta.setDebito(0);
        cuenta.setCredito(0);
        return super.create(cuenta);
    }

    @Override
    public List<Cuenta> findAllCuentas() throws Exception {
        List<CuentaBancariaDomain> cuentasBancarias = findAll();
        List<Cuenta> cuentas = new ArrayList<>(cuentasBancarias.size());
        for (CuentaBancariaDomain c : cuentasBancarias) {
            cuentas.add(c);
        }
        return cuentas;
    }

    private void checkIntegrity() {
        try {
            LiquidacionUseCase liqUC = ContabilidadCoreModule.getInstance().getImplementation(LiquidacionUseCase.class);
            for (CuentaBancariaDomain c : super.findAll()) {
                double deb = 0;
                double cred = 0;
                for (LiquidacionDomain liquidacionDomain : liqUC.findAll(c)) {
                    deb += liquidacionDomain.getDebito();
                    cred += liquidacionDomain.getCredito();
                }
                if (c.getDebito() != deb || c.getCredito() != cred) {
                    c.setDebito(deb);
                    c.setCredito(cred);
                    repo.edit(c);//directo pal repo pa que no pase las validaciones del edit
                }
            }
        } catch (Exception e) {
            Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_ERROR, Resource.getString("msg.default_config.error.check_integrity"));

        }
    }
}
