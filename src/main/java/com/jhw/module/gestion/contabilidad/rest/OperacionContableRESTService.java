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
@RequestMapping(value = OPERACION_CONTABLE_GENERAL_PATH)
public class OperacionContableRESTService extends RESTServiceTemplate<OperacionContableDomain> implements OperacionContableUseCase {

    private final OperacionContableUseCase operacionContableUC = A_ModuleGestionContabilidadEmpresarial.operacionContableUC;

    public OperacionContableRESTService() {
        setUseCase(operacionContableUC);
    }

    /**
     * Use findAll(@PathVariable(CUENTA) Integer idCuentaContable) para
     * lightweight
     *
     * @param cuenta
     * @return
     * @throws Exception
     * @deprecated
     */
    @Override
    @Deprecated
    public List<OperacionContableDomain> findAll(CuentaContableDomain cuenta) throws Exception {
        return operacionContableUC.findAll(cuenta);
    }

    @Override
    @GetMapping(OPERACION_CONTABLE_FIND_ALL_PATH)
    public List<OperacionContableDomain> findAll(@PathVariable(CUENTA) Integer idCuentaContable) throws Exception {
        return operacionContableUC.findAll(idCuentaContable);
    }

}
