/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.repo.entities;

import com.jhw.gestion.modules.contabilidad.repo.utils.ResourcesContabilidad;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "forma_pago", catalog = ResourcesContabilidad.SCHEMA, schema = ResourcesContabilidad.SCHEMA,
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"nombre_forma_pago"})})
@NamedQueries({
    @NamedQuery(name = "FormaPago.findAll", query = "SELECT m FROM FormaPago m"),
    @NamedQuery(name = "FormaPago.findByIdMetodoPago", query = "SELECT m FROM FormaPago m WHERE m.idFormaPago = :idFormaPago"),
    @NamedQuery(name = "FormaPago.findByNombreMetodoPago", query = "SELECT m FROM FormaPago m WHERE m.nombreFormaPago = :nombreFormaPago"),
    @NamedQuery(name = "FormaPago.findByDescripcion", query = "SELECT m FROM FormaPago m WHERE m.descripcion = :descripcion")})
public class FormaPago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_forma_pago", nullable = false)
    private Integer idFormaPago;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_forma_pago", nullable = false, length = 100)
    private String nombreFormaPago;

    @Basic(optional = false)
    @NotNull
    @Size(max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    public FormaPago() {
    }

    public FormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public FormaPago(Integer idFormaPago, String nombreFormaPago, String descripcion) {
        this.idFormaPago = idFormaPago;
        this.nombreFormaPago = nombreFormaPago;
        this.descripcion = descripcion;
    }

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getNombreFormaPago() {
        return nombreFormaPago;
    }

    public void setNombreFormaPago(String nombreFormaPago) {
        this.nombreFormaPago = nombreFormaPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormaPago != null ? idFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.idFormaPago == null && other.idFormaPago != null) || (this.idFormaPago != null && !this.idFormaPago.equals(other.idFormaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.contabilidad_empresarial.MetodoPago[ idMetodoPago=" + idFormaPago + " ]";
    }

}
