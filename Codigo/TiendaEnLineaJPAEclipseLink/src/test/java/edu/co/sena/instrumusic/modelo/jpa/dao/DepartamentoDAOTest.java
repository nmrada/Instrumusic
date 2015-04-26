/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IDepartamentoDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Departamento;
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
public class DepartamentoDAOTest {
    
    Departamento entity = new Departamento();

    public DepartamentoDAOTest() {
    } 
       
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        entity.setIdDepartamento("33");
        entity.setNombre("Johana2");
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
        IDepartamentoDAO instance = fabrica.createDepartamentoDAO();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        entity.setNombre("Nicolas");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDepartamentoDAO instance = fabrica.createDepartamentoDAO();
        instance.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDepartamentoDAO instance = fabrica.createDepartamentoDAO();
        Departamento ut = instance.findByIdDepartamento("33");
        instance.delete(ut);
    }
    
    @Test
    public void testFindByIdDepartamento() throws Exception {
        System.out.println("FindByIdDepartamento");
        Departamento ut;
        String idDepatamento = "33";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDepartamentoDAO instance = fabrica.createDepartamentoDAO();
        ut = instance.findByIdDepartamento(idDepatamento);
        System.out.println(ut.getIdDepartamento());
    }
    
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDepartamentoDAO instance = fabrica.createDepartamentoDAO();
        List<Departamento> result = instance.findByAll();
        for (Departamento result1 : result) {
            System.out.println(result1.getIdDepartamento());
        }
    }
    
    @Test
    public void testFindByNombre() throws Exception {
        System.out.println("FindByNombre");
        String nombre = "johana2";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IDepartamentoDAO instance = fabrica.createDepartamentoDAO();
        List<Departamento> result = instance.findByNombre(nombre);
        for (Departamento result1 : result) {
            System.out.println(result1.getIdDepartamento());
        }
    }   
}
