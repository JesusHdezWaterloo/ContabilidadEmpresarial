/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.repo.entities;

import com.jhw.module.gestion.contabilidad.repo.utils.ResourcesContabilidad;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Entity
@Table(name = "info_operacion_contable", schema = ResourcesContabilidad.SCHEMA)
@NamedQueries({
    @NamedQuery(name = "InfoOperacionContable.findAll", query = "SELECT i FROM InfoOperacionContable i"),
    @NamedQuery(name = "InfoOperacionContable.findByIdInfoOperacionContable", query = "SELECT i FROM InfoOperacionContable i WHERE i.idInfoOperacionContable = :idInfoOperacionContable"),
    @NamedQuery(name = "InfoOperacionContable.findByDocumento", query = "SELECT i FROM InfoOperacionContable i WHERE i.documento = :documento"),
    @NamedQuery(name = "InfoOperacionContable.findByNombre", query = "SELECT i FROM InfoOperacionContable i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "InfoOperacionContable.findByFecha", query = "SELECT i FROM InfoOperacionContable i WHERE i.fecha = :fecha"),
    @NamedQuery(name = "InfoOperacionContable.findByDescripcion", query = "SELECT i FROM InfoOperacionContable i WHERE i.descripcion = :descripcion"),})
public class InfoOperacionContable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_info_operacion_contable", nullable = false)
    private Integer idInfoOperacionContable;

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
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @JoinColumn(name = "tipo_operacion_fk", referencedColumnName = "id_tipo_operacion", nullable = false)
    @ManyToOne(optional = false)
    private TipoOperacionContable tipoOperacionFk;

    @JoinColumn(name = "forma_pago_fk", referencedColumnName = "id_forma_pago", nullable = false)
    @ManyToOne(optional = false)
    private FormaPago formaPagoFk;

    public InfoOperacionContable() {
    }

    public InfoOperacionContable(Integer idInfoOperacionContable) {
        this.idInfoOperacionContable = idInfoOperacionContable;
    }

    public InfoOperacionContable(Integer idInfoOperacionContable, String documento, String nombre, Date fecha, String descripcion) {
        this.idInfoOperacionContable = idInfoOperacionContable;
        this.documento = documento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Integer getIdInfoOperacionContable() {
        return idInfoOperacionContable;
    }

    public void setIdInfoOperacionContable(Integer idInfoOperacionContable) {
        this.idInfoOperacionContable = idInfoOperacionContable;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FormaPago getFormaPagoFk() {
        return formaPagoFk;
    }

    public void setFormaPagoFk(FormaPago formaPagoFk) {
        this.formaPagoFk = formaPagoFk;
    }

    public TipoOperacionContable getTipoOperacionFk() {
        return tipoOperacionFk;
    }

    public void setTipoOperacionFk(TipoOperacionContable tipoOperacionFk) {
        this.tipoOperacionFk = tipoOperacionFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfoOperacionContable != null ? idInfoOperacionContable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoOperacionContable)) {
            return false;
        }
        InfoOperacionContable other = (InfoOperacionContable) object;
        if ((this.idInfoOperacionContable == null && other.idInfoOperacionContable != null) || (this.idInfoOperacionContable != null && !this.idInfoOperacionContable.equals(other.idInfoOperacionContable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.contabilidad_empresarial.InfoOperacionContable[ idInfoOperacionContable=" + idInfoOperacionContable + " ]";
    }

}
