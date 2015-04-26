/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IDomicilioProveedorDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedor;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedorPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.Municipio;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas
 */
public class DomicilioProveedorDAOTest {
    
    DomicilioProveedor entity = new DomicilioProveedor();
    
    public DomicilioProveedorDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity.setTelefono("12345");
        entity.setLocalidad("Barrios Unidos");
        entity.setBarrio("Britalia");
        entity.setDireccion("KR 5 # 11-54");
        entity.setMunicipioidMunicipio(new Municipio("524"));
        entity.setDomicilioProveedorPK(new DomicilioProveedorPK("CC", "12334455"));
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
        System.out.println("Insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioProveedorDAO instance = fabrica.createDomicilioProveedorDAO();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() throws Exception{
        System.out.println("Update");
        entity.setBarrio("San Mateo");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioProveedorDAO instance = fabrica.createDomicilioProveedorDAO();
        instance.update(entity);
    }
    
    @Test
    public void testDelete() throws Exception{
        System.out.println("Delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioProveedorDAO instance = fabrica.createDomicilioProveedorDAO();
        DomicilioProveedor dpt = instance.findByIdDomicilioProveedor(new DomicilioProveedorPK("CC", "12334455"));
        instance.delete(dpt);
    }
    
    @Test
    public void testFindByAll() throws Exception{
        System.out.println("FindAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioProveedorDAO instance = fabrica.createDomicilioProveedorDAO();
        List<DomicilioProveedor> result = instance.findByAll();
        for (DomicilioProveedor domiciliosProveedorT : result) {
            System.out.println(domiciliosProveedorT.getDomicilioProveedorPK());
        }
    }
    
    @Test
    public void testFindByIdDomicilioProveedor() throws Exception{
        System.out.println("FindByIdDomicilioProveedor");
        DomicilioProveedor domicilioProveedorT;
        DomicilioProveedorPK dppk = new DomicilioProveedorPK("CC", "12334455");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioProveedorDAO instance = fabrica.createDomicilioProveedorDAO();
        domicilioProveedorT = instance.findByIdDomicilioProveedor(dppk);
        System.out.println(domicilioProveedorT.getDomicilioProveedorPK());
    }
    
    @Test
    public void testFindByTelefono() throws Exception{
        System.out.println("FindByTelefono");
        String telefono = "12345";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioProveedorDAO instance = fabrica.createDomicilioProveedorDAO();
        List<DomicilioProveedor> result = instance.findByTelefono(telefono);
        for (DomicilioProveedor domicilioProveedorT : result) {
            System.out.println(domicilioProveedorT.getDomicilioProveedorPK());
        }
    }
    
    @Test
    public void testFindByDireccion() throws Exception{
        System.out.println("FindByDireccion");
        String direccion = "KR 5 # 11-54";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioProveedorDAO instance = fabrica.createDomicilioProveedorDAO();
        List<DomicilioProveedor> result = instance.findByDireccion(direccion);
        for (DomicilioProveedor domicilioProveedorT : result) {
            System.out.println(domicilioProveedorT.getDomicilioProveedorPK());
        }
    }
    
    @Test
    public void testFindByBarrio() throws Exception{
        System.out.println("FindByBarrio");
        String barrio = "San Mateo";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioProveedorDAO instance = fabrica.createDomicilioProveedorDAO();
        List<DomicilioProveedor> result = instance.findByBarrio(barrio);
        for (DomicilioProveedor domicilioProveedorT : result) {
            System.out.println(domicilioProveedorT.getDomicilioProveedorPK());
        }
    }
    
    @Test
    public void testFindByLocalidad() throws Exception{
        System.out.println("FindByLocalidad");
        String localidad = "Barrios Unidos";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDomicilioProveedorDAO instance = fabrica.createDomicilioProveedorDAO();
        List<DomicilioProveedor> result = instance.findByLocalidad(localidad);
        for (DomicilioProveedor domicilioProveedorT : result) {
            System.out.println(domicilioProveedorT.getDomicilioProveedorPK());
        }
    }
}
