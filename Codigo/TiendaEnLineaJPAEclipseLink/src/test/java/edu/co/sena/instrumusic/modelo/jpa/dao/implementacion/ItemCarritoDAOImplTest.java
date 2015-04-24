/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarrito;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarritoPK;
import java.util.List;
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
public class ItemCarritoDAOImplTest {
    
    ItemCarrito entity = new ItemCarrito();
    
    public ItemCarritoDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity.setCantidad(5);
        entity.setCostoUnitario(50000);
        entity.setCostoTotal(250000);
        entity.setItemCarritoPK(new ItemCarritoPK("DA123", "QWERTY"));
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testInsert(){
        System.out.println("Insert");
        ItemCarritoDAOImpl instance = new ItemCarritoDAOImpl();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate(){
        System.out.println("Update");
        entity.setCantidad(1);
        ItemCarritoDAOImpl instance = new ItemCarritoDAOImpl();
        instance.update(entity);
    }
    
    @Test
    public void testDelete(){
        System.out.println("Delete");
        ItemCarritoDAOImpl instance = new ItemCarritoDAOImpl();
        ItemCarrito ict = instance.findByIdItemCarrito(new ItemCarritoPK("DA123", "QWERTY"));
        instance.delete(ict);
    }
    
    @Test
    public void testFindByAll(){
        System.out.println("FindAll");
        ItemCarritoDAOImpl instance = new ItemCarritoDAOImpl();
        List<ItemCarrito> result = instance.findByAll();
        for (ItemCarrito itemC : result) {
            System.out.println(itemC.getItemCarritoPK());
        }
    }
    
    @Test
    public void testFindByCantidad(){
        System.out.println("FindByCantidad");
        int cantidad = 1;
        ItemCarritoDAOImpl instance = new ItemCarritoDAOImpl();
        List<ItemCarrito> result = instance.findByCantidad(cantidad);
        for (ItemCarrito itemC : result) {
            System.out.println(itemC.getItemCarritoPK());
        }
    }
    
    @Test
    public void testFindByCostoUnitario(){
        System.out.println("FindByCostoUnitario");
        double costoUnitario = 50000;
        ItemCarritoDAOImpl instance = new ItemCarritoDAOImpl();
        List<ItemCarrito> result = instance.findByCostoUnitario(costoUnitario);
        for (ItemCarrito itemC : result) {
            System.out.println(itemC.getItemCarritoPK());
        }
    }
    
    @Test
    public void testFindByCostoTotal(){
        System.out.println("FindByCostoTotal");
        double costoTotal = 250000;
        ItemCarritoDAOImpl instance = new ItemCarritoDAOImpl();
        List<ItemCarrito> result = instance.findByCostoTotal(costoTotal);
        for (ItemCarrito itemC : result) {
            System.out.println(itemC.getItemCarritoPK());
        }
    }
    
    @Test
    public void testFindByIdItemCarrito(){
        System.out.println("FindByIdItemCarrito");
        ItemCarrito itemT;
        ItemCarritoPK icpk = new ItemCarritoPK("DA123", "QWERTY");
        ItemCarritoDAOImpl instance = new ItemCarritoDAOImpl();
        itemT = instance.findByIdItemCarrito(icpk);
        System.out.println(itemT.getItemCarritoPK());
    }
}
