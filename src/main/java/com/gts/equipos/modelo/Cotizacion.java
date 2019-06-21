/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gts.equipos.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "cotizacion")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c")
    })
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cotiz_encab")
    private Integer idCotizEncab;
    @Column(name = "fecha_sistema")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSistema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "viatico_valor")
    private BigDecimal viaticoValor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "viatico_iva")
    private BigDecimal viaticoIva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "vigencia")
    private String vigencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "entrega")
    private String entrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "garantia_df")
    private String garantiaDf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "garantia_mo")
    private String garantiaMo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "condicion_pago")
    private String condicionPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "responsable")
    private String responsable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    
    @JoinColumn(name = "fk_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Clientes fkCliente;
    
    @JoinColumn(name = "fk_empresa", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private Empresa fkEmpresa;
   

    public Cotizacion() {
    }

    public Cotizacion(Integer idCotizEncab) {
        this.idCotizEncab = idCotizEncab;
    }

    public Cotizacion(Integer idCotizEncab, String codigo, Date fecha, BigDecimal viaticoValor, BigDecimal viaticoIva, String vigencia, String entrega, String garantiaDf, String garantiaMo, String condicionPago, String responsable, int estado) {
        this.idCotizEncab = idCotizEncab;
        this.codigo = codigo;
        this.fecha = fecha;
        this.viaticoValor = viaticoValor;
        this.viaticoIva = viaticoIva;
        this.vigencia = vigencia;
        this.entrega = entrega;
        this.garantiaDf = garantiaDf;
        this.garantiaMo = garantiaMo;
        this.condicionPago = condicionPago;
        this.responsable = responsable;
        this.estado = estado;
    }

    public Integer getIdCotizEncab() {
        return idCotizEncab;
    }

    public void setIdCotizEncab(Integer idCotizEncab) {
        this.idCotizEncab = idCotizEncab;
    }

    public Date getFechaSistema() {
        return fechaSistema;
    }

    public void setFechaSistema(Date fechaSistema) {
        this.fechaSistema = fechaSistema;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getViaticoValor() {
        return viaticoValor;
    }

    public void setViaticoValor(BigDecimal viaticoValor) {
        this.viaticoValor = viaticoValor;
    }

    public BigDecimal getViaticoIva() {
        return viaticoIva;
    }

    public void setViaticoIva(BigDecimal viaticoIva) {
        this.viaticoIva = viaticoIva;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public String getGarantiaDf() {
        return garantiaDf;
    }

    public void setGarantiaDf(String garantiaDf) {
        this.garantiaDf = garantiaDf;
    }

    public String getGarantiaMo() {
        return garantiaMo;
    }

    public void setGarantiaMo(String garantiaMo) {
        this.garantiaMo = garantiaMo;
    }

    public String getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotizEncab != null ? idCotizEncab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.idCotizEncab == null && other.idCotizEncab != null) || (this.idCotizEncab != null && !this.idCotizEncab.equals(other.idCotizEncab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gts.equipos.modelo.Cotizacion[ idCotizEncab=" + idCotizEncab + " ]";
    }
    
}
