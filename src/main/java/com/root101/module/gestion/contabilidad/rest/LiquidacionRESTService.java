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
@RequestMapping(value = LIQUIDACION_GENERAL_PATH)
public class LiquidacionRESTService extends RESTServiceTemplate<LiquidacionDomain> implements LiquidacionUseCase {

    private final LiquidacionUseCase liquicadionUC = A_ModuleGestionContabilidadEmpresarial.liquicadionUC;

    public LiquidacionRESTService() {
        setUseCase(liquicadionUC);
    }

    /**
     * Use findAll(@PathVariable(CUENTA) Integer IdCuentaBancaria) para
     * lightweight
     *
     * @param cuenta
     * @return
     * @throws Exception
     * @deprecated
     */
    @Override
    @Deprecated
    public List<LiquidacionDomain> findAll(CuentaBancariaDomain cuenta) throws Exception {
        return liquicadionUC.findAll(cuenta);
    }

    @Override
    @GetMapping(LIQUIDACION_FIND_ALL_PATH)
    public List<LiquidacionDomain> findAll(@PathVariable(CUENTA) Integer IdCuentaBancaria) throws Exception {
        return liquicadionUC.findAll(IdCuentaBancaria);
    }

    /**
     * Use getLiquidacion(@PathVariable(CUADRE) Integer idCuadre) para
     * lightweight
     *
     * @param cuadre
     * @return
     * @throws Exception
     */
    @Override
    @Deprecated
    public LiquidacionDomain getLiquidacion(CuadreDomain cuadre) throws Exception {
        return liquicadionUC.getLiquidacion(cuadre);
    }

    @Override
    @GetMapping(LIQUIDACION_GET_PATH)
    public LiquidacionDomain getLiquidacion(@PathVariable(CUADRE) Integer idCuadre) throws Exception {
        return liquicadionUC.getLiquidacion(idCuadre);
    }
}
