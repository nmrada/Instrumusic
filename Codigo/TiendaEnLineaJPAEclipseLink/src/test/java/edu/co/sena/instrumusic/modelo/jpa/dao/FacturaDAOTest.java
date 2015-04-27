/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IFacturaDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Cuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.Factura;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author My PC
 */
public class FacturaDAOTest {
    
    Factura entity = new Factura();
    
    public FacturaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        entity = new Factura();
        Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
        Date fechaActual = calendario.getTime();
        entity.setFecha(fechaActual);
        entity.setTotal(600000);
        entity.setCuenta(new Cuenta("CC", "1023006468"));
        
        
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
        System.out.println("insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO instance = fabrica.createFacturaDAO();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() throws Exception{
        System.out.println("update");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO instance = fabrica.createFacturaDAO();
        Factura fac = instance.findByIdFactura(1);
        fac.setTotal(100);
        instance.update(fac);
    }
    
    @Test
    public void testDelete() throws Exception{
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO instance = fabrica.createFacturaDAO();
        Factura fac = instance.findByIdFactura(1);
        instance.delete(fac);
    }
    
    @Test
    public void testFindByIdFactura() throws Exception{
        System.out.println("findByIdFactura");
        int idFactura = 1;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO instance = fabrica.createFacturaDAO();
        Factura fac = instance.findByIdFactura(idFactura);
        System.out.println(fac.getIdFactura());
    }

    /**
     * Test of findByAll method, of class FacturaDAOImpl.
     */
    @Test
    public void testFindByAll() throws Exception{
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO instance = fabrica.createFacturaDAO();
        List<Factura> result = instance.findByAll();
        for (Factura result1 : result) {
            System.out.println(result1.getIdFactura());
        }
    }

    /**
     * Test of findByFecha method, of class FacturaDAOImpl.
     */
    @Test
    public void testFindByFecha() throws Exception{
        System.out.println("findByAll");
        Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
        calendario.set(2015, 3, 27);
        Date fecha = calendario.getTime();
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO instance = fabrica.createFacturaDAO();
        List<Factura> result = instance.findByFecha(fecha);
        for (Factura result1 : result) {
            System.out.println(result1.getFecha());
        }
    }

    /**
     * Test of findByTotal method, of class FacturaDAOImpl.
     */
    @Test
    public void testFindByTotal() throws Exception{
        System.out.println("findByTotal");
        float total = 100;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IFacturaDAO instance = fabrica.createFacturaDAO();
        List<Factura> result = instance.findByTotal(total);
        for (Factura result1 : result) {
            System.out.println(result1.getIdFactura());
        }
    }
}
