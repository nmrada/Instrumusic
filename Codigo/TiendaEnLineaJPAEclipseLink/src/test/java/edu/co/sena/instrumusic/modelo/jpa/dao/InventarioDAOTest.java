/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IInventarioDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Inventario;
import edu.co.sena.instrumusic.modelo.jpa.entities.InventarioPK;
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

/**
 *
 * @author BERNATE
 */
public class InventarioDAOTest {

    Inventario entity = new Inventario();

    public InventarioDAOTest() {
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
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO instance = fabrica.createInventarioDAO();
        instance.insert(entity);
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO instance = fabrica.createInventarioDAO();
        Inventario inv = instance.findByIdInventario(new InventarioPK(1, "DA123", "CC", "12334455"));
        inv.setCantidad(6);
        instance.update(inv);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO instance = fabrica.createInventarioDAO();
        Inventario inv = instance.findByIdInventario(new InventarioPK(1, "DA123", "CC", "12334455"));
        instance.delete(inv);

    }

    @Test
    public void testFindByIdInventario() throws Exception {
        System.out.println("findByIdInventario");
        Inventario inv;
        int idInventario = 1;
        
       String idNumeroDocuemento = "CC";
        String idTipoDocumento = "12334455";
        String idProducto = "DA123";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO instance = fabrica.createInventarioDAO();
        inv = instance.findByIdInventario(new InventarioPK(idInventario, idProducto, idTipoDocumento, idNumeroDocuemento));
        System.out.println(inv.getInventarioPK());

    }

    @Test
    public void testFindByAll() throws Exception {
        System.out.println("findAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO instance = fabrica.createInventarioDAO();
        List<Inventario> result = instance.findAll();
        for (Inventario result1 : result) {
            System.out.println(result1.getInventarioPK());
        }
    }

    @Test
    public void testFindByCantidad() throws Exception {
        System.out.println("findByCantidad");
        int cantidad = 6;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO instance = fabrica.createInventarioDAO();
        List<Inventario> result = instance.findByCantidad(cantidad);
        for (Inventario result1 : result) {
            System.out.println(result1.getCantidad());
        }
    }

    @Test
    public void testFindByFecha() throws Exception {
        System.out.println("findByFecha");
        Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
        calendario.set(2015, 3, 27);
        Date fechaActual = calendario.getTime();
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IInventarioDAO instance = fabrica.createInventarioDAO();
        List<Inventario> result = instance.findByFecha(fechaActual);
        for (Inventario result1 : result) {
            System.out.println(result1.getFecha());
        }
    }
}
