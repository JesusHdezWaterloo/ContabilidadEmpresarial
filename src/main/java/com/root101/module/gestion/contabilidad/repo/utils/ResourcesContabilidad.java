/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.module.gestion.contabilidad.repo.utils;

import com.root101.clean.core.app.services.ExceptionHandler;
import com.jhw.module.util.mysql.services.MySQLHandler;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ResourcesContabilidad {

    public static final String SCHEMA = "sigecon_contabilidad";
    
    public static EntityManagerFactory EMF;

    public static void initEMF() {
        try {
            EMF = Persistence.createEntityManagerFactory("ContabilidadPU", MySQLHandler.propertiesMap(SCHEMA));
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
}
