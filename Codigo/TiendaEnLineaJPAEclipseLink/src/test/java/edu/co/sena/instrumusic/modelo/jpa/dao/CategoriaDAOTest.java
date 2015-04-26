/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ICategoriaDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Categoria;
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
public class CategoriaDAOTest {

    Categoria entity = new Categoria();

    public CategoriaDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity = new Categoria();
        entity.setNombreCategoria("Categoria");
        entity.setActiva(Boolean.TRUE);
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
        ICategoriaDAO instance = fabrica.createCategoriaDAO();
        Categoria categoriaPadre = instance.findByIdCategoria(1);
        System.out.println(categoriaPadre.getNombreCategoria());
        entity.setCategoriaidCategoria(categoriaPadre);
        instance.insert(entity);
    }

    // Prueba del metodo update, de la clase CategoriaDAOImpl.
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        entity.setNombreCategoria("Categoria Padre");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO instance = fabrica.createCategoriaDAO();
        instance.update(entity);

    }

    //Prueba de Delate de  la clase CategoriaDAOImpl
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO instance = fabrica.createCategoriaDAO();
        Categoria cat = instance.findByIdCategoria(1);
        instance.delete(cat);

    }

    //Prueba de findByIdCategoria de  la clase CategoriaDAOImpl
    @Test
    public void testFindByIdCategoria() throws Exception {
        System.out.println("findByIdCategoria");
        Categoria cat;
        int idCategoria = 1;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO instance = fabrica.createCategoriaDAO();
        cat = instance.findByIdCategoria(idCategoria);
        System.out.println(cat.getIdCategoria());

    }

    @Test
    public void testFindAll() throws Exception {
        System.out.println("FindAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO instance = fabrica.createCategoriaDAO();
        List<Categoria> nomcat = instance.findAll();
        for (Categoria nomcat1 : nomcat) {
            System.out.println(nomcat1.getIdCategoria());
        }
    }

    //Prueba de FindByNombreCategoria en el metodo de la clase CategoriaDAOImpl. 
    @Test
    public void testFindByNombreCategoria() throws Exception {
        System.out.println("findByNombreCategoria");
        String nombreCategoria = "Categoria Padre";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO instance = fabrica.createCategoriaDAO();
        List<Categoria> nomcat = instance.findByNombreCategoria(nombreCategoria);
        for (Categoria nomcat1 : nomcat) {
            System.out.println(nomcat1.getIdCategoria());
        }

    }

    //Prueba de FindByActiva en el metodo de la clase CategoriaDAOImpl.
    @Test
    public void testFindByActiva() throws Exception {
        System.out.println("findByActiva");
        boolean activa = true;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICategoriaDAO instance = fabrica.createCategoriaDAO();
        List<Categoria> nomcat = instance.findByActiva(activa);
        for (Categoria nomcat1 : nomcat) {
            System.out.println(nomcat1.getIdCategoria());
        }

    }

}