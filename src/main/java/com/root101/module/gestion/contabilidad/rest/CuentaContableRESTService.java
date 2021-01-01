/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.gestion.contabilidad.rest;

import static com.root101.module.gestion.contabilidad.core.ModuleGestionContabilidadEmpresarialConstants.*;
import com.root101.module.gestion.contabilidad.core.domain.*;
import com.root101.module.gestion.contabilidad.core.usecase_def.*;
import com.jhw.utils.spring.server.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
