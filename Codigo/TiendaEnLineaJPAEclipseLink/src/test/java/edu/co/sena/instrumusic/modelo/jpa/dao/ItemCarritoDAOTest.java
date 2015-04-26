/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IItemCarritoDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarrito;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarritoPK;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Nicolas
 */
public class ItemCarritoDAOTest {
    
    ItemCarrito entity = new ItemCarrito();
    
    public ItemCarritoDAOTest() {
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
    public void testInsert() throws Exception{
        System.out.println("Insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemCarritoDAO instance = fabrica.createItemCarritoDAO();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() throws Exception{
        System.out.println("Update");
        entity.setCantidad(1);
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemCarritoDAO instance = fabrica.createItemCarritoDAO();
        instance.update(entity);
    }
    
    @Test
    public void testDelete() throws Exception{
        System.out.println("Delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemCarritoDAO instance = fabrica.createItemCarritoDAO();
        ItemCarrito ict = instance.findByIdItemCarrito(new ItemCarritoPK("DA123", "QWERTY"));
        instance.delete(ict);
    }
    
    @Test
    public void testFindByAll() throws Exception{
        System.out.println("FindAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemCarritoDAO instance = fabrica.createItemCarritoDAO();
        List<ItemCarrito> result = instance.findByAll();
        for (ItemCarrito itemC : result) {
            System.out.println(itemC.getItemCarritoPK());
        }
    }
    
    @Test
    public void testFindByCantidad() throws Exception{
        System.out.println("FindByCantidad");
        int cantidad = 1;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemCarritoDAO instance = fabrica.createItemCarritoDAO();
        List<ItemCarrito> result = instance.findByCantidad(cantidad);
        for (ItemCarrito itemC : result) {
            System.out.println(itemC.getItemCarritoPK());
        }
    }
    
    @Test
    public void testFindByCostoUnitario() throws Exception{
        System.out.println("FindByCostoUnitario");
        float costoUnitario = 50000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemCarritoDAO instance = fabrica.createItemCarritoDAO();
        List<ItemCarrito> result = instance.findByCostoUnitario(costoUnitario);
        for (ItemCarrito itemC : result) {
            System.out.println(itemC.getItemCarritoPK());
        }
    }
    
    @Test
    public void testFindByCostoTotal() throws Exception{
        System.out.println("FindByCostoTotal");
        float costoTotal = 250000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemCarritoDAO instance = fabrica.createItemCarritoDAO();
        List<ItemCarrito> result = instance.findByCostoTotal(costoTotal);
        for (ItemCarrito itemC : result) {
            System.out.println(itemC.getItemCarritoPK());
        }
    }
    
    @Test
    public void testFindByIdItemCarrito() throws Exception{
        System.out.println("FindByIdItemCarrito");
        ItemCarrito itemT;
        ItemCarritoPK icpk = new ItemCarritoPK("DA123", "QWERTY");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IItemCarritoDAO instance = fabrica.createItemCarritoDAO();
        itemT = instance.findByIdItemCarrito(icpk);
        System.out.println(itemT.getItemCarritoPK());
    }
    
}
