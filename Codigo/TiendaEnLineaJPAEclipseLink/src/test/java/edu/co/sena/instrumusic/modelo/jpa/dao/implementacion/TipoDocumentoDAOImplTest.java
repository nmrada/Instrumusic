/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.entities.TipoDocumento;
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
public class TipoDocumentoDAOImplTest {

    TipoDocumento entity = new TipoDocumento();

    public TipoDocumentoDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity.setTipoDocumento("CC");
        entity.setDescripcion("Cedula de Ciudadania");
        entity.setActivo(true);
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
    public void testInsert(){
        System.out.println("Insert");
        TipoDocumentoDAOImpl instance = new TipoDocumentoDAOImpl();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate(){
        System.out.println("Update");
        entity.setDescripcion("Cedula de Ciudadania Colombia");
        TipoDocumentoDAOImpl instance = new TipoDocumentoDAOImpl();
        instance.update(entity);
    }
    
    @Test
    public void testDelete(){
        System.out.println("Delete");
        TipoDocumentoDAOImpl instance = new TipoDocumentoDAOImpl();
        TipoDocumento tdt = instance.findByTipoDocumento("CC");
        instance.delete(tdt);
    }
    
    @Test
    public void testFindByTipoDocumento(){
        System.out.println("FindByTipoDocumento");
        TipoDocumento tdt;
        String tipoDocumento = "CC";
        TipoDocumentoDAOImpl instance = new TipoDocumentoDAOImpl();
        tdt= instance.findByTipoDocumento(tipoDocumento);
        System.out.println(tdt.getTipoDocumento());
    }
    
    @Test
    public void testFindAll(){
        System.out.println("FindAll");
        TipoDocumentoDAOImpl instance = new TipoDocumentoDAOImpl();
        List<TipoDocumento> result = instance.findByAll();
        for (TipoDocumento tipoDocumento : result) {
            System.out.println(tipoDocumento.getTipoDocumento());
        }
    }
    
    @Test
    public void testFindByDescripcion(){
        System.out.println("FindByDescripcion");
        String descripcion = "Cedula de Ciudadania Colombia";
        TipoDocumentoDAOImpl instance = new TipoDocumentoDAOImpl();
        List<TipoDocumento> result = instance.findByDescripcion(descripcion);
        for (TipoDocumento tipoDocumento : result) {
            System.out.println(tipoDocumento.getTipoDocumento());
        }
    }
    
    @Test
    public void testFindByActivo(){
        System.out.println("FindByActivo");
        boolean activo = true;
        TipoDocumentoDAOImpl instance = new TipoDocumentoDAOImpl();
        List<TipoDocumento> result = instance.findByActivo(activo);
        for (TipoDocumento tipoDocumento : result) {
            System.out.println(tipoDocumento.getTipoDocumento());
        }
    }
}
