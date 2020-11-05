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
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = TIPO_OPERACION_PATH)
public class TipoOperacionRESTService extends RESTServiceTemplate<TipoOperacionContableDomain> implements TipoOperacionContableUseCase {

    private final TipoOperacionContableUseCase tipoOperacionContableUC = A_ModuleGestionContabilidadEmpresarial.tipoOperacionContableUC;

    public TipoOperacionRESTService() {
        setUseCase(tipoOperacionContableUC);
    }

    @Override
    @GetMapping(TIPO_OPERACION_PATH_FIND_BY_PATH)
    public TipoOperacionContableDomain findByKey(@PathVariable(SEARCH_TEXT) String searchText) {
        return tipoOperacionContableUC.findByKey(searchText);
    }

}
