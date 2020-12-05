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
@RequestMapping(value = TIPO_CUENTA_GENERAL_PATH)
public class TipoCuentaRESTService extends RESTServiceTemplate<TipoCuentaDomain> implements TipoCuentaUseCase {

    private final TipoCuentaUseCase tipoCuentaUC = A_ModuleGestionContabilidadEmpresarial.tipoCuentaUC;

    public TipoCuentaRESTService() {
        setUseCase(tipoCuentaUC);
    }

    /**
     * Use findAllEquivalent(@PathVariable(TIPO_CUENTA) Integer idTipoCuenta)
     * para lightweight
     *
     * @param selectedItem
     * @return
     * @throws Exception
     * @deprecated
     */
    @Override
    @Deprecated
    public List<TipoCuentaDomain> findAllEquivalent(TipoCuentaDomain selectedItem) throws Exception {
        return tipoCuentaUC.findAllEquivalent(selectedItem);
    }

    @Override
    @GetMapping(TIPO_CUENTA_FIND_ALL_EQUIVALENT_PATH)
    public List<TipoCuentaDomain> findAllEquivalent(@PathVariable(TIPO_CUENTA) Integer idTipoCuenta) throws Exception {
        return tipoCuentaUC.findAllEquivalent(idTipoCuenta);
    }

}
