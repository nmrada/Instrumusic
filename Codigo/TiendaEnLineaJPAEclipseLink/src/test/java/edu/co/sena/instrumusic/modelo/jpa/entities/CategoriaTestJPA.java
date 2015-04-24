/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.Categoria;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
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
public class CategoriaTestJPA {

    Categoria categoria;
    EntityManager em;

    public CategoriaTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        categoria = new Categoria();
        categoria.setNombreCategoria("Categoria 1");
        categoria.setActiva(true);
        categoria.setCategoriaidCategoria(new Categoria(1));
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
    public void insertarCategoria() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(categoria);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarCategoria() {
        String categoriaLeida = JOptionPane.showInputDialog("Digite el Id de Categoria a Actualizar");
        String nombreActualizar = JOptionPane.showInputDialog("Digite el nombre");
        categoria.setIdCategoria(Integer.parseInt(categoriaLeida));
        categoria.setNombreCategoria(nombreActualizar);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(categoria);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarCategoria() {
        String categoriaLeida = JOptionPane.showInputDialog("Digite el Id de Categoria a Eliminar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Categoria.class, Integer.parseInt(categoriaLeida)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void buscarCategoriaPorId() {
        String categoriaLeida = JOptionPane.showInputDialog("Digite el Id de Categoria a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Categoria categoriaTemporal = em.find(Categoria.class, Integer.parseInt(categoriaLeida));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(categoriaTemporal.toString());
    }
    
    @Test
    public void buscarCategoriaPorNombre() {
        String categoriaLeida = JOptionPane.showInputDialog("Digite el nombre de Categoria a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Categoria.findByNombreCategoria");
        q.setParameter("nombreCategoria", categoriaLeida);
        List<Categoria> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Categoria categoriaT : lis) {
            System.out.println(categoriaT.toString());
        }
    }
    
    @Test
    public void buscarCategoriaPorActiva() {
        String categoriaLeida = JOptionPane.showInputDialog("Digite la activa de la Categoria a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Categoria.findByActiva");
        q.setParameter("activa", Boolean.parseBoolean(categoriaLeida));
        List<Categoria> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Categoria categoriaT : lis) {
            System.out.println(categoriaT.toString());
        }
    }

}
