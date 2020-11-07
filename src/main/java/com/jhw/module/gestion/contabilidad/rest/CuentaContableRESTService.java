/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.rest;

import static com.jhw.module.gestion.contabilidad.core.ModuleGestionContabilidadEmpresarialConstants.*;
import com.jhw.module.gestion.contabilidad.core.domain.*;
import com.jhw.module.gestion.contabilidad.core.usecase_def.*;
import com.jhw.utils.spring.server.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = CUENTA_CONTABLE_GENERAL_PATH)
public class CuentaContableRESTService extends RESTServiceTemplate<CuentaContableDomain> implements CuentaContableUseCase {

    private final CuentaContableUseCase cuentaContableUC = A_ModuleGestionContabilidadEmpresarial.cuentaContableUC;

    public CuentaContableRESTService() {
        setUseCase(cuentaContableUC);
    }

    @Override
    @GetMapping(CUENTA_CONTABLE_FIND_ALL_CUENTAS_PATH)
    public List<Cuenta> findAllCuentas() throws Exception {
        return cuentaContableUC.findAllCuentas();
    }

    /**
     * Use findAllCuenta(@PathVariable(TIPO_CUENTA) Integer idTipoCuenta) para
     * lightweight
     *
     * @param tipo
     * @return
     * @throws Exception
     * @deprecated
     */
    @Override
    @Deprecated
    public List<CuentaContableDomain> findAllCuenta(TipoCuentaDomain tipo) throws Exception {
        return cuentaContableUC.findAllCuenta(tipo);
    }

    @Override
    @GetMapping(CUENTA_CONTABLE_FIND_ALL_PATH)
    public List<CuentaContableDomain> findAllCuenta(@PathVariable(TIPO_CUENTA) Integer idTipoCuenta) throws Exception {
        return cuentaContableUC.findAllCuenta(idTipoCuenta);
    }

    @Override
    @GetMapping(CUENTA_CONTABLE_FIND_ALL_SEARCH_PATH)
    public List<CuentaContableDomain> findAll(@PathVariable(SEARCH_TEXT) String searchText) throws Exception {
        return cuentaContableUC.findAll(searchText);
    }

}
