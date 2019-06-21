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
@Table(name = "ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenes.findAll", query = "SELECT o FROM Ordenes o")})
public class Ordenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "num_orden")
    private String numOrden;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ordenes")
    private Integer idOrdenes;
    @Column(name = "fecha_orden")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOrden;
    @Size(max = 150)
    @Column(name = "herramientas")
    private String herramientas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gafas_seguridad")
    private int gafasSeguridad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "guantes_desechables")
    private int guantesDesechables;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tapa_bocas")
    private int tapaBocas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gorro")
    private int gorro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bata")
    private int bata;
    @Size(max = 150)
    @Column(name = "riesgos")
    private String riesgos;
    @Size(max = 150)
    @Column(name = "comentarios")
    private String comentarios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esatdo_orden")
    private int esatdoOrden;
    
    @JoinColumn(name = "fk_cotizacion", referencedColumnName = "id_cotiz_encab")
    @ManyToOne(optional = false)
    private Cotizacion fkCotizacion;
    @JoinColumn(name = "fk_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa fkEmpresa;

    public Ordenes() {
    }

    public Ordenes(Integer idOrdenes) {
        this.idOrdenes = idOrdenes;
    }

    public Ordenes(Integer idOrdenes, String numOrden, int gafasSeguridad, int guantesDesechables, int tapaBocas, int gorro, int bata, int esatdoOrden) {
        this.idOrdenes = idOrdenes;
        this.numOrden = numOrden;
        this.gafasSeguridad = gafasSeguridad;
        this.guantesDesechables = guantesDesechables;
        this.tapaBocas = tapaBocas;
        this.gorro = gorro;
        this.bata = bata;
        this.esatdoOrden = esatdoOrden;
    }

    public String getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(String numOrden) {
        this.numOrden = numOrden;
    }

    public Integer getIdOrdenes() {
        return idOrdenes;
    }

    public void setIdOrdenes(Integer idOrdenes) {
        this.idOrdenes = idOrdenes;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(String herramientas) {
        this.herramientas = herramientas;
    }

    public int getGafasSeguridad() {
        return gafasSeguridad;
    }

    public void setGafasSeguridad(int gafasSeguridad) {
        this.gafasSeguridad = gafasSeguridad;
    }

    public int getGuantesDesechables() {
        return guantesDesechables;
    }

    public void setGuantesDesechables(int guantesDesechables) {
        this.guantesDesechables = guantesDesechables;
    }

    public int getTapaBocas() {
        return tapaBocas;
    }

    public void setTapaBocas(int tapaBocas) {
        this.tapaBocas = tapaBocas;
    }

    public int getGorro() {
        return gorro;
    }

    public void setGorro(int gorro) {
        this.gorro = gorro;
    }

    public int getBata() {
        return bata;
    }

    public void setBata(int bata) {
        this.bata = bata;
    }

    public String getRiesgos() {
        return riesgos;
    }

    public void setRiesgos(String riesgos) {
        this.riesgos = riesgos;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getEsatdoOrden() {
        return esatdoOrden;
    }

    public void setEsatdoOrden(int esatdoOrden) {
        this.esatdoOrden = esatdoOrden;
    }

    public Cotizacion getFkCotizacion() {
        return fkCotizacion;
    }

    public void setFkCotizacion(Cotizacion fkCotizacion) {
        this.fkCotizacion = fkCotizacion;
    }

    public Empresa getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Empresa fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenes != null ? idOrdenes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenes)) {
            return false;
        }
        Ordenes other = (Ordenes) object;
        if ((this.idOrdenes == null && other.idOrdenes != null) || (this.idOrdenes != null && !this.idOrdenes.equals(other.idOrdenes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gts.equipos.modelo.Ordenes[ idOrdenes=" + idOrdenes + " ]";
    }
    
}
