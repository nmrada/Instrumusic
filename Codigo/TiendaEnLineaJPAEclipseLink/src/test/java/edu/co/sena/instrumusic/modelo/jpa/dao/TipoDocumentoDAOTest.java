/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ITipoDocumentoDAO;
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
public class TipoDocumentoDAOTest {
    
    TipoDocumento entity = new TipoDocumento();
    
    public TipoDocumentoDAOTest() {
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
    public void testInsert() throws Exception{
        System.out.println("Insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ITipoDocumentoDAO instance = fabrica.createTipoDocumentoDAO();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() throws Exception{
        System.out.println("Update");
        entity.setDescripcion("Cedula de Ciudadania Colombia");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ITipoDocumentoDAO instance = fabrica.createTipoDocumentoDAO();
        instance.update(entity);
    }
    
    @Test
    public void testDelete() throws Exception{
        System.out.println("Delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ITipoDocumentoDAO instance = fabrica.createTipoDocumentoDAO();
        TipoDocumento tdt = instance.findByTipoDocumento("CC");
        instance.delete(tdt);
    }
    
    @Test
    public void testFindByTipoDocumento() throws Exception{
        System.out.println("FindByTipoDocumento");
        TipoDocumento tdt;
        String tipoDocumento = "CC";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ITipoDocumentoDAO instance = fabrica.createTipoDocumentoDAO();
        tdt= instance.findByTipoDocumento(tipoDocumento);
        System.out.println(tdt.getTipoDocumento());
    }
    
    @Test
    public void testFindAll() throws Exception{
        System.out.println("FindAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ITipoDocumentoDAO instance = fabrica.createTipoDocumentoDAO();
        List<TipoDocumento> result = instance.findByAll();
        for (TipoDocumento tipoDocumento : result) {
            System.out.println(tipoDocumento.getTipoDocumento());
        }
    }
    
    @Test
    public void testFindByDescripcion() throws Exception{
        System.out.println("FindByDescripcion");
        String descripcion = "Cedula de Ciudadania Colombia";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ITipoDocumentoDAO instance = fabrica.createTipoDocumentoDAO();
        List<TipoDocumento> result = instance.findByDescripcion(descripcion);
        for (TipoDocumento tipoDocumento : result) {
            System.out.println(tipoDocumento.getTipoDocumento());
        }
    }
    
    @Test
    public void testFindByActivo() throws Exception{
        System.out.println("FindByActivo");
        boolean activo = true;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ITipoDocumentoDAO instance = fabrica.createTipoDocumentoDAO();
        List<TipoDocumento> result = instance.findByActivo(activo);
        for (TipoDocumento tipoDocumento : result) {
            System.out.println(tipoDocumento.getTipoDocumento());
        }
    }
}
