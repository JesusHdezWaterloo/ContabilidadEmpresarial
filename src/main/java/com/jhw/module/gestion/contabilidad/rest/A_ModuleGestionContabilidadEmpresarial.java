/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.rest;

import com.jhw.module.gestion.contabilidad.core.module.ContabilidadCoreModule;
import com.jhw.module.gestion.contabilidad.repo.module.ContabilidadRepoModule;
import com.jhw.module.gestion.contabilidad.service.ResourceServiceImplementation;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Component
public class A_ModuleGestionContabilidadEmpresarial {

    public static final String BASE_PACKAGE = "com.jhw.example.spring_a";

    static {
        ResourceServiceImplementation.init();
        ContabilidadCoreModule.init(ContabilidadRepoModule.init());
    }
}
