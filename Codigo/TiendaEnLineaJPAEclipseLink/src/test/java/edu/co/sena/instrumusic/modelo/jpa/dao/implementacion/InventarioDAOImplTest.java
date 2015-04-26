/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.entities.Inventario;
import edu.co.sena.instrumusic.modelo.jpa.entities.InventarioPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.Proveedor;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.omg.CORBA.INVALID_ACTIVITY;

/**
 *
 * @author BERNATE
 */
public class InventarioDAOImplTest {

    Inventario entity = new Inventario();

    public InventarioDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity.setCantidad(7);
        Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
        Date fechaActual = calendario.getTime();
        entity.setFecha(fechaActual);
        entity.setInventarioPK(new InventarioPK("DA123","CC", "12334455"));
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
        System.out.println("insert");
        InventarioDAOImpl instance = new InventarioDAOImpl();
        instance.insert(entity);
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        entity.setCantidad(6);
        InventarioDAOImpl instance = new InventarioDAOImpl();
        instance.update(entity);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        InventarioDAOImpl instance = new InventarioDAOImpl();
        Inventario inv = instance.findByIdInventario(new InventarioPK(1, "CC", "12334455", "DA123"));
        instance.delete(inv);

    }

    @Test
    public void testFindByIdInventario() {
        System.out.println("findByIdInventario");
        Inventario inv;
        int idInventario = 1;
        String idNumeroDocuemento = "CC";
        String idTipoDocumento = "12334455";
        String idProducto = "DA123";

        InventarioDAOImpl inventario = new InventarioDAOImpl();
        inv = inventario.findByIdInventario(new InventarioPK(idInventario, idProducto, idTipoDocumento, idNumeroDocuemento));
        System.out.println(inv.getInventarioPK());

    }

    @Test
    public void testFindByAll() {
        System.out.println("findAll");
        InventarioDAOImpl instance = new InventarioDAOImpl();
        List<Inventario> result = instance.findAll();
        for (Inventario result1 : result) {
            System.out.println(result1.getInventarioPK());
        }
    }

      @Test
    public void testFindByCantidad() {
        System.out.println("findByCantidad");
        int cantidad = 6;
        InventarioDAOImpl instance = new InventarioDAOImpl();
        List<Inventario> result = instance.findByCantidad(cantidad);
        for (Inventario result1 : result) {
            System.out.println(result1.getCantidad());
        }
    }
    
    
      @Test
    public void testFindByFecha() {
        System.out.println("findByFecha");
        Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
        Date fechaActual = calendario.getTime();
        InventarioDAOImpl instance = new InventarioDAOImpl();
        List<Inventario> result = instance.findByFecha(fechaActual);
        for (Inventario result1 : result) {
            System.out.println(result1.getFecha());
        }
    }
}
