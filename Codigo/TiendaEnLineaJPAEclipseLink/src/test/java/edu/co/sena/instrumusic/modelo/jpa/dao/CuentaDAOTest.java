/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ICuentaDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IDomicilioProveedorDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IMunicipioDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Cuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.CuentaPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedor;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedorPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.Municipio;
import edu.co.sena.instrumusic.modelo.jpa.entities.Usuario;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class CuentaDAOTest {

    Cuenta entity = new Cuenta();

    public CuentaDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        entity.setCuentaPK(new CuentaPK("CC", "1023006468"));
        entity.setPrimerNombre("Maicol");
        entity.setSegundoNombre("Steven");
        entity.setPrimerApellido("Chunza");
        entity.setSegundoApellido("Alfonso");
        entity.setUsuarioidUsuario(new Usuario("usuario1"));
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
        System.out.println("Insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO instance = fabrica.createCuentaDAO();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        entity.setSegundoNombre("Alberto");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO instance = fabrica.createCuentaDAO();
        instance.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO instance = fabrica.createCuentaDAO();
        Cuenta ut = instance.findByIdCuenta(new CuentaPK("CC", "1023006468"));
        instance.delete(ut);
    }
    
    @Test
    public void testFindAll() throws Exception {
        System.out.println("FindAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO instance = fabrica.createCuentaDAO();
        List<Cuenta> result = instance.findByAll();
        for (Cuenta CuentaTem : result) {
            System.out.println(CuentaTem.getCuentaPK());
        }
    }
    
     @Test
    public void testFindByIdCuenta() throws Exception{
        System.out.println("FindByIdCuenta");
        Cuenta cuenTem;
        CuentaPK cu = new CuentaPK("CC", "1023006468");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO instance = fabrica.createCuentaDAO();
        cuenTem = instance.findByIdCuenta(cu);
        System.out.println(cuenTem.getCuentaPK());
    }
    
    
    @Test
    public void testFindByPrimerNombre() throws Exception {
        System.out.println("FindByPrimerNombre");
        String primerNombre = "Maicol";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO instance = fabrica.createCuentaDAO();
        List<Cuenta> result = instance.findByPrimerNombre(primerNombre);
        for (Cuenta result1 : result) {
            System.out.println(result1.getCuentaPK());
        }
    }   
    
     @Test
    public void testFindBySegundoNombre() throws Exception {
        System.out.println("FindBySegundoNombre");
        String segundoNombre = "Alberto";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO instance = fabrica.createCuentaDAO();
        List<Cuenta> result = instance.findBySegundoNombre(segundoNombre);
        for (Cuenta result1 : result) {
            System.out.println(result1.getCuentaPK());
        }
    }   
    
     @Test
    public void testFindByPrimerApellido() throws Exception {
        System.out.println("FindByPrimerApellido");
        String primerApellido = "Chunza";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO instance = fabrica.createCuentaDAO();
        List<Cuenta> result = instance.findByPrimerApellido(primerApellido);
        for (Cuenta result1 : result) {
            System.out.println(result1.getCuentaPK());
        }
    }   
    
     @Test
    public void testFindBySegundoApellido() throws Exception {
        System.out.println("FindBySegundoApellido");
        String segundoApellido = "Alfonso";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO instance = fabrica.createCuentaDAO();
        List<Cuenta> result = instance.findBySegundoApellido(segundoApellido);
        for (Cuenta result1 : result) {
            System.out.println(result1.getCuentaPK());
        }
    }   
}
