/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author laszlo
 */
@Entity
@Table(name = "ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenes.findAll", query = "SELECT o FROM Ordenes o")
    , @NamedQuery(name = "Ordenes.findByNumOrden", query = "SELECT o FROM Ordenes o WHERE o.numOrden = :numOrden")
    , @NamedQuery(name = "Ordenes.findByIdOrdenes", query = "SELECT o FROM Ordenes o WHERE o.idOrdenes = :idOrdenes")
    , @NamedQuery(name = "Ordenes.findByFechaOrden", query = "SELECT o FROM Ordenes o WHERE o.fechaOrden = :fechaOrden")
    , @NamedQuery(name = "Ordenes.findByHerramientas", query = "SELECT o FROM Ordenes o WHERE o.herramientas = :herramientas")
    , @NamedQuery(name = "Ordenes.findByGafasSeguridad", query = "SELECT o FROM Ordenes o WHERE o.gafasSeguridad = :gafasSeguridad")
    , @NamedQuery(name = "Ordenes.findByGuantesDesechables", query = "SELECT o FROM Ordenes o WHERE o.guantesDesechables = :guantesDesechables")
    , @NamedQuery(name = "Ordenes.findByTapaBocas", query = "SELECT o FROM Ordenes o WHERE o.tapaBocas = :tapaBocas")
    , @NamedQuery(name = "Ordenes.findByGorro", query = "SELECT o FROM Ordenes o WHERE o.gorro = :gorro")
    , @NamedQuery(name = "Ordenes.findByBata", query = "SELECT o FROM Ordenes o WHERE o.bata = :bata")
    , @NamedQuery(name = "Ordenes.findByRiesgos", query = "SELECT o FROM Ordenes o WHERE o.riesgos = :riesgos")
    , @NamedQuery(name = "Ordenes.findByComentarios", query = "SELECT o FROM Ordenes o WHERE o.comentarios = :comentarios")
    , @NamedQuery(name = "Ordenes.findByEsatdoOrden", query = "SELECT o FROM Ordenes o WHERE o.esatdoOrden = :esatdoOrden")})
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkOrdenes")
    private Collection<OrdenesDetalle> ordenesDetalleCollection;

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

    @XmlTransient
    public Collection<OrdenesDetalle> getOrdenesDetalleCollection() {
        return ordenesDetalleCollection;
    }

    public void setOrdenesDetalleCollection(Collection<OrdenesDetalle> ordenesDetalleCollection) {
        this.ordenesDetalleCollection = ordenesDetalleCollection;
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
