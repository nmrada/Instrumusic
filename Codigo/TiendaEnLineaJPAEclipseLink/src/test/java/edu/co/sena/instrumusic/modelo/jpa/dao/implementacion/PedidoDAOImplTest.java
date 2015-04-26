/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.entities.Pedido;
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
public class PedidoDAOImplTest {
    
    Pedido entity = new Pedido();
    
    public PedidoDAOImplTest() {
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

    /**
     * Test of insert method, of class PedidoDAOImpl.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        PedidoDAOImpl instance = new PedidoDAOImpl();
        instance.insert(entity);
    }

    /**
     * Test of update method, of class PedidoDAOImpl.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        entity.setImpuestos(300000);
        PedidoDAOImpl instance = new PedidoDAOImpl();
        instance.update(entity);
    }

    /**
     * Test of delete method, of class PedidoDAOImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        PedidoDAOImpl instance = new PedidoDAOImpl();
        Pedido pedido = instance.findByIdPedido(1);
        instance.delete(entity);
        
    }

    /**
     * Test of findByIdPedido method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindByIdPedido() {
        System.out.println("findByIdPedido");
        Pedido pedido;
        int idFactura = 1;
        PedidoDAOImpl instance = new PedidoDAOImpl();
        pedido = instance.findByIdPedido(idFactura);
        System.out.println(pedido.getFacturaidFactura());
    }

    /**
     * Test of findByAll method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        PedidoDAOImpl instance = new PedidoDAOImpl();
        List<Pedido> result = instance.findByAll();
        for (Pedido result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByFacturaidFactura method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindByFacturaidFactura() {
        System.out.println("findByFacturaidFactura");
        int idFactura = 1;
        PedidoDAOImpl instance = new PedidoDAOImpl();
        List<Pedido> result = instance.findByFacturaidFactura(idFactura);
        for (Pedido result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByTotal method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindByTotal() {
        System.out.println("findByTotal");
        double total = 600000;
        PedidoDAOImpl instance = new PedidoDAOImpl();
        List<Pedido> result = instance.findByTotal(total);
        for (Pedido result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findBySubtotal method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindBySubtotal() {
        System.out.println("findBySubtotal");
        double subtotal = 540000;
        PedidoDAOImpl instance = new PedidoDAOImpl();
        List<Pedido> result = instance.findBySubtotal(subtotal);
        for (Pedido result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }

    /**
     * Test of findByImpuestos method, of class PedidoDAOImpl.
     */
    @Test
    public void testFindByImpuestos() {
        System.out.println("findByImpuestos");
        double impuestos = 60000;
        PedidoDAOImpl instance = new PedidoDAOImpl();
        List<Pedido> result = instance.findByImpuestos(impuestos);
        for (Pedido result1 : result) {
            System.out.println(result1.getFacturaidFactura());
        }
    }
    
}
