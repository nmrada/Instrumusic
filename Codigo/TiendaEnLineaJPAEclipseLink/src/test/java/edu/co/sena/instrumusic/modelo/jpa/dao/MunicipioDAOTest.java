/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IMunicipioDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Departamento;
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
public class MunicipioDAOTest {
    
    Municipio entity = new Municipio();

    public MunicipioDAOTest() {
    }
 
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        entity.setIdMunicipio("2000");
        entity.setNombre("Maicol2");        
        entity.setDepartamentoidDepartamento(new Departamento("33"));
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
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        entity.setNombre("Nicolas");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        instance.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        Municipio ut = instance.findByIdMunicipio("2000");
        instance.delete(ut);
    }
    
    @Test
    public void testFindByIdMunicipio() throws Exception {
        System.out.println("FindByIdMunicipio");
        Municipio ut;
        String idMunicipio = "2000";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        ut = instance.findByIdMunicipio(idMunicipio);
        System.out.println(ut.getIdMunicipio());
    }
    
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        List<Municipio> result = instance.findByAll();
        for (Municipio result1 : result) {
            System.out.println(result1.getIdMunicipio());
        }
    }
    
    @Test
    public void testFindByNombre() throws Exception {
        System.out.println("FindByNombre");
        String nombre = "Nicolas";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IMunicipioDAO instance = fabrica.createMunicipioDAO();
        List<Municipio> result = instance.findByNombre(nombre);
        for (Municipio result1 : result) {
            System.out.println(result1.getIdMunicipio());
        }
    }   
}
