/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;


import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarrito;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarritoPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.Producto;
import java.util.List;

/**
 *
 * @author ColsutecR
 */
public interface ItemCarritoDAO {
    public void insert(ItemCarrito entity);

    public void update(ItemCarrito entity);

    public void delete(ItemCarrito entity);
    
    public ItemCarrito findByIdItemCarrito(ItemCarritoPK itemCarritoPk);

    public List<ItemCarrito> findByAll();
    public List<ItemCarrito> findByCantidad(int cantidad);
    public List<ItemCarrito> findByCostoUnitario(double costoUnitario);
    public List<ItemCarrito> findByCostoTotal(double costoTotal);
}
