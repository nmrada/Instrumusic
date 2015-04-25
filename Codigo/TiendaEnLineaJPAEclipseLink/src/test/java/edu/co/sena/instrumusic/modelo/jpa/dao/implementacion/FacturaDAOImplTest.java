/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.entities.Cuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.Factura;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
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
public class FacturaDAOImplTest {
    
    Factura entity = new Factura();
    EntityManager em;
    
    public FacturaDAOImplTest() {
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
        entity.setCuenta(new Cuenta("CC", "55889663"));
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class FacturaDAOImpl.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        FacturaDAOImpl instance = new FacturaDAOImpl();
        instance.insert(entity);
    }

    /**
     * Test of update method, of class FacturaDAOImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        entity.setTotal(1000000);
        FacturaDAOImpl instance = new FacturaDAOImpl();
        instance.update(entity);
    }

    /**
     * Test of delete method, of class FacturaDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Factura entity = null;
        FacturaDAOImpl instance = new FacturaDAOImpl();
        Factura fac = instance.findByIdFactura(1);
        instance.delete(fac);
    }

    /**
     * Test of findByIdFactura method, of class FacturaDAOImpl.
     */
    @Test
    public void testFindByIdFactura() {
        System.out.println("findByIdFactura");
        Factura fac;
        Integer idFactura = 1;
        FacturaDAOImpl factura = new FacturaDAOImpl();
        fac = factura.findByIdFactura(idFactura);
        System.out.println(fac.getIdFactura());
    }

    /**
     * Test of findByAll method, of class FacturaDAOImpl.
     */
    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        FacturaDAOImpl instance = new FacturaDAOImpl();
        List<Factura> result = instance.findByAll();
        for (Factura result1 : result) {
            System.out.println(result1.getIdFactura());
        }
    }

    /**
     * Test of findByFecha method, of class FacturaDAOImpl.
     */
    @Test
    public void testFindByFecha() {
        System.out.println("findByAll");
        Date fecha = new Date("12/12/12");
        FacturaDAOImpl instance = new FacturaDAOImpl();
        List<Factura> result = instance.findByAll();
        for (Factura result1 : result) {
            System.out.println(result1.getIdFactura());
        }
    }

    /**
     * Test of findByTotal method, of class FacturaDAOImpl.
     */
    @Test
    public void testFindByTotal() {
        System.out.println("findByTotal");
        Integer total = null;
        FacturaDAOImpl instance = new FacturaDAOImpl();
        List<Factura> expResult = null;
        List<Factura> result = instance.findByTotal(total);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
