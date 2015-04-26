/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedor;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedorPK;
import java.util.List;

/**
 *
 * @author ColsutecR
 */
public interface IDomicilioProveedorDAO {
    public void insert(DomicilioProveedor entity);

    public void update(DomicilioProveedor entity);

    public void delete(DomicilioProveedor entity);
    
    public DomicilioProveedor findByIdDomicilioProveedor(DomicilioProveedorPK domicilioProveedorPk);

    public List<DomicilioProveedor> findByAll();
    public List<DomicilioProveedor> findByTelefono(String telefono);
    public List<DomicilioProveedor> findByDireccion(String direccion);
    public List<DomicilioProveedor> findByBarrio(String barrio);
    public List<DomicilioProveedor> findByLocalidad(String localidad);
}
