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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Xamir Mercado
 */
@Entity
@Table(name = "instrumentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instrumentos.findAll", query = "SELECT i FROM Instrumentos i")
    , @NamedQuery(name = "Instrumentos.findByIdInstrumentos", query = "SELECT i FROM Instrumentos i WHERE i.idInstrumentos = :idInstrumentos")
    , @NamedQuery(name = "Instrumentos.findByNombre", query = "SELECT i FROM Instrumentos i WHERE i.nombre = :nombre")
    , @NamedQuery(name = "Instrumentos.findByMarca", query = "SELECT i FROM Instrumentos i WHERE i.marca = :marca")
    , @NamedQuery(name = "Instrumentos.findByModelo", query = "SELECT i FROM Instrumentos i WHERE i.modelo = :modelo")
    , @NamedQuery(name = "Instrumentos.findByEmpresaAndInstrumentos", query = "SELECT i FROM Instrumentos i WHERE i.fkEmpresa.idEmpresa = :idEmpresa AND i.idInstrumentos = :idInstrumentos")})
public class Instrumentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_instrumentos")
    private Integer idInstrumentos;
    @Size(max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "marca")
    private String marca;
    @Size(max = 250)
    @Column(name = "modelo")
    private String modelo;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkInstrumento")
    private List<InstrumentosProtocolo> instrumentosProtocoloList;
    
    @JoinColumn(name = "fk_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa fkEmpresa;

    public Instrumentos() {
    }

    public Instrumentos(Integer idInstrumentos) {
        this.idInstrumentos = idInstrumentos;
    }

    public Integer getIdInstrumentos() {
        return idInstrumentos;
    }

    public void setIdInstrumentos(Integer idInstrumentos) {
        this.idInstrumentos = idInstrumentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @XmlTransient
    public List<InstrumentosProtocolo> getInstrumentosProtocoloList() {
        return instrumentosProtocoloList;
    }

    public void setInstrumentosProtocoloList(List<InstrumentosProtocolo> instrumentosProtocoloList) {
        this.instrumentosProtocoloList = instrumentosProtocoloList;
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
        hash += (idInstrumentos != null ? idInstrumentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instrumentos)) {
            return false;
        }
        Instrumentos other = (Instrumentos) object;
        if ((this.idInstrumentos == null && other.idInstrumentos != null) || (this.idInstrumentos != null && !this.idInstrumentos.equals(other.idInstrumentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gts.equipos.modelo.Instrumentos[ idInstrumentos=" + idInstrumentos + " ]";
    }
    
}
