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
@RequestMapping(value = TIPO_CUENTA_PATH)
public class TipoCuentaRESTService extends RESTServiceTemplate<TipoCuentaDomain> implements TipoCuentaUseCase {

    private final TipoCuentaUseCase tipoCuentaUC = A_ModuleGestionContabilidadEmpresarial.tipoCuentaUC;

    public TipoCuentaRESTService() {
        setUseCase(tipoCuentaUC);
    }

    @Override
    @GetMapping(TIPO_CUENTA_PATH_FIND_ALL_CUADRE_PATH)
    public List<TipoCuentaDomain> findAllCuadre(@PathVariable(TIPO_CUENTA) TipoCuentaDomain selectedItem) throws Exception {
        return tipoCuentaUC.findAllCuadre(selectedItem);
    }

}
