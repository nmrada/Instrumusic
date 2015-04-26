/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IPagoDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Pago;
import java.util.List;
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
public class PagoDAOTest {
    
    Pago entity = new Pago();
    
    public PagoDAOTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    @Test
    public void testInsert()throws Exception{
        
        System.out.println("insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPagoDAO instance = fabrica.createPagoDAO();
        instance.insert(entity);
    }

    
    /**
     * Test of update method, of class IPagoDAO.
     */
    
    @Test
    public void testUpdate()throws Exception {
        System.out.println("update");
        entity.setBanco("Banco De Bogotá");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPagoDAO instance = fabrica.createPagoDAO();
        instance.update(entity);
    }

    /**
     * Test of delete method, of class IPagoDAO.
     */
    @Test
    public void testDelete()throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPagoDAO instance = fabrica.createPagoDAO();
        Pago pago = instance.findByIdPago(1);
        instance.delete(entity);
    }

    /**
     * Test of findByIdPago method, of class IPagoDAO.
     */
    @Test
    public void testFindByIdPago()throws Exception {
        System.out.println("findByIdPago");
        int idFactura = 1;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPagoDAO instance = fabrica.createPagoDAO();
        Pago result = instance.findByIdPago(idFactura);
        System.out.println(result.getFacturaidFactura());
    }

    /**
     * Test of findByAll method, of class IPagoDAO.
     */
    @Test
    public void testFindByAll()throws Exception {
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPagoDAO instance = fabrica.createPagoDAO();
        List<Pago> result = instance.findByAll();
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByFacturaidFactura method, of class IPagoDAO.
     */
    @Test
    public void testFindByFacturaidFactura()throws Exception {
        System.out.println("findByFacturaidFactura");
        int idFactura = 1;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPagoDAO instance = fabrica.createPagoDAO();
        List<Pago> result = instance.findByFacturaidFactura(idFactura);
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByNumTarCredito method, of class IPagoDAO.
     */
    @Test
    public void testFindByNumTarCredito()throws Exception {
        System.out.println("findByNumTarCredito");
        String numTarjetaCredito = "12348554664";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPagoDAO instance = fabrica.createPagoDAO();
        List<Pago> result = instance.findByNumTarCredito(numTarjetaCredito);
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByBanco method, of class IPagoDAO.
     */
    @Test
    public void testFindByBanco()throws Exception {
        System.out.println("findByBanco");
        String banco = "Banco De Bogotá";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPagoDAO instance = fabrica.createPagoDAO();
        List<Pago> result = instance.findByBanco(banco);
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByTipoCuentaTar method, of class IPagoDAO.
     */
    @Test
    public void testFindByTipoCuentaTar()throws Exception {
        System.out.println("findByTipoCuentaTar");
        String tipoCuetaTar = "Ahorros";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPagoDAO instance = fabrica.createPagoDAO();
        List<Pago> result = instance.findByTipoCuentaTar(tipoCuetaTar);
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByTipoTransaccion method, of class IPagoDAO.
     */
    @Test
    public void testFindByTipoTransaccion()throws Exception {
        System.out.println("findByTipoTransaccion");
        String tipoTransaccion = "ATH";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPagoDAO instance = fabrica.createPagoDAO();
        List<Pago> result = instance.findByTipoTransaccion(tipoTransaccion);
        for (Pago result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }
}
