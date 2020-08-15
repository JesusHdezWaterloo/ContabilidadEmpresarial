/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.repo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "cuadre", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"operacion_contable_fk", "operacion_contable_cuadre_fk"})})
@NamedQueries({
    @NamedQuery(name = "Cuadre.findAll", query = "SELECT c FROM Cuadre c"),
    @NamedQuery(name = "Cuadre.findByIdCuadre", query = "SELECT c FROM Cuadre c WHERE c.idCuadre = :idCuadre"),
    @NamedQuery(name = "Cuadre.findByLiquidada", query = "SELECT c FROM Cuadre c WHERE c.liquidada = :liquidada"),
    @NamedQuery(name = "Cuadre.findByDescripcion", query = "SELECT c FROM Cuadre c WHERE c.descripcion = :descripcion")})
public class Cuadre implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cuadre", nullable = false)
    private Integer idCuadre;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "liquidada", nullable = false)
    private boolean liquidada;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    
    @JoinColumn(name = "operacion_contable_cuadre_fk", referencedColumnName = "id_operacion_contable", nullable = false)
    @ManyToOne(optional = false)
    private OperacionContable operacionContableCuadreFk;
    
    @JoinColumn(name = "operacion_contable_fk", referencedColumnName = "id_operacion_contable", nullable = false)
    @ManyToOne(optional = false)
    private OperacionContable operacionContableFk;

    public Cuadre() {
    }

    public Cuadre(Integer idCuadre) {
        this.idCuadre = idCuadre;
    }

    public Cuadre(Integer idCuadre, boolean liquidada, String descripcion) {
        this.idCuadre = idCuadre;
        this.liquidada = liquidada;
        this.descripcion = descripcion;
    }

    public Integer getIdCuadre() {
        return idCuadre;
    }

    public void setIdCuadre(Integer idCuadre) {
        this.idCuadre = idCuadre;
    }

    public boolean getLiquidada() {
        return liquidada;
    }

    public void setLiquidada(boolean liquidada) {
        this.liquidada = liquidada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public OperacionContable getOperacionContableCuadreFk() {
        return operacionContableCuadreFk;
    }

    public void setOperacionContableCuadreFk(OperacionContable operacionContableCuadreFk) {
        this.operacionContableCuadreFk = operacionContableCuadreFk;
    }

    public OperacionContable getOperacionContableFk() {
        return operacionContableFk;
    }

    public void setOperacionContableFk(OperacionContable operacionContableFk) {
        this.operacionContableFk = operacionContableFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuadre != null ? idCuadre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuadre)) {
            return false;
        }
        Cuadre other = (Cuadre) object;
        if ((this.idCuadre == null && other.idCuadre != null) || (this.idCuadre != null && !this.idCuadre.equals(other.idCuadre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.contabilidad_empresarial.Cuadre[ idCuadre=" + idCuadre + " ]";
    }
    
}
