/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.Entity;
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
public class ProductoTestJPA {
    
    Producto producto;
    EntityManager em;
    
    public ProductoTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        producto = new Producto();
        producto.setIdProducto("001");
        producto.setMarca("Fander");
        producto.setNombre("Guitarra Electrica");
        producto.setMaterial("Caoba");
        producto.setReferencia("xxz");
        producto.setDescripcion("Guitarra Electrica referencia xxz marca fander");
        producto.setActivo(true);
        producto.setCantidad(5);
        producto.setColor("Negro");
        producto.setDescuento(0);
        producto.setPrecioUnitario(600000);
        producto.setCategoriaidCategoria(new Categoria(1));
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
    public void insertarProducto(){
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(producto);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void actualizarProducto(){
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto a Actualizar");
        String nombreActualizar = JOptionPane.showInputDialog("Digite el nombre del Producto");
        producto.setIdProducto(idProductoLeido);
        producto.setNombre(nombreActualizar);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(producto);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    
    
    @Test
    public void eliminarProducto() {
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto a Eliminar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Producto.class,idProductoLeido));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void buscarProductoPorId() {
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Producto productoTemporal = em.find(Producto.class,idProductoLeido);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(productoTemporal.toString());
    }
    
    @Test
    public void buscarProductoPorNombre() {
        String productoLeido = JOptionPane.showInputDialog("Digite el nombre del Producto a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findByNombre");
        q.setParameter("nombre", productoLeido);
        List<Producto> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Producto productoT : lis) {
            System.out.println(productoT.toString());
        }
    }
    
    @Test
    public void buscarProductoPorMarca() {
        String productoLeido = JOptionPane.showInputDialog("Digite la marca del Producto a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findByMarca");
        q.setParameter("marca", productoLeido);
        List<Producto> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Producto productoT : lis) {
            System.out.println(productoT.toString());
        }
    }
    
    @Test
    public void buscarProductoPorReferencia() {
        String productoLeido = JOptionPane.showInputDialog("Digite la referencia del Producto a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findByReferencia");
        q.setParameter("referencia", productoLeido);
        List<Producto> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Producto productoT : lis) {
            System.out.println(productoT.toString());
        }
    }
    
    @Test
    public void buscarProductoPorDescripcion() {
        String productoLeido = JOptionPane.showInputDialog("Digite la descripción del Producto a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findByDescripcion");
        q.setParameter("descripcion", productoLeido);
        List<Producto> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Producto productoT : lis) {
            System.out.println(productoT.toString());
        }
    }
    
    @Test
    public void buscarProductoPorMaterial() {
        String productoLeido = JOptionPane.showInputDialog("Digite el material del Producto a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findByMaterial");
        q.setParameter("material", productoLeido);
        List<Producto> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Producto productoT : lis) {
            System.out.println(productoT.toString());
        }
    }
    
    @Test
    public void buscarProductoPorColor() {
        String productoLeido = JOptionPane.showInputDialog("Digite el color del Producto a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findByColor");
        q.setParameter("color", productoLeido);
        List<Producto> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Producto productoT : lis) {
            System.out.println(productoT.toString());
        }
    }
    
    @Test
    public void buscarProductoPorCantidad() {
        String productoLeido = JOptionPane.showInputDialog("Digite la cantidad del Producto a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findByCantidad");
        q.setParameter("cantidad", Integer.parseInt(productoLeido));
        List<Producto> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Producto productoT : lis) {
            System.out.println(productoT.toString());
        }
    }
    
    @Test
    public void buscarProductoPorActivo() {
        String productoLeido = JOptionPane.showInputDialog("Digite el activo del Producto a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findByActivo");
        q.setParameter("activo", Boolean.parseBoolean(productoLeido));
        List<Producto> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Producto productoT : lis) {
            System.out.println(productoT.toString());
        }
    }
    
    @Test
    public void buscarProductoPorPrecioUnitario() {
        String productoLeido = JOptionPane.showInputDialog("Digite el precio unitario del Producto a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findByPrecioUnitario");
        q.setParameter("precioUnitario", Float.parseFloat(productoLeido));
        List<Producto> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Producto productoT : lis) {
            System.out.println(productoT.toString());
        }
    }
    
    @Test
    public void buscarProductoPorDescuento() {
        String productoLeido = JOptionPane.showInputDialog("Digite el descuento del Producto a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Producto.findByDescuento");
        q.setParameter("descuento", Float.parseFloat(productoLeido));
        List<Producto> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Producto productoT : lis) {
            System.out.println(productoT.toString());
        }
    }  
}