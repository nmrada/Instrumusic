/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ICarritoDeComprasDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.CarritoDeCompras;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas
 */
public class CarritoDeComprasDAOTest {
    
    CarritoDeCompras entity = new CarritoDeCompras();
    
    public CarritoDeComprasDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity.setIdCarritoDeCompras("QWERTY");
        entity.setSubtotal(10000);
        entity.setPrecioTotal(15000);
        entity.setImpuestos(5000);
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
    public void testInsert() throws Exception {
        System.out.println("Insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritoDeComprasDAO instance = fabrica.createCarritoDeComprasDAO();
        instance.insert(entity);
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        entity.setImpuestos(6000);
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritoDeComprasDAO instance = fabrica.createCarritoDeComprasDAO();
        instance.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritoDeComprasDAO instance = fabrica.createCarritoDeComprasDAO();
        CarritoDeCompras cct = instance.findByIdCarrito("QWERTY");
        instance.delete(cct);
    }
    
    @Test
    public void testFindByIdCarritoDeCompras() throws Exception {
        System.out.println("FindByIdCarritoDeCompras");
        CarritoDeCompras cct;
        String idcarrito = "QWERTY";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritoDeComprasDAO instance = fabrica.createCarritoDeComprasDAO();
        cct = instance.findByIdCarrito(idcarrito);
        System.out.println(cct.getIdCarritoDeCompras());
    }
    
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritoDeComprasDAO instance = fabrica.createCarritoDeComprasDAO();
        List<CarritoDeCompras> result = instance.findByAll();
        for (CarritoDeCompras result1 : result) {
            System.out.println(result1.getIdCarritoDeCompras());
        }
    }
    
    @Test
    public void testFindByPrecioTotal() throws Exception {
        System.out.println("FindByPrecioTotal");
        float total = 15000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritoDeComprasDAO instance = fabrica.createCarritoDeComprasDAO();
        List<CarritoDeCompras> result = instance.findByTotal(total);
        for (CarritoDeCompras result1 : result) {
            System.out.println(result1.getIdCarritoDeCompras());
        }
    }
    
    @Test
    public void testFindBySubtotal() throws Exception {
        System.out.println("FindBySubtotal");
        float subtotal = 10000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritoDeComprasDAO instance = fabrica.createCarritoDeComprasDAO();
        List<CarritoDeCompras> result = instance.findBySubtotal(subtotal);
         for (CarritoDeCompras result1 : result) {
            System.out.println(result1.getIdCarritoDeCompras());
        }
    }
    
    @Test
    public void testFindByImpuestos() throws Exception {
        System.out.println("FindByImpuestos");
        float impuestos = 6000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICarritoDeComprasDAO instance = fabrica.createCarritoDeComprasDAO();
        List<CarritoDeCompras> result = instance.findByImpuestos(impuestos);
         for (CarritoDeCompras result1 : result) {
            System.out.println(result1.getIdCarritoDeCompras());
        }
    }
    
}
