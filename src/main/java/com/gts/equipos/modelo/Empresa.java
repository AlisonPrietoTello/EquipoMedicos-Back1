/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Xamir Mercado
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByIdEmpresa", query = "SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa")
    , @NamedQuery(name = "Empresa.findByNombreEmpresa", query = "SELECT e FROM Empresa e WHERE e.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "Empresa.findByNombreCorto", query = "SELECT e FROM Empresa e WHERE e.nombreCorto = :nombreCorto")
    , @NamedQuery(name = "Empresa.findByNitEmpresa", query = "SELECT e FROM Empresa e WHERE e.nitEmpresa = :nitEmpresa")
    , @NamedQuery(name = "Empresa.findByEstado", query = "SELECT e FROM Empresa e WHERE e.estado = :estado")
    , @NamedQuery(name = "Empresa.findByUrlLogo", query = "SELECT e FROM Empresa e WHERE e.urlLogo = :urlLogo")
    , @NamedQuery(name = "Empresa.findBySloganEmpresa", query = "SELECT e FROM Empresa e WHERE e.sloganEmpresa = :sloganEmpresa")
    , @NamedQuery(name = "Empresa.findByRepresentanteLegal", query = "SELECT e FROM Empresa e WHERE e.representanteLegal = :representanteLegal")
    , @NamedQuery(name = "Empresa.findByDocumentoRepresentante", query = "SELECT e FROM Empresa e WHERE e.documentoRepresentante = :documentoRepresentante")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Size(max = 45)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nit_empresa")
    private String nitEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Size(max = 150)
    @Column(name = "url_logo")
    private String urlLogo;
    @Size(max = 100)
    @Column(name = "slogan_empresa")
    private String sloganEmpresa;
    @Size(max = 100)
    @Column(name = "representante_legal")
    private String representanteLegal;
    @Size(max = 45)
    @Column(name = "documento_representante")
    private String documentoRepresentante;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmpresa")
    private List<InstrumentosProtocolo> instrumentosProtocoloList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmpresa")
    private List<Parametro> parametroList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmpresa")
    private List<Actividades> actividadesList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmpresa")
    private List<Equipos> equiposList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEmpresa")
    private List<Instrumentos> instrumentosList;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, String nombreEmpresa, String nitEmpresa, int estado) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.nitEmpresa = nitEmpresa;
        this.estado = estado;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getSloganEmpresa() {
        return sloganEmpresa;
    }

    public void setSloganEmpresa(String sloganEmpresa) {
        this.sloganEmpresa = sloganEmpresa;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getDocumentoRepresentante() {
        return documentoRepresentante;
    }

    public void setDocumentoRepresentante(String documentoRepresentante) {
        this.documentoRepresentante = documentoRepresentante;
    }

    @XmlTransient
    public List<InstrumentosProtocolo> getInstrumentosProtocoloList() {
        return instrumentosProtocoloList;
    }

    public void setInstrumentosProtocoloList(List<InstrumentosProtocolo> instrumentosProtocoloList) {
        this.instrumentosProtocoloList = instrumentosProtocoloList;
    }

    @XmlTransient
    public List<Parametro> getParametroList() {
        return parametroList;
    }

    public void setParametroList(List<Parametro> parametroList) {
        this.parametroList = parametroList;
    }

    @XmlTransient
    public List<Actividades> getActividadesList() {
        return actividadesList;
    }

    public void setActividadesList(List<Actividades> actividadesList) {
        this.actividadesList = actividadesList;
    }

    @XmlTransient
    public List<Equipos> getEquiposList() {
        return equiposList;
    }

    public void setEquiposList(List<Equipos> equiposList) {
        this.equiposList = equiposList;
    }

    @XmlTransient
    public List<Instrumentos> getInstrumentosList() {
        return instrumentosList;
    }

    public void setInstrumentosList(List<Instrumentos> instrumentosList) {
        this.instrumentosList = instrumentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gts.equipos.modelo.Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
