/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laszlo
 */
@Entity
@Table(name = "cotizacion_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CotizacionDetalle.findAll", query = "SELECT c FROM CotizacionDetalle c")
    , @NamedQuery(name = "CotizacionDetalle.findByIdCotizDeta", query = "SELECT c FROM CotizacionDetalle c WHERE c.idCotizDeta = :idCotizDeta")
    , @NamedQuery(name = "CotizacionDetalle.findByTipoServicio", query = "SELECT c FROM CotizacionDetalle c WHERE c.tipoServicio = :tipoServicio")
    , @NamedQuery(name = "CotizacionDetalle.findByCantidad", query = "SELECT c FROM CotizacionDetalle c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "CotizacionDetalle.findByValorUnitario", query = "SELECT c FROM CotizacionDetalle c WHERE c.valorUnitario = :valorUnitario")
    , @NamedQuery(name = "CotizacionDetalle.findByEstado", query = "SELECT c FROM CotizacionDetalle c WHERE c.estado = :estado")
    , @NamedQuery(name = "CotizacionDetalle.findByOrden", query = "SELECT c FROM CotizacionDetalle c WHERE c.orden = :orden")
    , @NamedQuery(name = "CotizacionDetalle.findByServicio", query = "SELECT c FROM CotizacionDetalle c WHERE c.servicio = :servicio")})
public class CotizacionDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cotiz_deta")
    private Integer idCotizDeta;
    @Column(name = "tipo_servicio")
    private Integer tipoServicio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "orden")
    private String orden;
    @Size(max = 45)
    @Column(name = "servicio")
    private String servicio;
    @JoinColumn(name = "fk_cotiz_encab", referencedColumnName = "id_cotiz_encab")
    @ManyToOne
    private Cotizacion fkCotizEncab;
    @JoinColumn(name = "fk_equipos", referencedColumnName = "id_equipos")
    @ManyToOne
    private Equipos fkEquipos;

    public CotizacionDetalle() {
    }

    public CotizacionDetalle(Integer idCotizDeta) {
        this.idCotizDeta = idCotizDeta;
    }

    public Integer getIdCotizDeta() {
        return idCotizDeta;
    }

    public void setIdCotizDeta(Integer idCotizDeta) {
        this.idCotizDeta = idCotizDeta;
    }

    public Integer getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(Integer tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Cotizacion getFkCotizEncab() {
        return fkCotizEncab;
    }

    public void setFkCotizEncab(Cotizacion fkCotizEncab) {
        this.fkCotizEncab = fkCotizEncab;
    }

    public Equipos getFkEquipos() {
        return fkEquipos;
    }

    public void setFkEquipos(Equipos fkEquipos) {
        this.fkEquipos = fkEquipos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotizDeta != null ? idCotizDeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotizacionDetalle)) {
            return false;
        }
        CotizacionDetalle other = (CotizacionDetalle) object;
        if ((this.idCotizDeta == null && other.idCotizDeta != null) || (this.idCotizDeta != null && !this.idCotizDeta.equals(other.idCotizDeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gts.equipos.modelo.CotizacionDetalle[ idCotizDeta=" + idCotizDeta + " ]";
    }
    
}
