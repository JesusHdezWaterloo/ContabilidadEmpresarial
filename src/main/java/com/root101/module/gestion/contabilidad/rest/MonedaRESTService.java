/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = MONEDA_GENERAL_PATH)
public class MonedaRESTService extends RESTServiceTemplate<MonedaDomain> implements MonedaUseCase {

    private final MonedaUseCase monedaUC = A_ModuleGestionContabilidadEmpresarial.monedaUC;

    public MonedaRESTService() {
        setUseCase(monedaUC);
    }

    @Override
    @GetMapping(MONEDA_FIND_BASE_PATH)
    public MonedaDomain findMonedaBase() throws Exception {
        return monedaUC.findMonedaBase();
    }
}
