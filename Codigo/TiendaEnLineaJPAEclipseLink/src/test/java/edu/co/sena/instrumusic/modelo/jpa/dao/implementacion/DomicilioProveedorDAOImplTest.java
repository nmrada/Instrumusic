/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedor;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedorPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.Municipio;
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
        entity.setDomicilioProveedorPK(new DomicilioProveedorPK(null, null));
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {
}
