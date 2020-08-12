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

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "deposito_cuenta")
@NamedQueries({
    @NamedQuery(name = "DepositoCuenta.findAll", query = "SELECT d FROM DepositoCuenta d"),
    @NamedQuery(name = "DepositoCuenta.findByIdDepositoCuenta", query = "SELECT d FROM DepositoCuenta d WHERE d.idDepositoCuenta = :idDepositoCuenta"),
    @NamedQuery(name = "DepositoCuenta.findByValor", query = "SELECT d FROM DepositoCuenta d WHERE d.valor = :valor"),
    @NamedQuery(name = "DepositoCuenta.findByPorciento", query = "SELECT d FROM DepositoCuenta d WHERE d.porciento = :porciento"),
    @NamedQuery(name = "DepositoCuenta.findByIdExterno", query = "SELECT d FROM DepositoCuenta d WHERE d.idExterno = :idExterno")})
public class DepositoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_deposito_cuenta", nullable = false)
    private Integer idDepositoCuenta;
    @Basic(optional = false)
    @Column(name = "valor", nullable = false)
    private float valor;
    @Basic(optional = false)
    @Column(name = "porciento", nullable = false)
    private float porciento;
    @Basic(optional = false)
    @Column(name = "id_externo", nullable = false)
    private int idExterno;
    @JoinColumn(name = "cuenta_fk", referencedColumnName = "id_cuenta", nullable = false)
    @ManyToOne(optional = false)
    private Cuenta cuentaFk;
    @JoinColumn(name = "tipo_deposito_fk", referencedColumnName = "id_tipo_deposito", nullable = false)
    @ManyToOne(optional = false)
    private TipoDeposito tipoDepositoFk;

    public DepositoCuenta() {
    }

    public DepositoCuenta(Integer idDepositoCuenta) {
        this.idDepositoCuenta = idDepositoCuenta;
    }

    public DepositoCuenta(Integer idDepositoCuenta, float valor, float porciento, int idExterno) {
        this.idDepositoCuenta = idDepositoCuenta;
        this.valor = valor;
        this.porciento = porciento;
        this.idExterno = idExterno;
    }

    public Integer getIdDepositoCuenta() {
        return idDepositoCuenta;
    }

    public void setIdDepositoCuenta(Integer idDepositoCuenta) {
        this.idDepositoCuenta = idDepositoCuenta;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getPorciento() {
        return porciento;
    }

    public void setPorciento(float porciento) {
        this.porciento = porciento;
    }

    public int getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(int idExterno) {
        this.idExterno = idExterno;
    }

    public Cuenta getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(Cuenta cuentaFk) {
        this.cuentaFk = cuentaFk;
    }

    public TipoDeposito getTipoDepositoFk() {
        return tipoDepositoFk;
    }

    public void setTipoDepositoFk(TipoDeposito tipoDepositoFk) {
        this.tipoDepositoFk = tipoDepositoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepositoCuenta != null ? idDepositoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepositoCuenta)) {
            return false;
        }
        DepositoCuenta other = (DepositoCuenta) object;
        if ((this.idDepositoCuenta == null && other.idDepositoCuenta != null) || (this.idDepositoCuenta != null && !this.idDepositoCuenta.equals(other.idDepositoCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.DepositoCuenta[ idDepositoCuenta=" + idDepositoCuenta + " ]";
    }
    
}
