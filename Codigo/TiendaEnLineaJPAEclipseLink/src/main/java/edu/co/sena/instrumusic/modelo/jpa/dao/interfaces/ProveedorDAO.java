/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.Proveedor;
import edu.co.sena.instrumusic.modelo.jpa.entities.ProveedorPK;
import java.util.List;

/**
 *
 * @author ColsutecR
 */
public interface ProveedorDAO {

    public static final String NOMBRE = "nombre";
    public static final String EMAIL = "email";

    public void insert(Proveedor entity);

    public void update(Proveedor entity);

    public void delete(Proveedor entity);

    public Proveedor findByIdProveedor(ProveedorPK llavePrimaria);

    public List<Proveedor> findAll();

    public List<Proveedor> findByNombre(String nombre);

    public List<Proveedor> findByEmail(String email);

}
