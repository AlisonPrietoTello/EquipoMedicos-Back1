/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author laszlo
 */
@Entity
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e")
    })
public class Equipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipos")
    private Integer idEquipos;
    @Size(max = 30)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "referencia")
    private String referencia;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_tipo")
    private int fkTipo;
    
    @JoinColumn(name = "fk_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa fkEmpresa;
    
    @JoinColumn(name = "fk_protocolo", referencedColumnName = "id_protocolo")
    @ManyToOne(optional = false)
    private Protocolos fkProtocolo;

    public Equipos() {
    }

    

    public Equipos(Integer idEquipos, String referencia, int estado, int fkTipo) {
        this.idEquipos = idEquipos;
        this.referencia = referencia;
        this.estado = estado;
        this.fkTipo = fkTipo;
    }

    public Integer getIdEquipos() {
        return idEquipos;
    }

    public void setIdEquipos(Integer idEquipos) {
        this.idEquipos = idEquipos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getFkTipo() {
        return fkTipo;
    }

    public void setFkTipo(int fkTipo) {
        this.fkTipo = fkTipo;
    }

    public Empresa getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Empresa fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @JsonIgnore
    public Protocolos getFkProtocolo() {
        return fkProtocolo;
    }

    public void setFkProtocolo(Protocolos fkProtocolo) {
        this.fkProtocolo = fkProtocolo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipos != null ? idEquipos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.idEquipos == null && other.idEquipos != null) || (this.idEquipos != null && !this.idEquipos.equals(other.idEquipos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gts.equipos.modelo.Equipos[ idEquipos=" + idEquipos + " ]";
    }
    
}
