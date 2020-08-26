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
@Table(name = "tipo_operacion_contable", schema = ResourcesContabilidad.SCHEMA,
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"nombre_operacion"}),
            @UniqueConstraint(columnNames = {"key_enum"})})
@NamedQueries({
    @NamedQuery(name = "TipoOperacionContable.findAll", query = "SELECT t FROM TipoOperacionContable t"),
    @NamedQuery(name = "TipoOperacionContable.findByIdTipoOperacion", query = "SELECT t FROM TipoOperacionContable t WHERE t.idTipoOperacion = :idTipoOperacion"),
    @NamedQuery(name = "TipoOperacionContable.findByNombreOperacion", query = "SELECT t FROM TipoOperacionContable t WHERE t.nombreOperacion = :nombreOperacion"),
    @NamedQuery(name = "TipoOperacionContable.findByKeyEnum", query = "SELECT t FROM TipoOperacionContable t WHERE t.keyEnum = :keyEnum"),
    @NamedQuery(name = "TipoOperacionContable.findByDescripcion", query = "SELECT t FROM TipoOperacionContable t WHERE t.descripcion = :descripcion")})
public class TipoOperacionContable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_operacion", nullable = false)
    private Integer idTipoOperacion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_operacion", nullable = false, length = 100)
    private String nombreOperacion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "key_enum", nullable = false, length = 100)
    private String keyEnum;

    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 500)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @JoinColumn(name = "tipo_cuenta_cuadre_defecto_fk", referencedColumnName = "id_tipo_cuenta", nullable = false)
    @ManyToOne(optional = false)
    private TipoCuenta tipoCuentaCuadreDefectoFk;

    @JoinColumn(name = "tipo_cuenta_defecto_fk", referencedColumnName = "id_tipo_cuenta", nullable = false)
    @ManyToOne(optional = false)
    private TipoCuenta tipoCuentaDefectoFk;

    public TipoOperacionContable() {
    }

    public TipoOperacionContable(Integer idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public TipoOperacionContable(Integer idTipoOperacion, String nombreOperacion, String keyEnum, String descripcion, TipoCuenta tipoCuentaCuadreDefectoFk, TipoCuenta tipoCuentaDefectoFk) {
        this.idTipoOperacion = idTipoOperacion;
        this.nombreOperacion = nombreOperacion;
        this.keyEnum = keyEnum;
        this.descripcion = descripcion;
        this.tipoCuentaCuadreDefectoFk = tipoCuentaCuadreDefectoFk;
        this.tipoCuentaDefectoFk = tipoCuentaDefectoFk;
    }

    public Integer getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(Integer idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public TipoCuenta getTipoCuentaCuadreDefectoFk() {
        return tipoCuentaCuadreDefectoFk;
    }

    public void setTipoCuentaCuadreDefectoFk(TipoCuenta tipoCuentaCuadreDefectoFk) {
        this.tipoCuentaCuadreDefectoFk = tipoCuentaCuadreDefectoFk;
    }

    public TipoCuenta getTipoCuentaDefectoFk() {
        return tipoCuentaDefectoFk;
    }

    public void setTipoCuentaDefectoFk(TipoCuenta tipoCuentaDefectoFk) {
        this.tipoCuentaDefectoFk = tipoCuentaDefectoFk;
    }

    public String getNombreOperacion() {
        return nombreOperacion;
    }

    public void setNombreOperacion(String nombreOperacion) {
        this.nombreOperacion = nombreOperacion;
    }

    public String getKeyEnum() {
        return keyEnum;
    }

    public void setKeyEnum(String keyEnum) {
        this.keyEnum = keyEnum;
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
        hash += (idTipoOperacion != null ? idTipoOperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoOperacionContable)) {
            return false;
        }
        TipoOperacionContable other = (TipoOperacionContable) object;
        if ((this.idTipoOperacion == null && other.idTipoOperacion != null) || (this.idTipoOperacion != null && !this.idTipoOperacion.equals(other.idTipoOperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "testJPA.entities.contabilidad_empresarial.TipoOperacionContable[ idTipoOperacion=" + idTipoOperacion + " ]";
    }

}
