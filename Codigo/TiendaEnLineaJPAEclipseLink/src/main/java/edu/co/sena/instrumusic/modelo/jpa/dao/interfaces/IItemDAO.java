/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.Item;
import java.util.List;

/**
 *
 * @author My PC
 */
public interface IItemDAO {
    
    public void insert(Item entity);

    public void update(Item entity);

    public void delete(Item entity);

    public Item findByIdItem(int idFactura);

    public List<Item> findByAll();
    public List<Item> findByProductoidProducto(String idProducto);
    public List<Item> findByPedidoFacturaidFactura(int idFactura);
    public List<Item> findByCantidad(int cantidad);
    public List<Item> findByCostoUnitario(double costoUnitario);
    public List<Item> findByCostoTotal(double costoTotal);
    
    
}
