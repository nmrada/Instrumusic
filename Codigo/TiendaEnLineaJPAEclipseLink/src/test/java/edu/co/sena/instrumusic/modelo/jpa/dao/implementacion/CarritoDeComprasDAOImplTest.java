/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.entities.CarritoDeCompras;
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
public class CarritoDeComprasDAOImplTest {

    CarritoDeCompras entity = new CarritoDeCompras();

    public CarritoDeComprasDAOImplTest() {
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
    public void testInsert() {
        System.out.println("Insert");
        CarritoDeComprasDAOImpl instance = new CarritoDeComprasDAOImpl();
        instance.insert(entity);
    }

    @Test
    public void testUpdate() {
        System.out.println("Update");
        entity.setImpuestos(6000);
        CarritoDeComprasDAOImpl instance = new CarritoDeComprasDAOImpl();
        instance.update(entity);
    }

    @Test
    public void testDelete() {
        System.out.println("Delete");
        CarritoDeComprasDAOImpl instance = new CarritoDeComprasDAOImpl();
        CarritoDeCompras cct = instance.findByIdCarrito("QWERTY");
        instance.delete(cct);
    }
    
    @Test
    public void testFindByIdCarritoDeCompras() {
        System.out.println("FindByIdCarritoDeCompras");
        CarritoDeCompras cct;
        String idcarrito = "QWERTY";
        CarritoDeComprasDAOImpl carrito = new CarritoDeComprasDAOImpl();
        cct = carrito.findByIdCarrito(idcarrito);
        System.out.println(cct.getIdCarritoDeCompras());
    }
    
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        CarritoDeComprasDAOImpl instance = new CarritoDeComprasDAOImpl();
        List<CarritoDeCompras> result = instance.findByAll();
        for (CarritoDeCompras result1 : result) {
            System.out.println(result1.getIdCarritoDeCompras());
        }
    }
    
    @Test
    public void testFindByPrecioTotal() {
        System.out.println("FindByPrecioTotal");
        double total = 15000;
        CarritoDeComprasDAOImpl instance = new CarritoDeComprasDAOImpl();
        List<CarritoDeCompras> result = instance.findByTotal(total);
        for (CarritoDeCompras result1 : result) {
            System.out.println(result1.getIdCarritoDeCompras());
        }
    }
    
    @Test
    public void testFindBySubtotal() {
        System.out.println("FindBySubtotal");
        double subtotal = 10000;
        CarritoDeComprasDAOImpl instance = new CarritoDeComprasDAOImpl();
        List<CarritoDeCompras> result = instance.findBySubtotal(subtotal);
         for (CarritoDeCompras result1 : result) {
            System.out.println(result1.getIdCarritoDeCompras());
        }
    }
    
    @Test
    public void testFindByImpuestos() {
        System.out.println("FindByImpuestos");
        double impuestos = 6000;
        CarritoDeComprasDAOImpl instance = new CarritoDeComprasDAOImpl();
        List<CarritoDeCompras> result = instance.findByImpuestos(impuestos);
         for (CarritoDeCompras result1 : result) {
            System.out.println(result1.getIdCarritoDeCompras());
        }
    }
}
