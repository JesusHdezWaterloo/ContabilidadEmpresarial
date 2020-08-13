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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "operacion_bancaria")
@NamedQueries({
    @NamedQuery(name = "OperacionBancaria.findAll", query = "SELECT o FROM OperacionBancaria o"),
    @NamedQuery(name = "OperacionBancaria.findByIdOperacionBancaria", query = "SELECT o FROM OperacionBancaria o WHERE o.idOperacionBancaria = :idOperacionBancaria"),
    @NamedQuery(name = "OperacionBancaria.findByDocumento", query = "SELECT o FROM OperacionBancaria o WHERE o.documento = :documento"),
    @NamedQuery(name = "OperacionBancaria.findByNombre", query = "SELECT o FROM OperacionBancaria o WHERE o.nombre = :nombre"),
    @NamedQuery(name = "OperacionBancaria.findByDebito", query = "SELECT o FROM OperacionBancaria o WHERE o.debito = :debito"),
    @NamedQuery(name = "OperacionBancaria.findByCredito", query = "SELECT o FROM OperacionBancaria o WHERE o.credito = :credito"),
    @NamedQuery(name = "OperacionBancaria.findByDescripcion", query = "SELECT o FROM OperacionBancaria o WHERE o.descripcion = :descripcion")})
public class OperacionBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion_bancaria", nullable = false)
    private Integer idOperacionBancaria;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "documento", nullable = false, length = 100)
    private String documento;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "debito", nullable = false)
    private double debito;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "credito", nullable = false)
    private double credito;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    
    @JoinColumn(name = "cuenta_fk", referencedColumnName = "id_cuenta_bancaria", nullable = false)
    @ManyToOne(optional = false)
    private CuentaBancaria cuentaFk;
    
    @JoinColumn(name = "operacion_contable_fk", referencedColumnName = "id_operacion_contable", nullable = false)
    @ManyToOne(optional = false)
    private OperacionContable operacionContableFk;

    public OperacionBancaria() {
    }

    public OperacionBancaria(Integer idOperacionBancaria) {
        this.idOperacionBancaria = idOperacionBancaria;
    }

    public OperacionBancaria(Integer idOperacionBancaria, String documento, String nombre, double debito, double credito, String descripcion) {
        this.idOperacionBancaria = idOperacionBancaria;
        this.documento = documento;
        this.nombre = nombre;
        this.debito = debito;
        this.credito = credito;
        this.descripcion = descripcion;
    }

    public Integer getIdOperacionBancaria() {
        return idOperacionBancaria;
    }

    public void setIdOperacionBancaria(Integer idOperacionBancaria) {
        this.idOperacionBancaria = idOperacionBancaria;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDebito() {
        return debito;
    }

    public void setDebito(double debito) {
        this.debito = debito;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CuentaBancaria getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(CuentaBancaria cuentaFk) {
        this.cuentaFk = cuentaFk;
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
        hash += (idOperacionBancaria != null ? idOperacionBancaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperacionBancaria)) {
            return false;
        }
        OperacionBancaria other = (OperacionBancaria) object;
        if ((this.idOperacionBancaria == null && other.idOperacionBancaria != null) || (this.idOperacionBancaria != null && !this.idOperacionBancaria.equals(other.idOperacionBancaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhw.gestion.modules.contabilidad.repo.entities.OperacionBancaria[ idOperacionBancaria=" + idOperacionBancaria + " ]";
    }
    
}
