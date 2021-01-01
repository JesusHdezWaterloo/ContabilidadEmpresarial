/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.module.gestion.contabilidad.rest;

import static com.root101.module.gestion.contabilidad.core.ModuleGestionContabilidadEmpresarialConstants.*;
import com.root101.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.root101.module.gestion.contabilidad.core.usecase_def.CuadreUseCase;
import com.jhw.utils.spring.server.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = CUADRE_GENERAL_PATH)
public class CuadreRESTService extends RESTServiceTemplate<CuadreDomain> implements CuadreUseCase {

    private final CuadreUseCase cuadreUC = A_ModuleGestionContabilidadEmpresarial.cuadreUC;

    public CuadreRESTService() {
        setUseCase(cuadreUC);
    }

    @Override
    @GetMapping(CUADRE_FIND_ALL_PENDING_PATH)
    public List<CuadreDomain> findAllPending() throws Exception {
        return cuadreUC.findAllPending();
    }

    @Override
    @GetMapping(CUADRE_FIND_ALL_LIQUIDADAS_PATH)
    public List<CuadreDomain> findAllLiquidadas() throws Exception {
        return cuadreUC.findAllLiquidadas();
    }

    @Override
    @GetMapping(CUADRE_FIND_BY_LIQUIDADA_PATH)
    public List<CuadreDomain> findByLiquidada(@PathVariable(LIQUIDADA) boolean bln) throws Exception {
        return cuadreUC.findByLiquidada(bln);
    }

}
