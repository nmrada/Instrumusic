/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IProveedorDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Proveedor;
import edu.co.sena.instrumusic.modelo.jpa.entities.ProveedorPK;
import java.util.List;
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
public class ProveedorDAOTest {

    Proveedor entity = new Proveedor();

    public ProveedorDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        entity.setProveedorPK(new ProveedorPK("CC", "12334455"));
        entity.setNombre("Instrumentos S.A");
        entity.setEmail("instru@yahoo.com");
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
        IProveedorDAO instance = fabrica.createProveedorDAO();
        instance.insert(entity);
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        entity.setEmail("Intrucmusic@hotmail.com");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProveedorDAO instance = fabrica.createProveedorDAO();
        instance.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProveedorDAO instance = fabrica.createProveedorDAO();
        Proveedor pro = instance.findByIdProveedor(new ProveedorPK("CC", "12334455"));
        instance.delete(pro);

    }

    @Test
    public void testFindByIdProveedor() throws Exception {
        System.out.println("findByIdProveedor");
        Proveedor pro;
        String idtipoDocumento = "CC";
        String idnumeroDocumento = "12334455";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProveedorDAO instance = fabrica.createProveedorDAO();
        pro = instance.findByIdProveedor(new ProveedorPK(idtipoDocumento, idnumeroDocumento));
        System.out.println(pro.getProveedorPK());

    }

    @Test
    public void testFindByAll() throws Exception {
        System.out.println("findAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProveedorDAO instance = fabrica.createProveedorDAO();
        List<Proveedor> result = instance.findAll();
        for (Proveedor result1 : result) {
            System.out.println(result1.getProveedorPK());
        }
    }

    @Test
    public void testFindByNombre() throws Exception {
        System.out.println("findByNombre");
        String nombre = "Instrumentos S.A";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProveedorDAO instance = fabrica.createProveedorDAO();
        List<Proveedor> result = instance.findByNombre(nombre);
        for (Proveedor result1 : result) {
            System.out.println(result1.getNombre());
        }
    }

    @Test
    public void testFindByEmail() throws Exception {
        System.out.println("findByEmail");
        String email = "Intrucmusic@hotmail.com";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProveedorDAO instance = fabrica.createProveedorDAO();
        List<Proveedor> result = instance.findByEmail(email);
        for (Proveedor result1 : result) {
            System.out.println(result1.getEmail());
        }
    }
}
