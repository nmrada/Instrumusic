/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IItemDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Item;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemPK;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex
 */
public class ItemDAOTest {
    
    Item entity = new Item();
    
    public ItemDAOTest() {
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
        itemPK.setPedidoFacturaidFactura(1);
        itemPK.setProductoidProducto("DA123");
        entity.setItemPK(itemPK);
        entity.setCantidad(2);
        entity.setCostoUnitario(270000);
        entity.setCostoTotal(540000);
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    /**
     * Test of insert method, of class ItemDAOImpl.
     */
    @Test
    public void testInsert()throws Exception{
        
        System.out.println("insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO instance = fabrica.createItemDAO();
        instance.insert(entity);
    }

    /**
     * Test of update method, of class ItemDAOImpl.
     */
    @Test
    public void testUpdate()throws Exception {
        System.out.println("update");
        entity.setCantidad(12);
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO instance = fabrica.createItemDAO();
        instance.update(entity);
    }

    /**
     * Test of delete method, of class ItemDAOImpl.
     */
    @Test
    public void testDelete() throws Exception{
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO instance = fabrica.createItemDAO();
        Item item = instance.findByIdItem(new ItemPK("DA123", 1));
        instance.delete(entity);
    }

    /**
     * Test of findByIdItem method, of class ItemDAOImpl.
     */
    @Test
    public void testFindByIdItem() throws Exception{
        System.out.println("findByIdItem");
        String idProducto = "DA123";
        int idFactura = 1;
        ItemPK itemPk = new ItemPK(idProducto, idFactura);
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO instance = fabrica.createItemDAO();
        Item item = instance.findByIdItem(itemPk);
        System.out.println(item.getItemPK());
    }

    /**
     * Test of findByAll method, of class ItemDAOImpl.
     */
    @Test
    public void testFindByAll() throws Exception{
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO instance = fabrica.createItemDAO();
        List<Item> result = instance.findByAll();
        for (Item result1 : result) {
            System.out.println(result1.getItemPK());
        }
        
    }

    /**
     * Test of findByCantidad method, of class ItemDAOImpl.
     */
    @Test
    public void testFindByCantidad() throws Exception{
        System.out.println("findByCantidad");
        int cantidad = 12;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO instance = fabrica.createItemDAO();
        List<Item> result = instance.findByCantidad(cantidad);
        for (Item result1 : result) {
            System.out.println(result1.getItemPK());
        }
    }

    /**
     * Test of findByCostoUnitario method, of class ItemDAOImpl.
     */
    @Test
    public void testFindByCostoUnitario() throws Exception{
        System.out.println("findByCostoUnitario");
        float costoUnitario = 270000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO instance = fabrica.createItemDAO();
        List<Item> result = instance.findByCostoUnitario(costoUnitario);
        for (Item result1 : result) {
            System.out.println(result1.getItemPK());
        }
    }

    /**
     * Test of findByCostoTotal method, of class ItemDAOImpl.
     */
    @Test
    public void testFindByCostoTotal() throws Exception{
        System.out.println("findByCostoTotal");
        float costoTotal = 540000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemDAO instance = fabrica.createItemDAO();
        List<Item> result = instance.findByCostoTotal(costoTotal);
        for (Item result1 : result) {
            System.out.println(result1.getItemPK());
        }
    }
    
}
