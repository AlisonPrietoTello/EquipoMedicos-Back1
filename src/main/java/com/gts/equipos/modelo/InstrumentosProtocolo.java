/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.modelo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laszlo
 */
@Entity
@Table(name = "instrumentos_protocolo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InstrumentosProtocolo.findAll", query = "SELECT i FROM InstrumentosProtocolo i")})
public class InstrumentosProtocolo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_inst_prot")
    private Integer idInstProt;
    @JoinColumn(name = "fk_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa fkEmpresa;
    @JoinColumn(name = "fk_instrumento", referencedColumnName = "id_instrumentos")
    @ManyToOne(optional = false)
    private Instrumentos fkInstrumento;
    @JoinColumn(name = "fk_protocolo", referencedColumnName = "id_protocolo")
    @ManyToOne(optional = false)
    private Protocolos fkProtocolo;

    public InstrumentosProtocolo() {
    }

    public InstrumentosProtocolo(Integer idInstProt) {
        this.idInstProt = idInstProt;
    }

    public Integer getIdInstProt() {
        return idInstProt;
    }

    public void setIdInstProt(Integer idInstProt) {
        this.idInstProt = idInstProt;
    }

    public Empresa getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Empresa fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Instrumentos getFkInstrumento() {
        return fkInstrumento;
    }

    public void setFkInstrumento(Instrumentos fkInstrumento) {
        this.fkInstrumento = fkInstrumento;
    }

    public Protocolos getFkProtocolo() {
        return fkProtocolo;
    }

    public void setFkProtocolo(Protocolos fkProtocolo) {
        this.fkProtocolo = fkProtocolo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstProt != null ? idInstProt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InstrumentosProtocolo)) {
            return false;
        }
        InstrumentosProtocolo other = (InstrumentosProtocolo) object;
        if ((this.idInstProt == null && other.idInstProt != null) || (this.idInstProt != null && !this.idInstProt.equals(other.idInstProt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gts.equipos.modelo.InstrumentosProtocolo[ idInstProt=" + idInstProt + " ]";
    }
    
}
