/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.pruebagit2.modelo.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author hernando
 */
@Embeddable
public class DomicilioProveePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PROVEEDOR_TIPO_DOCUMENTO_TIPO_DOCUMENTO")
    private String proveedorTipoDocumentoTipoDocumento;
    @Basic(optional = false)
    @Column(name = "PROVEEDOR_NUM_DOCUMENTO")
    private String proveedorNumDocumento;

    public DomicilioProveePK() {
    }

    public DomicilioProveePK(String proveedorTipoDocumentoTipoDocumento, String proveedorNumDocumento) {
        this.proveedorTipoDocumentoTipoDocumento = proveedorTipoDocumentoTipoDocumento;
        this.proveedorNumDocumento = proveedorNumDocumento;
    }

    public String getProveedorTipoDocumentoTipoDocumento() {
        return proveedorTipoDocumentoTipoDocumento;
    }

    public void setProveedorTipoDocumentoTipoDocumento(String proveedorTipoDocumentoTipoDocumento) {
        this.proveedorTipoDocumentoTipoDocumento = proveedorTipoDocumentoTipoDocumento;
    }

    public String getProveedorNumDocumento() {
        return proveedorNumDocumento;
    }

    public void setProveedorNumDocumento(String proveedorNumDocumento) {
        this.proveedorNumDocumento = proveedorNumDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedorTipoDocumentoTipoDocumento != null ? proveedorTipoDocumentoTipoDocumento.hashCode() : 0);
        hash += (proveedorNumDocumento != null ? proveedorNumDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DomicilioProveePK)) {
            return false;
        }
        DomicilioProveePK other = (DomicilioProveePK) object;
        if ((this.proveedorTipoDocumentoTipoDocumento == null && other.proveedorTipoDocumentoTipoDocumento != null) || (this.proveedorTipoDocumentoTipoDocumento != null && !this.proveedorTipoDocumentoTipoDocumento.equals(other.proveedorTipoDocumentoTipoDocumento))) {
            return false;
        }
        if ((this.proveedorNumDocumento == null && other.proveedorNumDocumento != null) || (this.proveedorNumDocumento != null && !this.proveedorNumDocumento.equals(other.proveedorNumDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.pruebagit2.modelo.jpa.entities.DomicilioProveePK[ proveedorTipoDocumentoTipoDocumento=" + proveedorTipoDocumentoTipoDocumento + ", proveedorNumDocumento=" + proveedorNumDocumento + " ]";
    }
    
}
