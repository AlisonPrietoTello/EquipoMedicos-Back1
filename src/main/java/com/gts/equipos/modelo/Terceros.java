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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Xamir Mercado
 */
@Entity
@Table(name = "terceros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terceros.findAll", query = "SELECT t FROM Terceros t")
    , @NamedQuery(name = "Terceros.findByIdTerceros", query = "SELECT t FROM Terceros t WHERE t.idTerceros = :idTerceros")
    , @NamedQuery(name = "Terceros.findByDocumento", query = "SELECT t FROM Terceros t WHERE t.documento = :documento")
    , @NamedQuery(name = "Terceros.findByNombre", query = "SELECT t FROM Terceros t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Terceros.findByNombreCorto", query = "SELECT t FROM Terceros t WHERE t.nombreCorto = :nombreCorto")
    , @NamedQuery(name = "Terceros.findByDireccion", query = "SELECT t FROM Terceros t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "Terceros.findByTelefonoFijo", query = "SELECT t FROM Terceros t WHERE t.telefonoFijo = :telefonoFijo")
    , @NamedQuery(name = "Terceros.findByTelefonoCelular", query = "SELECT t FROM Terceros t WHERE t.telefonoCelular = :telefonoCelular")
    , @NamedQuery(name = "Terceros.findByEmail", query = "SELECT t FROM Terceros t WHERE t.email = :email")
    , @NamedQuery(name = "Terceros.findByCiudad", query = "SELECT t FROM Terceros t WHERE t.ciudad = :ciudad")
    , @NamedQuery(name = "Terceros.findByAtencion", query = "SELECT t FROM Terceros t WHERE t.atencion = :atencion")
    , @NamedQuery(name = "Terceros.findByEstado", query = "SELECT t FROM Terceros t WHERE t.estado = :estado")})
public class Terceros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_terceros")
    private Integer idTerceros;
    @Size(max = 45)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono_celular")
    private String telefonoCelular;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "atencion")
    private String atencion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JoinColumn(name = "fk_tipo_tercero", referencedColumnName = "id_parametro")
    @ManyToOne(optional = false)
    private Parametro fkTipoTercero;

    public Terceros() {
    }

    public Terceros(Integer idTerceros) {
        this.idTerceros = idTerceros;
    }

    public Terceros(Integer idTerceros, String nombre, String direccion, String telefonoCelular, String email, String atencion, int estado) {
        this.idTerceros = idTerceros;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonoCelular = telefonoCelular;
        this.email = email;
        this.atencion = atencion;
        this.estado = estado;
    }

    public Integer getIdTerceros() {
        return idTerceros;
    }

    public void setIdTerceros(Integer idTerceros) {
        this.idTerceros = idTerceros;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getAtencion() {
        return atencion;
    }

    public void setAtencion(String atencion) {
        this.atencion = atencion;
    }
    
    public int getEstado() {
    return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Parametro getFkTipoTercero() {
        return fkTipoTercero;
    }

    public void setFkTipoTercero(Parametro fkTipoTercero) {
        this.fkTipoTercero = fkTipoTercero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTerceros != null ? idTerceros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terceros)) {
            return false;
        }
        Terceros other = (Terceros) object;
        if ((this.idTerceros == null && other.idTerceros != null) || (this.idTerceros != null && !this.idTerceros.equals(other.idTerceros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gts.equipos.modelo.Terceros[ idTerceros=" + idTerceros + " ]";
    }
    
}
