/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Xamir Mercado
 */
@Entity
@Table(name = "protocolos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Protocolos.findAll", query = "SELECT p FROM Protocolos p")
    , @NamedQuery(name = "Protocolos.findByIdProtocolo", query = "SELECT p FROM Protocolos p WHERE p.idProtocolo = :idProtocolo")
    , @NamedQuery(name = "Protocolos.findByCodigo", query = "SELECT p FROM Protocolos p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Protocolos.findByNombre", query = "SELECT p FROM Protocolos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Protocolos.findByDescripcion", query = "SELECT p FROM Protocolos p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Protocolos.findByRevision", query = "SELECT p FROM Protocolos p WHERE p.revision = :revision")
    , @NamedQuery(name = "Protocolos.findByResponsable", query = "SELECT p FROM Protocolos p WHERE p.responsable = :responsable")})
public class Protocolos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_protocolo")
    private Integer idProtocolo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "revision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date revision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "responsable")
    private String responsable;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProtocolo")
    private List<InstrumentosProtocolo> instrumentosProtocoloList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProtocolo")
    private List<Actividades> actividadesList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmpresa")
    private List<Protocolos> protocolosList;
    @JsonIgnore
    @JoinColumn(name = "fk_empresa", referencedColumnName = "id_protocolo")
    @ManyToOne(optional = false)
    private Protocolos fkEmpresa;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProtocolo")
    private List<Equipos> equiposList;

    public Protocolos() {
    }

    public Protocolos(Integer idProtocolo) {
        this.idProtocolo = idProtocolo;
    }

    public Protocolos(Integer idProtocolo, String codigo, String nombre, String descripcion, Date revision, String responsable) {
        this.idProtocolo = idProtocolo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.revision = revision;
        this.responsable = responsable;
    }

    public Integer getIdProtocolo() {
        return idProtocolo;
    }

    public void setIdProtocolo(Integer idProtocolo) {
        this.idProtocolo = idProtocolo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getRevision() {
        return revision;
    }

    public void setRevision(Date revision) {
        this.revision = revision;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @XmlTransient
    public List<InstrumentosProtocolo> getInstrumentosProtocoloList() {
        return instrumentosProtocoloList;
    }

    public void setInstrumentosProtocoloList(List<InstrumentosProtocolo> instrumentosProtocoloList) {
        this.instrumentosProtocoloList = instrumentosProtocoloList;
    }

    @XmlTransient
    public List<Actividades> getActividadesList() {
        return actividadesList;
    }

    public void setActividadesList(List<Actividades> actividadesList) {
        this.actividadesList = actividadesList;
    }

    @XmlTransient
    public List<Protocolos> getProtocolosList() {
        return protocolosList;
    }

    public void setProtocolosList(List<Protocolos> protocolosList) {
        this.protocolosList = protocolosList;
    }

    public Protocolos getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Protocolos fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @XmlTransient
    public List<Equipos> getEquiposList() {
        return equiposList;
    }

    public void setEquiposList(List<Equipos> equiposList) {
        this.equiposList = equiposList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProtocolo != null ? idProtocolo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Protocolos)) {
            return false;
        }
        Protocolos other = (Protocolos) object;
        if ((this.idProtocolo == null && other.idProtocolo != null) || (this.idProtocolo != null && !this.idProtocolo.equals(other.idProtocolo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gts.equipos.modelo.Protocolos[ idProtocolo=" + idProtocolo + " ]";
    }
    
}
