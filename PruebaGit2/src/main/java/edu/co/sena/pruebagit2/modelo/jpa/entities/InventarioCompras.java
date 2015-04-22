/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.pruebagit2.modelo.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hernando
 */
@Entity
@Table(name = "inventario_compras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioCompras.findAll", query = "SELECT i FROM InventarioCompras i"),
    @NamedQuery(name = "InventarioCompras.findByIdinventario", query = "SELECT i FROM InventarioCompras i WHERE i.inventarioComprasPK.idinventario = :idinventario"),
    @NamedQuery(name = "InventarioCompras.findByProductoIdProducto", query = "SELECT i FROM InventarioCompras i WHERE i.inventarioComprasPK.productoIdProducto = :productoIdProducto"),
    @NamedQuery(name = "InventarioCompras.findByProveedorTipoDocumentoTipoDocumento", query = "SELECT i FROM InventarioCompras i WHERE i.inventarioComprasPK.proveedorTipoDocumentoTipoDocumento = :proveedorTipoDocumentoTipoDocumento"),
    @NamedQuery(name = "InventarioCompras.findByProveedorNumDocumento", query = "SELECT i FROM InventarioCompras i WHERE i.inventarioComprasPK.proveedorNumDocumento = :proveedorNumDocumento"),
    @NamedQuery(name = "InventarioCompras.findByFechaCompra", query = "SELECT i FROM InventarioCompras i WHERE i.fechaCompra = :fechaCompra"),
    @NamedQuery(name = "InventarioCompras.findByCanProComprado", query = "SELECT i FROM InventarioCompras i WHERE i.canProComprado = :canProComprado"),
    @NamedQuery(name = "InventarioCompras.findByPreciopormayor", query = "SELECT i FROM InventarioCompras i WHERE i.preciopormayor = :preciopormayor"),
    @NamedQuery(name = "InventarioCompras.findByObservaciones", query = "SELECT i FROM InventarioCompras i WHERE i.observaciones = :observaciones")})
public class InventarioCompras implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventarioComprasPK inventarioComprasPK;
    @Basic(optional = false)
    @Column(name = "FECHA_COMPRA")
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Column(name = "CAN_PRO_COMPRADO")
    private Integer canProComprado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIOPORMAYOR")
    private Float preciopormayor;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "PRODUCTO_ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumns({
        @JoinColumn(name = "PROVEEDOR_TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO_TIPO_DOCUMENTO", insertable = false, updatable = false),
        @JoinColumn(name = "PROVEEDOR_NUM_DOCUMENTO", referencedColumnName = "NUM_DOCUMENTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Proveedor proveedor;

    public InventarioCompras() {
    }

    public InventarioCompras(InventarioComprasPK inventarioComprasPK) {
        this.inventarioComprasPK = inventarioComprasPK;
    }

    public InventarioCompras(InventarioComprasPK inventarioComprasPK, Date fechaCompra) {
        this.inventarioComprasPK = inventarioComprasPK;
        this.fechaCompra = fechaCompra;
    }

    public InventarioCompras(int idinventario, String productoIdProducto, String proveedorTipoDocumentoTipoDocumento, String proveedorNumDocumento) {
        this.inventarioComprasPK = new InventarioComprasPK(idinventario, productoIdProducto, proveedorTipoDocumentoTipoDocumento, proveedorNumDocumento);
    }

    public InventarioComprasPK getInventarioComprasPK() {
        return inventarioComprasPK;
    }

    public void setInventarioComprasPK(InventarioComprasPK inventarioComprasPK) {
        this.inventarioComprasPK = inventarioComprasPK;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getCanProComprado() {
        return canProComprado;
    }

    public void setCanProComprado(Integer canProComprado) {
        this.canProComprado = canProComprado;
    }

    public Float getPreciopormayor() {
        return preciopormayor;
    }

    public void setPreciopormayor(Float preciopormayor) {
        this.preciopormayor = preciopormayor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioComprasPK != null ? inventarioComprasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioCompras)) {
            return false;
        }
        InventarioCompras other = (InventarioCompras) object;
        if ((this.inventarioComprasPK == null && other.inventarioComprasPK != null) || (this.inventarioComprasPK != null && !this.inventarioComprasPK.equals(other.inventarioComprasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.co.sena.pruebagit2.modelo.jpa.entities.InventarioCompras[ inventarioComprasPK=" + inventarioComprasPK + " ]";
    }
    
}
