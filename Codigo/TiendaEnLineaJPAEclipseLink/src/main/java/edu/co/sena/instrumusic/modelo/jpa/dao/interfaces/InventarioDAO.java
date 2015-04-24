/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.Inventario;
import edu.co.sena.instrumusic.modelo.jpa.entities.InventarioPK;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ColsutecR
 */
public interface InventarioDAO {

    public void insert(Inventario entity);

    public void update(Inventario entity);

    public void delete(Inventario entity);

    public Inventario findByIdInventario(InventarioPK idInventario);

    public List<Inventario> findAll();

 

    public List<Inventario> findByFecha(Date fecha);

    public List<Inventario> findByCantidad(int cantidad);

  
}
