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
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = TITULAR_GENERAL_PATH)
public class TitularRESTService extends RESTServiceTemplate<TitularDomain> implements TitularUseCase {

    private final TitularUseCase titularUC = A_ModuleGestionContabilidadEmpresarial.titularUC;

    public TitularRESTService() {
        setUseCase(titularUC);
    }
}
