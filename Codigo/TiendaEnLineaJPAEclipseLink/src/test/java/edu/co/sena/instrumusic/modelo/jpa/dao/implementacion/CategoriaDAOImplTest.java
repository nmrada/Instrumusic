/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

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
public class CategoriaDAOImplTest {

    public Categoria entity;

    public CategoriaDAOImplTest() {
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
        entity.setNombreCategoria("Categoria2");
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
    // Prueba del método de inserción, de clase CategoriaDAOImpl.
    @Test
    public void testInsert() {
        System.out.println("insert");
        
        CategoriaDAOImpl instance = new CategoriaDAOImpl();
        Categoria categoriaPadre = instance.findByIdCategoria(1);
        System.out.println(categoriaPadre.getNombreCategoria());
        entity.setCategoriaidCategoria(categoriaPadre);
        instance.insert(entity);
    }

    
    // Prueba del metodo update, de la clase CategoriaDAOImpl.
    @Test
    public void testUpdate() {
        System.out.println("update");
        entity.setNombreCategoria("Categoria Padre");
        CategoriaDAOImpl instance = new CategoriaDAOImpl();
        instance.update(entity);

    }

    //Prueba de Delate de  la clase CategoriaDAOImpl
    @Test
    public void testDelete() {
        System.out.println("delete");
        CategoriaDAOImpl instance = new CategoriaDAOImpl();
        Categoria cat = instance.findByIdCategoria(1);
        instance.delete(cat);

    }

    //Prueba de findByIdCategoria de  la clase CategoriaDAOImpl
    @Test
    public void testFindByIdCategoria() {
        System.out.println("findByIdCategoria");
        Categoria cat;
        int idCategoria = 1;
        CategoriaDAOImpl categoria = new CategoriaDAOImpl();
        cat = categoria.findByIdCategoria(idCategoria);
        System.out.println(cat.getIdCategoria());

    }
    
   //Prueba de FindByNombreCategoria en el metodo de la clase CategoriaDAOImpl. 
    @Test
    public void testFindByNombreCategoria(){
        System.out.println("findByNombreCategoria");
        String nombreCategoria ="Categoria Padre";
        CategoriaDAOImpl instance = new  CategoriaDAOImpl();
        List<Categoria> nomcat = instance.findByNombreCategoria(nombreCategoria);
        for (Categoria nomcat1 : nomcat) {
            System.out.println(nomcat1.getIdCategoria());
        }
                  
    }

    //Prueba de FindByActiva en el metodo de la clase CategoriaDAOImpl.
       @Test 
    public void testFindByActiva(){
        System.out.println("findByActiva");
        boolean activa  =true;
        CategoriaDAOImpl instance = new  CategoriaDAOImpl();
        List<Categoria> nomcat = instance.findByActiva(activa);
        for (Categoria nomcat1 : nomcat) {
            System.out.println(nomcat1.getIdCategoria());
        }
                  
    }
}
