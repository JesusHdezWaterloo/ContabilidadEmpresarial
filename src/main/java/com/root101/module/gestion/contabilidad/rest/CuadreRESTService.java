/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.gestion.contabilidad.rest;

import com.root101.spring.server.RESTServiceTemplate;
import static com.root101.module.gestion.contabilidad.rest.ModuleGestionContabilidadRESTConstants.*;
import com.root101.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.root101.module.gestion.contabilidad.core.usecase_def.CuadreUseCase;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@RestController
@RequestMapping(value = CUADRE_GENERAL_PATH)
public class CuadreRESTService extends RESTServiceTemplate<CuadreDomain> implements CuadreUseCase {

    private final CuadreUseCase cuadreUC = A_ModuleGestionContabilidadRESTConfig.cuadreUC;

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
