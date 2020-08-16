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

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "operacion_contable")
@NamedQueries({
    @NamedQuery(name = "OperacionContable.findAll", query = "SELECT o FROM OperacionContable o"),
    @NamedQuery(name = "OperacionContable.findByIdOperacionContable", query = "SELECT o FROM OperacionContable o WHERE o.idOperacionContable = :idOperacionContable"),
    @NamedQuery(name = "OperacionContable.findByDebito", query = "SELECT o FROM OperacionContable o WHERE o.debito = :debito"),
    @NamedQuery(name = "OperacionContable.findByCredito", query = "SELECT o FROM OperacionContable o WHERE o.credito = :credito")})
public class OperacionContable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operacion_contable", nullable = false)
    private Integer idOperacionContable;

    @Basic(optional = false)
    @NotNull
    @Column(name = "debito", nullable = false)
    private double debito;

    @Basic(optional = false)
    @NotNull
    @Column(name = "credito", nullable = false)
    private double credito;

    @JoinColumn(name = "cuenta_fk", referencedColumnName = "id_cuenta_contable", nullable = false)
    @ManyToOne(optional = false)
    private CuentaContable cuentaFk;

    @JoinColumn(name = "info_operacion_contable_fk", referencedColumnName = "id_info_operacion_contable", nullable = false)
    @ManyToOne(optional = false)
    private InfoOperacionContable infoOperacionContableFk;

    public OperacionContable() {
    }

    public OperacionContable(Integer idOperacionContable) {
        this.idOperacionContable = idOperacionContable;
    }

    public OperacionContable(Integer idOperacionContable, double debito, double credito) {
        this.idOperacionContable = idOperacionContable;
        this.debito = debito;
        this.credito = credito;
    }

    public Integer getIdOperacionContable() {
        return idOperacionContable;
    }

    public void setIdOperacionContable(Integer idOperacionContable) {
        this.idOperacionContable = idOperacionContable;
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

    public CuentaContable getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(CuentaContable cuentaFk) {
        this.cuentaFk = cuentaFk;
    }

    public InfoOperacionContable getInfoOperacionContableFk() {
        return infoOperacionContableFk;
    }

    public void setInfoOperacionContableFk(InfoOperacionContable infoOperacionContableFk) {
        this.infoOperacionContableFk = infoOperacionContableFk;
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
        return "testJPA.entities.contabilidad_empresarial.OperacionContable[ idOperacionContable=" + idOperacionContable + " ]";
    }

}
