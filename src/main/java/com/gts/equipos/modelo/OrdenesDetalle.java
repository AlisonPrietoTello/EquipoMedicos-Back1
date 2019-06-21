/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.modelo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laszlo
 */
@Entity
@Table(name = "ordenes_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDetalle.findAll", query = "SELECT o FROM OrdenesDetalle o")})
public class OrdenesDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ordenes_detalle")
    private Integer idOrdenesDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_servicio")
    private int tipoServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calibracion")
    private int calibracion;
    @Column(name = "fecha_programada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaProgramada;
    @Column(name = "fk_responsable")
    private Integer fkResponsable;
    @Column(name = "fecha_realizada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRealizada;
    @Size(max = 45)
    @Column(name = "numero_reporte")
    private String numeroReporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_reporte")
    private int estadoReporte;
    @JoinColumn(name = "fk_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes fkCliente;
    @JoinColumn(name = "fk_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa fkEmpresa;
    @JoinColumn(name = "fk_equipos", referencedColumnName = "id_equipos")
    @ManyToOne(optional = false)
    private Equipos fkEquipos;
    @JoinColumn(name = "fk_ordenes", referencedColumnName = "id_ordenes")
    @ManyToOne(optional = false)
    private Ordenes fkOrdenes;

    public OrdenesDetalle() {
    }

    public OrdenesDetalle(Integer idOrdenesDetalle) {
        this.idOrdenesDetalle = idOrdenesDetalle;
    }

    public OrdenesDetalle(Integer idOrdenesDetalle, int tipoServicio, int calibracion, int estadoReporte) {
        this.idOrdenesDetalle = idOrdenesDetalle;
        this.tipoServicio = tipoServicio;
        this.calibracion = calibracion;
        this.estadoReporte = estadoReporte;
    }

    public Integer getIdOrdenesDetalle() {
        return idOrdenesDetalle;
    }

    public void setIdOrdenesDetalle(Integer idOrdenesDetalle) {
        this.idOrdenesDetalle = idOrdenesDetalle;
    }

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getCalibracion() {
        return calibracion;
    }

    public void setCalibracion(int calibracion) {
        this.calibracion = calibracion;
    }

    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public Integer getFkResponsable() {
        return fkResponsable;
    }

    public void setFkResponsable(Integer fkResponsable) {
        this.fkResponsable = fkResponsable;
    }

    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    public void setFechaRealizada(Date fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    public String getNumeroReporte() {
        return numeroReporte;
    }

    public void setNumeroReporte(String numeroReporte) {
        this.numeroReporte = numeroReporte;
    }

    public int getEstadoReporte() {
        return estadoReporte;
    }

    public void setEstadoReporte(int estadoReporte) {
        this.estadoReporte = estadoReporte;
    }

    public Clientes getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Clientes fkCliente) {
        this.fkCliente = fkCliente;
    }

    public Empresa getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Empresa fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Equipos getFkEquipos() {
        return fkEquipos;
    }

    public void setFkEquipos(Equipos fkEquipos) {
        this.fkEquipos = fkEquipos;
    }

    public Ordenes getFkOrdenes() {
        return fkOrdenes;
    }

    public void setFkOrdenes(Ordenes fkOrdenes) {
        this.fkOrdenes = fkOrdenes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenesDetalle != null ? idOrdenesDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDetalle)) {
            return false;
        }
        OrdenesDetalle other = (OrdenesDetalle) object;
        if ((this.idOrdenesDetalle == null && other.idOrdenesDetalle != null) || (this.idOrdenesDetalle != null && !this.idOrdenesDetalle.equals(other.idOrdenesDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gts.equipos.modelo.OrdenesDetalle[ idOrdenesDetalle=" + idOrdenesDetalle + " ]";
    }
    
}
