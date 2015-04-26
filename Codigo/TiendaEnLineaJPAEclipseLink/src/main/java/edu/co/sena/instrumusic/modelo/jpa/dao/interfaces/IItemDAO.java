/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.Item;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemPK;
import java.util.List;

/**
 *
 * @author My PC
 */
public interface IItemDAO {
    
    public void insert(Item entity);

    public void update(Item entity);

    public void delete(Item entity);

    public Item findByIdItem(ItemPK itemPk);

    public List<Item> findByAll();
    public List<Item> findByCantidad(int cantidad);
    public List<Item> findByCostoUnitario(float costoUnitario);
    public List<Item> findByCostoTotal(float costoTotal);
    
    
}
