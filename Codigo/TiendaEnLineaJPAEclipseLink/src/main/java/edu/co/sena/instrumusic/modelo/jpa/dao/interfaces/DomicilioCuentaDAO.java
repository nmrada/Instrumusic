/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;


import edu.co.sena.instrumusic.modelo.jpa.entities.Cuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioCuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioCuentaPK;
import java.util.List;

/**
 *
 * @author admin
 */
public interface DomicilioCuentaDAO {
 
    public void insert(DomicilioCuenta entity);
    public void update(DomicilioCuenta entity);
    public void delete(DomicilioCuenta entity); 
    
    public DomicilioCuenta findByIdDomicilioCuenta(DomicilioCuentaPK domiciliocuentaPk);    

    public List<DomicilioCuenta> findByAll();
    
    public List<DomicilioCuenta> findByTelefono(String telefono);
    public List<DomicilioCuenta> findByDireccion(String direccion);
    public List<DomicilioCuenta> findByBario(String barrio);
    public List<DomicilioCuenta> findByLocalidad(String localidad);

}
