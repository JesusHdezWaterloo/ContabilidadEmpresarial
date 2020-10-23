/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.rest;

import com.jhw.module.gestion.contabilidad.core.ModuleGestionContabilidadEmpresarialConstants;
import com.jhw.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.core.usecase_def.CuadreUseCase;
import com.jhw.utils.spring.server.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@RestController
@RequestMapping(value = ModuleGestionContabilidadEmpresarialConstants.PATH_CUADRE_GENERAL)
public class CuadreRESTService extends RESTServiceTemplate<CuadreDomain> implements CuadreUseCase {

    private final CuadreUseCase cuadreUC = ContabilidadCoreModule.getInstance().getImplementation(CuadreUseCase.class);

    public CuadreRESTService() {
        setUseCase(cuadreUC);
    }

    @Override
    @GetMapping(ModuleGestionContabilidadEmpresarialConstants.PATH_FIND_ALL_PENDING)
    public List<CuadreDomain> findAllPending() throws Exception {
        return cuadreUC.findAllPending();
    }

    @Override
    @GetMapping(ModuleGestionContabilidadEmpresarialConstants.PATH_FIND_ALL_LIQUIDADAS)
    public List<CuadreDomain> findAllLiquidadas() throws Exception {
        return cuadreUC.findAllLiquidadas();
    }

    @Override
    @GetMapping(ModuleGestionContabilidadEmpresarialConstants.PATH_FIND_BY_LIQUIDADA)
    public List<CuadreDomain> findByLiquidada(boolean bln) throws Exception {
        return cuadreUC.findByLiquidada(bln);
    }

}
