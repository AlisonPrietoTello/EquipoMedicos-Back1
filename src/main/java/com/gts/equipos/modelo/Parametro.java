/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "parametro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametro.findAll", query = "SELECT p FROM Parametro p")
    , @NamedQuery(name = "Parametro.findByIdParametro", query = "SELECT p FROM Parametro p WHERE p.idParametro = :idParametro")
    , @NamedQuery(name = "Parametro.findByCodigo", query = "SELECT p FROM Parametro p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Parametro.findByValor", query = "SELECT p FROM Parametro p WHERE p.valor = :valor")
    , @NamedQuery(name = "Parametro.findByFecha", query = "SELECT p FROM Parametro p WHERE p.fecha = :fecha")
        , @NamedQuery(name = "Parametro.findByParametroXEMpresa", query = "SELECT p FROM Parametro p WHERE p.fkEmpresa.idEmpresa = :idEmpresa")
        , @NamedQuery(name = "Parametro.findByParametroXEMpresaAndIDparametro", query = "SELECT p FROM Parametro p WHERE p.fkEmpresa.idEmpresa = :idEmpresa AND p.idParametro = :idParametro")
    , @NamedQuery(name = "Parametro.findByNombre", query = "SELECT p FROM Parametro p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Parametro.findByNombreCorto", query = "SELECT p FROM Parametro p WHERE p.nombreCorto = :nombreCorto")
    , @NamedQuery(name = "Parametro.findByEmpresaAndParametro", 
                  query = "SELECT p FROM Parametro p WHERE p.fkEmpresa.idEmpresa = :idEmpresa AND p.idParametro = :idParametro")
    , @NamedQuery(name = "Parametro.findByGrupoAndParametro", 
                  query = "SELECT p FROM Parametro p WHERE p.fkGrupo.idGrupo = :idGrupo AND p.idParametro = :idParametro")
    , @NamedQuery(name = "Parametro.findByEmpresaAndGrupo", 
                  query = "SELECT p FROM Parametro p WHERE p.fkEmpresa.idEmpresa = :idEmpresa AND p.fkGrupo.idGrupo = :idGrupo")
    , @NamedQuery(name = "Parametro.findByEmpresaAndGrupoAndParametro", 
                  query = "SELECT p FROM Parametro p WHERE p.fkEmpresa.idEmpresa = :idEmpresa AND p.fkGrupo.idGrupo = :idGrupo AND p.idParametro = :idParametro")
})
public class Parametro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_parametro")
    private Integer idParametro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "codigo")
    private String codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    
    @JoinColumn(name = "fk_grupo", referencedColumnName = "id_grupo")
    @ManyToOne(optional = false)
    
    private Grupo fkGrupo;
    @JoinColumn(name = "fk_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa fkEmpresa;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipoTercero")
    private List<Terceros> tercerosList;
    
    
    public Parametro() {
    }

    public Parametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public Parametro(Integer idParametro, String codigo, BigDecimal valor, String nombre, String nombreCorto) {
        this.idParametro = idParametro;
        this.codigo = codigo;
        this.valor = valor;
        this.nombre = nombre;
        this.nombreCorto = nombreCorto;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public Grupo getFkGrupo() {
        return fkGrupo;
    }

    public void setFkGrupo(Grupo fkGrupo) {
        this.fkGrupo = fkGrupo;
    }

    public Empresa getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Empresa fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @XmlTransient
    public List<Terceros> getTercerosList() {
        return tercerosList;
    }

    public void setTercerosList(List<Terceros> tercerosList) {
        this.tercerosList = tercerosList;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametro)) {
            return false;
        }
        Parametro other = (Parametro) object;
        if ((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gts.equipos.modelo.Parametro[ idParametro=" + idParametro + " ]";
    }
    
}
