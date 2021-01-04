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

import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class A_ModuleGestionContabilidadConstants {

    public static final String CONTABILIDAD_GENERAL_PATH = "/contabilidad";

    public static final String SEARCH_TEXT = "search";
    public static final String LIQUIDADA = "liquidada";
    public static final String CUENTA = "cuenta";
    public static final String CUADRE = "cuadre";
    public static final String MONEDA = "moneda";
    public static final String TIPO_CUENTA = "tipo_cuenta";

    //-----------------------CUADRE-----------------------\\
    public static final String CUADRE_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/cuadre";

    public static final String CUADRE_FIND_ALL_PENDING_PATH = "/find_all_pending";
    public static final RequestMethod CUADRE_FIND_ALL_PENDING_METHOD = RequestMethod.GET;

    public static final String CUADRE_FIND_ALL_LIQUIDADAS_PATH = "/find_all_liquidadas";
    public static final RequestMethod CUADRE_FIND_ALL_LIQUIDADAS_METHOD = RequestMethod.GET;

    public static final String CUADRE_FIND_BY_LIQUIDADA_PATH = "/find_by_liquidada/{" + LIQUIDADA + "}";
    public static final RequestMethod CUADRE_FIND_BY_LIQUIDADA_METHOD = RequestMethod.GET;

    //-----------------------CUENTA BANCARIA-----------------------\\
    public static final String CUENTA_BANCARIA_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/cuenta_bancaria";

    public static final String CUENTA_BANCARIA_FIND_ALL_CUENTAS_PATH = "/find_all_cuentas";
    public static final RequestMethod CUENTA_BANCARIA_FIND_ALL_CUENTAS_METHOD = RequestMethod.GET;

    public static final String CUENTA_BANCARIA_FIND_DEFAULT_PATH = "/find_default/{" + MONEDA + "}";
    public static final RequestMethod CUENTA_BANCARIA_FIND_DEFAULT_METHOD = RequestMethod.GET;

    public static final String CUENTA_BANCARIA_FIND_ALL_SEARCH_PATH = "/find_all/{" + SEARCH_TEXT + "}";
    public static final RequestMethod CUENTA_BANCARIA_FIND_ALL_SEARCH_METHOD = RequestMethod.GET;

    //-----------------------CUENTA CONTABLE-----------------------\\
    public static final String CUENTA_CONTABLE_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/cuenta_contable";

    public static final String CUENTA_CONTABLE_FIND_ALL_CUENTAS_PATH = "/find_all_cuentas";
    public static final RequestMethod CUENTA_CONTABLE_FIND_ALL_CUENTAS_METHOD = RequestMethod.GET;

    public static final String CUENTA_CONTABLE_FIND_ALL_PATH = "/find_all_cuentas/{" + TIPO_CUENTA + "}";
    public static final RequestMethod CUENTA_CONTABLE_FIND_ALL_METHOD = RequestMethod.GET;

    public static final String CUENTA_CONTABLE_FIND_ALL_SEARCH_PATH = "/find_all/{" + SEARCH_TEXT + "}";
    public static final RequestMethod CUENTA_CONTABLE_FIND_ALL_SEARCH_METHOD = RequestMethod.GET;

    //-----------------------DEFAULT PAGABLE-----------------------\\
    public static final String DEFAULT_PAGABLE_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/default_pagable";

    //-----------------------FORMA PAGO-----------------------\\
    public static final String FORMA_PAGO_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/forma_pago";

    //-----------------------INFO OP CONTABLE-----------------------\\
    public static final String INFO_OP_CONTABLE_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/info_op_contable";

    //-----------------------LIQUIDACION-----------------------\\
    public static final String LIQUIDACION_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/liquidacion";

    public static final String LIQUIDACION_FIND_ALL_PATH = "/find_all/{" + CUENTA + "}";
    public static final RequestMethod LIQUIDACION_FIND_ALL_METHOD = RequestMethod.GET;

    public static final String LIQUIDACION_GET_PATH = "/get_liquidacion/{" + CUADRE + "}";
    public static final RequestMethod LIQUIDACION_GET_METHOD = RequestMethod.GET;

    //-----------------------MONEDA-----------------------\\
    public static final String MONEDA_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/moneda";

    public static final String MONEDA_FIND_BASE_PATH = "/find_base";
    public static final RequestMethod MONEDA_FIND_BASE_METHOD = RequestMethod.GET;

    //-----------------------OPERACION CONTABLE-----------------------\\
    public static final String OPERACION_CONTABLE_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/operacion_contable";

    public static final String OPERACION_CONTABLE_FIND_ALL_PATH = "/find_all/{" + CUENTA + "}";
    public static final RequestMethod OPERACION_CONTABLE_FIND_ALL_METHOD = RequestMethod.GET;

    //-----------------------SUBCUENTA-----------------------\\
    public static final String SUBCUENTA_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/subcuenta";

    //-----------------------TIPO CUENTA-----------------------\\
    public static final String TIPO_CUENTA_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/tipo_cuenta";

    public static final String TIPO_CUENTA_FIND_ALL_EQUIVALENT_PATH = "/find_all_equivalent/{" + TIPO_CUENTA + "}";
    public static final RequestMethod TIPO_CUENTA_PATH_FIND_ALL_EQUIVALENT_METHOD = RequestMethod.GET;

    //-----------------------TIPO OPERACION-----------------------\\
    public static final String TIPO_OPERACION_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/tipo_operacion";
    
    //-----------------------TITULAR-----------------------\\
    public static final String TITULAR_GENERAL_PATH = CONTABILIDAD_GENERAL_PATH + "/titular";
    
}
