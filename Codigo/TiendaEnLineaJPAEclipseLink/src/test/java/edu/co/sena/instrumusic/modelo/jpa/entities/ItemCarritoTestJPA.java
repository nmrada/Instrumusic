/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarrito;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarritoPK;
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
 * @author Nicolas
 */
public class ItemCarritoTestJPA {

    ItemCarrito itemCarrito;
    EntityManager em;

    public ItemCarritoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        itemCarrito = new ItemCarrito();
        itemCarrito.setCantidad(2);
        itemCarrito.setCostoTotal(540000);
        itemCarrito.setCostoUnitario(270000);
        ItemCarritoPK itemCarritoPK = new ItemCarritoPK();
        itemCarritoPK.setProductoidProducto("001");
        itemCarritoPK.setCarritoDeComprasidCarritoDeCompras("QWERTY123456");
        itemCarrito.setItemCarritoPK(itemCarritoPK);
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
    public void insertarItemCarrito() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(itemCarrito);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarItemCarrito() {
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto del Item a Actualizar");
        String idCarritoLeido = JOptionPane.showInputDialog("Digite el Id del Carrito del Item a Actualizar");
        String cantidadActualizar = JOptionPane.showInputDialog("Digite la cantidad");
        itemCarrito.setItemCarritoPK(new ItemCarritoPK(idProductoLeido, idCarritoLeido));
        itemCarrito.setCantidad(Integer.parseInt(cantidadActualizar));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(itemCarrito);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarItemCarrito() {
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto del Item a Eliminar");
        String idCarritoLeido = JOptionPane.showInputDialog("Digite el Id del Carrito del Item a Eliminar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(ItemCarrito.class, new ItemCarritoPK(idProductoLeido, idCarritoLeido)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }   
    
    @Test
    public void buscarUnItemCarrito() {
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto del Item a Buscar");
        String idCarritoLeido = JOptionPane.showInputDialog("Digite el Id del Carrito del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        ItemCarrito itemCarritoTemporal = em.find(ItemCarrito.class, new ItemCarritoPK(idProductoLeido, idCarritoLeido));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(itemCarritoTemporal.toString());
    }
    
    
    @Test
    public void buscarItemCarritoPorCantidad() {
        String itemCarritoLeido = JOptionPane.showInputDialog("Digite la cantidad del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("ItemCarrito.findByCantidad");
        q.setParameter("cantidad", Integer.parseInt(itemCarritoLeido));
        List<ItemCarrito> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (ItemCarrito itemCarritoT : lis) {
            System.out.println(itemCarritoT.toString());
        }
    }
    
    @Test
    public void buscarItemCarritoPorCostoUnitario() {
        String itemCarritoLeido = JOptionPane.showInputDialog("Digite el costo unitario del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("ItemCarrito.findByCostoUnitario");
        q.setParameter("costoUnitario", Float.parseFloat(itemCarritoLeido));
        List<ItemCarrito> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (ItemCarrito itemCarritoT : lis) {
            System.out.println(itemCarritoT.toString());
        }
    }
    
    @Test
    public void buscarItemCarritoPorCostoTotal() {
        String itemCarritoLeido = JOptionPane.showInputDialog("Digite el costo total del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("ItemCarrito.findByCostoTotal");
        q.setParameter("costoTotal", Float.parseFloat(itemCarritoLeido));
        List<ItemCarrito> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (ItemCarrito itemCarritoT : lis) {
            System.out.println(itemCarritoT.toString());
        }
    }
    
    @Test
    public void buscarItemCarritoPorIdProducto() {
        String itemCarritoLeido = JOptionPane.showInputDialog("Digite el id del Producto del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("ItemCarrito.findByProductoidProducto");
        q.setParameter("productoidProducto", itemCarritoLeido);
        List<ItemCarrito> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (ItemCarrito itemCarritoT : lis) {
            System.out.println(itemCarritoT.toString());
        }
    }
    
    @Test
    public void buscarItemCarritoPorIdCarritoDeCompras() {
        String itemCarritoLeido = JOptionPane.showInputDialog("Digite el id del carrito de compras del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("ItemCarrito.findByCarritoDeComprasidCarritoDeCompras");
        q.setParameter("carritoDeComprasidCarritoDeCompras", itemCarritoLeido);
        List<ItemCarrito> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (ItemCarrito itemCarritoT : lis) {
            System.out.println(itemCarritoT.toString());
        }
    }
}
