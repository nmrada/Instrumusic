/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.entities.Item;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemPK;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ColsutecR
 */
public class ItemDAOImplTest {
    
    Item entity = new Item();
    
    public ItemDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        entity = new Item();
        ItemPK itemPK = new ItemPK();
        itemPK.setPedidoFacturaidFactura(4);
        itemPK.setProductoidProducto("DA123");
        entity.setItemPK(itemPK);
        entity.setCantidad(2);
        entity.setCostoUnitario(270000);
        entity.setCostoTotal(540000);
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class ItemDAOImpl.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        ItemDAOImpl instance = new ItemDAOImpl();
        instance.insert(entity);
    }

    /**
     * Test of update method, of class ItemDAOImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        entity.setCantidad(12);
        ItemDAOImpl instance = new ItemDAOImpl();
        instance.update(entity);
    }

    /**
     * Test of delete method, of class ItemDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        ItemDAOImpl instance = new ItemDAOImpl();
        Item item = instance.findByIdItem(1);
        instance.delete(entity);
    }

    /**
     * Test of findByIdItem method, of class ItemDAOImpl.
     */
//    @Test
//    public void testFindByIdItem() {
//        System.out.println("findByIdItem");
//        int idFactura = 4;
//        String idProducto = "DA123";
//        ItemDAOImpl instance = new ItemDAOImpl();
//        Item item = instance.findByIdItem(idFactura);
//        System.out.println(item.getItemPK());
//    }

    /**
     * Test of findByAll method, of class ItemDAOImpl.
     */
    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        ItemDAOImpl instance = new ItemDAOImpl();
        List<Item> result = instance.findByAll();
        for (Item result1 : result) {
            System.out.println(result1.getItemPK());
        }
        
    }

    /**
     * Test of findByProductoidProducto method, of class ItemDAOImpl.
     */
    @Test
    public void testFindByProductoidProducto() {
        System.out.println("findByProductoidProducto");
        String idProducto = "DA123";
        ItemDAOImpl instance = new ItemDAOImpl();
        List<Item> result = instance.findByProductoidProducto(idProducto);
        for (Item result1 : result) {
            System.out.println(result1.getItemPK());
        }
    }

    /**
     * Test of findByPedidoFacturaidFactura method, of class ItemDAOImpl.
     */
    @Test
    public void testFindByPedidoFacturaidFactura() {
        System.out.println("findByPedidoFacturaidFactura");
        int idFacura = 1;
        ItemDAOImpl instance = new ItemDAOImpl();
        List<Item> result = instance.findByPedidoFacturaidFactura(idFacura);
        for (Item result1 : result) {
            System.out.println(result1.getItemPK());
        }
    }

    /**
     * Test of findByCantidad method, of class ItemDAOImpl.
     */
    @Test
    public void testFindByCantidad() {
        System.out.println("findByCantidad");
        int cantidad = 2;
        ItemDAOImpl instance = new ItemDAOImpl();
        List<Item> result = instance.findByCantidad(cantidad);
        for (Item result1 : result) {
            System.out.println(result1.getItemPK());
        }
    }

    /**
     * Test of findByCostoUnitario method, of class ItemDAOImpl.
     */
    @Test
    public void testFindByCostoUnitario() {
        System.out.println("findByCostoUnitario");
        double costoUnitario = 270000;
        ItemDAOImpl instance = new ItemDAOImpl();
        List<Item> result = instance.findByCostoUnitario(costoUnitario);
        for (Item result1 : result) {
            System.out.println(result1.getItemPK());
        }
    }

    /**
     * Test of findByCostoTotal method, of class ItemDAOImpl.
     */
    @Test
    public void testFindByCostoTotal() {
        System.out.println("findByCostoTotal");
        double costoTotal = 540000;
        ItemDAOImpl instance = new ItemDAOImpl();
        List<Item> result = instance.findByCostoTotal(costoTotal);
        for (Item result1 : result) {
            System.out.println(result1.getItemPK());
        }
    }
    
}
