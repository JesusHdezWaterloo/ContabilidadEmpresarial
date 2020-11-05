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
@RequestMapping(value = SUBCUENTA_PATH)
public class SubcuentaRESTService extends RESTServiceTemplate<SubcuentaDomain> implements SubcuentaUseCase {

    private final SubcuentaUseCase subcuentaUC = A_ModuleGestionContabilidadEmpresarial.subcuentaUC;

    public SubcuentaRESTService() {
        setUseCase(subcuentaUC);
    }
}
