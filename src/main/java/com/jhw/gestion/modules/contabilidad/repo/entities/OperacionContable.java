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
@Table(name = "operacion_contable")
@NamedQueries({
    @NamedQuery(name = "OperacionContable.findAll", query = "SELECT o FROM OperacionContable o"),
    @NamedQuery(name = "OperacionContable.findByIdOperacionContable", query = "SELECT o FROM OperacionContable o WHERE o.idOperacionContable = :idOperacionContable"),
    @NamedQuery(name = "OperacionContable.findByDocumento", query = "SELECT o FROM OperacionContable o WHERE o.documento = :documento"),
    @NamedQuery(name = "OperacionContable.findByNombre", query = "SELECT o FROM OperacionContable o WHERE o.nombre = :nombre"),
    @NamedQuery(name = "OperacionContable.findByDebito", query = "SELECT o FROM OperacionContable o WHERE o.debito = :debito"),
    @NamedQuery(name = "OperacionContable.findByCredito", query = "SELECT o FROM OperacionContable o WHERE o.credito = :credito"),
    @NamedQuery(name = "OperacionContable.findByDescripcion", query = "SELECT o FROM OperacionContable o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "OperacionContable.findByIdExterno", query = "SELECT o FROM OperacionContable o WHERE o.idExterno = :idExterno")})
public class OperacionContable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion_contable", nullable = false)
    private Integer idOperacionContable;
    
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
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_externo", nullable = false)
    private int idExterno;
    
    @JoinColumn(name = "cuenta_fk", referencedColumnName = "id_cuenta_contable", nullable = false)
    @ManyToOne(optional = false)
    private CuentaContable cuentaFk;
    
    @JoinColumn(name = "tipo_operacion_contable_fk", referencedColumnName = "id_tipo_operacion", nullable = false)
    @ManyToOne(optional = false)
    private TipoOperacionContable tipoOperacionContableFk;
    
    public OperacionContable() {
    }

    public OperacionContable(Integer idOperacionContable) {
        this.idOperacionContable = idOperacionContable;
    }

    public OperacionContable(Integer idOperacionContable, String documento, String nombre, double debito, double credito, String descripcion, int idExterno) {
        this.idOperacionContable = idOperacionContable;
        this.documento = documento;
        this.nombre = nombre;
        this.debito = debito;
        this.credito = credito;
        this.descripcion = descripcion;
        this.idExterno = idExterno;
    }

    public Integer getIdOperacionContable() {
        return idOperacionContable;
    }

    public void setIdOperacionContable(Integer idOperacionContable) {
        this.idOperacionContable = idOperacionContable;
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

    public int getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(int idExterno) {
        this.idExterno = idExterno;
    }

    public CuentaContable getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(CuentaContable cuentaFk) {
        this.cuentaFk = cuentaFk;
    }

    public TipoOperacionContable getTipoOperacionContableFk() {
        return tipoOperacionContableFk;
    }

    public void setTipoOperacionContableFk(TipoOperacionContable tipoOperacionContableFk) {
        this.tipoOperacionContableFk = tipoOperacionContableFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperacionContable != null ? idOperacionContable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperacionContable)) {
            return false;
        }
        OperacionContable other = (OperacionContable) object;
        if ((this.idOperacionContable == null && other.idOperacionContable != null) || (this.idOperacionContable != null && !this.idOperacionContable.equals(other.idOperacionContable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhw.gestion.modules.contabilidad.repo.entities.OperacionContable[ idOperacionContable=" + idOperacionContable + " ]";
    }
    
}
