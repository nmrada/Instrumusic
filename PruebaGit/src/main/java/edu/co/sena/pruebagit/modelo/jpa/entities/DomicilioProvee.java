/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.pruebagit.modelo.jpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "domicilio_provee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DomicilioProvee.findAll", query = "SELECT d FROM DomicilioProvee d"),
    @NamedQuery(name = "DomicilioProvee.findByDireccion", query = "SELECT d FROM DomicilioProvee d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DomicilioProvee.findByTelefono", query = "SELECT d FROM DomicilioProvee d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "DomicilioProvee.findByBarrio", query = "SELECT d FROM DomicilioProvee d WHERE d.barrio = :barrio"),
    @NamedQuery(name = "DomicilioProvee.findByLocalidad", query = "SELECT d FROM DomicilioProvee d WHERE d.localidad = :localidad"),
    @NamedQuery(name = "DomicilioProvee.findByCorreoPostal", query = "SELECT d FROM DomicilioProvee d WHERE d.correoPostal = :correoPostal"),
    @NamedQuery(name = "DomicilioProvee.findByProveedorTipoDocumentoTipoDocumento", query = "SELECT d FROM DomicilioProvee d WHERE d.domicilioProveePK.proveedorTipoDocumentoTipoDocumento = :proveedorTipoDocumentoTipoDocumento"),
    @NamedQuery(name = "DomicilioProvee.findByProveedorNumDocumento", query = "SELECT d FROM DomicilioProvee d WHERE d.domicilioProveePK.proveedorNumDocumento = :proveedorNumDocumento")})
public class DomicilioProvee implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DomicilioProveePK domicilioProveePK;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "localidad")
    private String localidad;
    @Column(name = "CORREO_POSTAL")
    private String correoPostal;
    @JoinColumns({
        @JoinColumn(name = "PROVEEDOR_TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO_TIPO_DOCUMENTO", insertable = false, updatable = false),
        @JoinColumn(name = "PROVEEDOR_NUM_DOCUMENTO", referencedColumnName = "NUM_DOCUMENTO", insertable = false, updatable = false)})
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Proveedor proveedor;
    @JoinColumn(name = "MUNICIPIO_idMUNICIPIO", referencedColumnName = "idMUNICIPIO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Municipio mUNICIPIOidMUNICIPIO;

    public DomicilioProvee() {
    }

    public DomicilioProvee(DomicilioProveePK domicilioProveePK) {
        this.domicilioProveePK = domicilioProveePK;
    }

    public DomicilioProvee(String proveedorTipoDocumentoTipoDocumento, String proveedorNumDocumento) {
        this.domicilioProveePK = new DomicilioProveePK(proveedorTipoDocumentoTipoDocumento, proveedorNumDocumento);
    }

    public DomicilioProveePK getDomicilioProveePK() {
        return domicilioProveePK;
    }

    public void setDomicilioProveePK(DomicilioProveePK domicilioProveePK) {
        this.domicilioProveePK = domicilioProveePK;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCorreoPostal() {
        return correoPostal;
    }

    public void setCorreoPostal(String correoPostal) {
        this.correoPostal = correoPostal;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Municipio getMUNICIPIOidMUNICIPIO() {
        return mUNICIPIOidMUNICIPIO;
    }

    public void setMUNICIPIOidMUNICIPIO(Municipio mUNICIPIOidMUNICIPIO) {
        this.mUNICIPIOidMUNICIPIO = mUNICIPIOidMUNICIPIO;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domicilioProveePK != null ? domicilioProveePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DomicilioProvee)) {
            return false;
        }
        DomicilioProvee other = (DomicilioProvee) object;
        if ((this.domicilioProveePK == null && other.domicilioProveePK != null) || (this.domicilioProveePK != null && !this.domicilioProveePK.equals(other.domicilioProveePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.pruebagit.pruebagit.DomicilioProvee[ domicilioProveePK=" + domicilioProveePK + " ]";
    }
    
}
