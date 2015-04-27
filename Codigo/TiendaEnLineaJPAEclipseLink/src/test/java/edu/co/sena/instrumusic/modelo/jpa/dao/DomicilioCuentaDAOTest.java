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
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IDomicilioCuentaDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IDomicilioProveedorDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioCuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioCuentaPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.Municipio;
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
public class DomicilioCuentaDAOTest {
    
    DomicilioCuenta entity = new DomicilioCuenta();

    public DomicilioCuentaDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        entity.setDomicilioCuentaPK(new DomicilioCuentaPK("CC", "1023006468"));
        entity.setTelefono("4521678");
        entity.setDireccion("Calle 84 C # 45-12");
        entity.setBarrio("santa librada");
        entity.setLocalidad("Usme");
        entity.setMunicipioidMunicipio(new Municipio("1"));
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
        IDomicilioCuentaDAO instance = fabrica.createDomicilioCuentaDAO();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        entity.setTelefono("3125124832");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioCuentaDAO instance = fabrica.createDomicilioCuentaDAO();
        instance.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioCuentaDAO instance = fabrica.createDomicilioCuentaDAO();
        DomicilioCuenta ut = instance.findByIdDomicilioCuenta(new DomicilioCuentaPK("CC", "1023006468"));
        instance.delete(ut);
    }
    
       
     @Test
    public void testFindByIdDomicilioCuenta() throws Exception{
        System.out.println("FindByIdDomicilioProveedor");
        DomicilioCuenta domicilioCuT;
        DomicilioCuentaPK dc = new DomicilioCuentaPK("CC", "1023006468");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioCuentaDAO instance = fabrica.createDomicilioCuentaDAO();
        domicilioCuT = instance.findByIdDomicilioCuenta(dc);
        System.out.println(domicilioCuT.getDomicilioCuentaPK());
    }
    
    
    @Test
    public void testFindByTelefono() throws Exception {
        System.out.println("FindByTelefono");
        String telefono = "4521678";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioCuentaDAO instance = fabrica.createDomicilioCuentaDAO();
        List<DomicilioCuenta> result = instance.findByTelefono(telefono);
        for (DomicilioCuenta result1 : result) {
            System.out.println(result1.getTelefono());
        }
    }   
    
     @Test
    public void testFindByDireccion() throws Exception {
        System.out.println("FindByDireccion");
        String direccion = "Calle 84 C # 45-12";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioCuentaDAO instance = fabrica.createDomicilioCuentaDAO();
        List<DomicilioCuenta> result = instance.findByDireccion(direccion);
        for (DomicilioCuenta result1 : result) {
            System.out.println(result1.getDireccion());
        }
    }   
    
     @Test
    public void testFindByBarrio() throws Exception {
        System.out.println("FindByPrimerApellido");
        String barrio = "santa librada";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioCuentaDAO instance = fabrica.createDomicilioCuentaDAO();
        List<DomicilioCuenta> result = instance.findByBario(barrio);
        for (DomicilioCuenta result1 : result) {
            System.out.println(result1.getBarrio());
        }
    }   
    
     @Test
    public void testFindByLocalidad() throws Exception {
        System.out.println("FindBySegundoApellido");
        String localidad = "Usme";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioCuentaDAO instance = fabrica.createDomicilioCuentaDAO();
        List<DomicilioCuenta> result = instance.findByLocalidad(localidad);
        for (DomicilioCuenta result1 : result) {
            System.out.println(result1.getLocalidad());
        }
    }   
}
