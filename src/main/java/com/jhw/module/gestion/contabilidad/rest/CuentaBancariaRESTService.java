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
@RequestMapping(value = CUENTA_BANCARIA_GENERAL_PATH)
public class CuentaBancariaRESTService extends RESTServiceTemplate<CuentaBancariaDomain> implements CuentaBancariaUseCase {

    private final CuentaBancariaUseCase cuentaBancariaUC = A_ModuleGestionContabilidadEmpresarial.cuentaBancariaUC;

    public CuentaBancariaRESTService() {
        setUseCase(cuentaBancariaUC);
    }

    @Override
    @GetMapping(CUENTA_BANCARIA_FIND_ALL_CUENTAS_PATH)
    public List<Cuenta> findAllCuentas() throws Exception {
        return cuentaBancariaUC.findAllCuentas();
    }

    @Override
    @GetMapping(CUENTA_BANCARIA_FIND_DEFAULT_PATH)
    public CuentaBancariaDomain findCuentaDefault(@PathVariable(LIQUIDADA) MonedaDomain moneda) throws Exception {
        return cuentaBancariaUC.findCuentaDefault(moneda);
    }

    @Override
    @GetMapping(CUENTA_BANCARIA_FIND_ALL_SEARCH_PATH)
    public List<CuentaBancariaDomain> findAll(@PathVariable(SEARCH_TEXT) String searchText) throws Exception {
        return cuentaBancariaUC.findAll(searchText);
    }

}
