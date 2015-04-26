/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedor;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedorPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.Municipio;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ColsutecR
 */
public class DomicilioProveedorDAOImplTest {
    
    DomicilioProveedor entity = new DomicilioProveedor();
    
    public DomicilioProveedorDAOImplTest() {
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
    @Test
    public void testInsert(){
        System.out.println("Insert");
        DomicilioProveedorDAOImpl instance = new DomicilioProveedorDAOImpl();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate(){
        System.out.println("Update");
        entity.setBarrio("San Mateo");
        DomicilioProveedorDAOImpl instance = new DomicilioProveedorDAOImpl();
        instance.update(entity);
    }
    
    @Test
    public void testDelete(){
        System.out.println("Delete");
        DomicilioProveedorDAOImpl instance = new DomicilioProveedorDAOImpl();
        DomicilioProveedor dpt = instance.findByIdDomicilioProveedor(new DomicilioProveedorPK("CC", "12334455"));
        instance.delete(dpt);
    }
    
    @Test
    public void testFindByAll(){
        System.out.println("FindAll");
        DomicilioProveedorDAOImpl instance = new DomicilioProveedorDAOImpl();
        List<DomicilioProveedor> result = instance.findByAll();
        for (DomicilioProveedor domiciliosProveedorT : result) {
            System.out.println(domiciliosProveedorT.getDomicilioProveedorPK());
        }
    }
    
    @Test
    public void testFindByIdDomicilioProveedor(){
        System.out.println("FindByIdDomicilioProveedor");
        DomicilioProveedor domicilioProveedorT;
        DomicilioProveedorPK dppk = new DomicilioProveedorPK("CC", "12334455");
        DomicilioProveedorDAOImpl instance = new DomicilioProveedorDAOImpl();
        domicilioProveedorT = instance.findByIdDomicilioProveedor(dppk);
        System.out.println(domicilioProveedorT.getDomicilioProveedorPK());
    }
    
    @Test
    public void testFindByTelefono(){
        System.out.println("FindByTelefono");
        String telefono = "12345";
        DomicilioProveedorDAOImpl instance = new DomicilioProveedorDAOImpl();
        List<DomicilioProveedor> result = instance.findByTelefono(telefono);
        for (DomicilioProveedor domicilioProveedorT : result) {
            System.out.println(domicilioProveedorT.getDomicilioProveedorPK());
        }
    }
    
    @Test
    public void testFindByDireccion(){
        System.out.println("FindByDireccion");
        String direccion = "KR 5 # 11-54";
        DomicilioProveedorDAOImpl instance = new DomicilioProveedorDAOImpl();
        List<DomicilioProveedor> result = instance.findByDireccion(direccion);
        for (DomicilioProveedor domicilioProveedorT : result) {
            System.out.println(domicilioProveedorT.getDomicilioProveedorPK());
        }
    }
    
    @Test
    public void testFindByBarrio(){
        System.out.println("FindByBarrio");
        String barrio = "San Mateo";
        DomicilioProveedorDAOImpl instance = new DomicilioProveedorDAOImpl();
        List<DomicilioProveedor> result = instance.findByBarrio(barrio);
        for (DomicilioProveedor domicilioProveedorT : result) {
            System.out.println(domicilioProveedorT.getDomicilioProveedorPK());
        }
    }
    
    @Test
    public void testFindByLocalidad(){
        System.out.println("FindByLocalidad");
        String localidad = "Barrios Unidos";
        DomicilioProveedorDAOImpl instance = new DomicilioProveedorDAOImpl();
        List<DomicilioProveedor> result = instance.findByLocalidad(localidad);
        for (DomicilioProveedor domicilioProveedorT : result) {
            System.out.println(domicilioProveedorT.getDomicilioProveedorPK());
        }
    }
}
