/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.rest;

import com.jhw.module.gestion.contabilidad.core.ModuleGestionContabilidadEmpresarialConstants;
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
@RequestMapping(value = ModuleGestionContabilidadEmpresarialConstants.CUADRE_GENERAL_PATH)
public class CuentaBancariaRESTService extends RESTServiceTemplate<CuentaBancariaDomain> implements CuentaBancariaUseCase {

    private final CuentaBancariaUseCase cuentaBancariaUC = A_ModuleGestionContabilidadEmpresarial.cuentaBancariaUC;

    public CuentaBancariaRESTService() {
        setUseCase(cuentaBancariaUC);
    }
/*
    @Override
    @GetMapping(ModuleGestionContabilidadEmpresarialConstants.CUADRE_FIND_BY_LIQUIDADA_PATH)
    public List<CuadreDomain> findByLiquidada(boolean bln) throws Exception {
        return cuadreUC.findByLiquidada(bln);
    }
*/
    @Override
    public List<Cuenta> findAllCuentas() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CuentaBancariaDomain findCuentaDefault(MonedaDomain moneda) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CuentaBancariaDomain> findAll(String searchText) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
