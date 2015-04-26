/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IPedidoDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Pedido;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Alex
 */
public class PedidoDAOTest {
    
    Pedido entity = new Pedido();
    
    public PedidoDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity = new Pedido();
        entity.setFacturaidFactura(1);
        entity.setImpuestos(60000);
        entity.setSubtotal(540000);
        entity.setTotal(600000);
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
        IPedidoDAO instance = fabrica.createPedidoDAO();
        instance.insert(entity);
    }

    /**
     * Test of update method, of class PedidoDAOImpl.
     */
    @Test
    public void testUpdate() throws Exception{
        System.out.println("update");
        entity.setImpuestos(300000);
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        instance.update(entity);
    }

    /**
     * Test of delete method, of class PedidoDAOImpl.
     */
    @Test
    public void testDelete() throws Exception{
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        Pedido pedido = instance.findByIdPedido(1);
        instance.delete(entity);
        
    }

    /**
     * Test of findByIdPedido method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindByIdPedido() throws Exception{
        System.out.println("findByIdPedido");
        Pedido pedido;
        int idFactura = 1;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        pedido = instance.findByIdPedido(idFactura);
        System.out.println(pedido.getFacturaidFactura());
    }

    /**
     * Test of findByAll method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindByAll() throws Exception {
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        List<Pedido> result = instance.findByAll();
        for (Pedido result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByFacturaidFactura method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindByFacturaidFactura() throws Exception{
        System.out.println("findByFacturaidFactura");
        int idFactura = 1;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        List<Pedido> result = instance.findByFacturaidFactura(idFactura);
        for (Pedido result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByTotal method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindByTotal()throws Exception{
        System.out.println("findByTotal");
        float total = 600000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        List<Pedido> result = instance.findByTotal(total);
        for (Pedido result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findBySubtotal method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindBySubtotal()throws Exception{
        System.out.println("findBySubtotal");
        float subtotal = 540000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        List<Pedido> result = instance.findBySubtotal(subtotal);
        for (Pedido result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByImpuestos method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindByImpuestos()throws Exception {
        System.out.println("findByImpuestos");
        float impuestos = 300000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IPedidoDAO instance = fabrica.createPedidoDAO();
        List<Pedido> result = instance.findByImpuestos(impuestos);
        for (Pedido result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }
}
