/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.PagoDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.entities.Pago;
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
public class PagoDAOImplTest {
    
    Pago entity = new Pago();
    
    public PagoDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity = new Pago();
        entity.setFacturaidFactura(1);
        entity.setBanco("Banco AV Villas");
        entity.setNumTarCredito("12348554664");
        entity.setTipoCuentaTar("Ahorros");
        entity.setTipoTransaccion("ATH");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testInsert() {
        System.out.println("insert");
        PagoDAOImpl instance = new PagoDAOImpl();
        instance.insert(entity);
    }

    /**
     * Test of update method, of class IPagoDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        entity.setBanco("Banco De Bogotá");
        PagoDAOImpl instance = new PagoDAOImpl();
        instance.update(entity);
    }

    /**
     * Test of delete method, of class IPagoDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Pago entity = null;
        PagoDAOImpl instance = new PagoDAOImpl();
        Pago pago = instance.findByIdPago(1);
        instance.delete(entity);
    }

    /**
     * Test of findByIdPago method, of class IPagoDAO.
     */
    @Test
    public void testFindByIdPago() {
        System.out.println("findByIdPago");
        Integer idFactura = 1;
        PagoDAOImpl instance = new PagoDAOImpl();
        Pago result = instance.findByIdPago(idFactura);
        System.out.println(result.getFacturaidFactura());
    }

    /**
     * Test of findByAll method, of class IPagoDAO.
     */
    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        PagoDAOImpl instance = new PagoDAOImpl();
        List<Pago> result = instance.findByAll();
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByFacturaidFactura method, of class IPagoDAO.
     */
    @Test
    public void testFindByFacturaidFactura() {
        System.out.println("findByFacturaidFactura");
        Integer idFactura = 1;
        PagoDAOImpl instance = new PagoDAOImpl();
        List<Pago> result = instance.findByFacturaidFactura(idFactura);
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByNumTarCredito method, of class IPagoDAO.
     */
    @Test
    public void testFindByNumTarCredito() {
        System.out.println("findByNumTarCredito");
        String numTarjetaCredito = "12348554664";
        PagoDAOImpl instance = new PagoDAOImpl();
        List<Pago> result = instance.findByNumTarCredito(numTarjetaCredito);
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByBanco method, of class IPagoDAO.
     */
    @Test
    public void testFindByBanco() {
        System.out.println("findByBanco");
        String banco = "Ahorros";
        PagoDAOImpl instance = new PagoDAOImpl();
        List<Pago> result = instance.findByBanco(banco);
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByTipoCuentaTar method, of class IPagoDAO.
     */
    @Test
    public void testFindByTipoCuentaTar() {
        System.out.println("findByTipoCuentaTar");
        String tipoCuetaTar = "ATH";
        PagoDAOImpl instance = new PagoDAOImpl();
        List<Pago> result = instance.findByTipoCuentaTar(tipoCuetaTar);
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByTipoTransaccion method, of class IPagoDAO.
     */
    @Test
    public void testFindByTipoTransaccion() {
        System.out.println("findByTipoTransaccion");
        String tipoTransaccion = "";
        PagoDAOImpl instance = new PagoDAOImpl();
        List<Pago> result = instance.findByTipoTransaccion(tipoTransaccion);
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }
    
}
