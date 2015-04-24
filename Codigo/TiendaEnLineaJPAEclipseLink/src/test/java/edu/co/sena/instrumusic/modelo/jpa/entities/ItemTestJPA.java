/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.Item;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemPK;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
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
public class ItemTestJPA {

    Item item;
    EntityManager em;

    public ItemTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        item = new Item();
        ItemPK itemPK = new ItemPK();
        itemPK.setPedidoFacturaidFactura(1);
        itemPK.setProductoidProducto("001");
        item.setItemPK(itemPK);
        item.setCantidad(2);
        item.setCostoUnitario(270000);
        item.setCostoTotal(540000);
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
    public void insertarItem() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(item);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarItem() {
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto del Item a Actualizar");
        String idPedidoLeido = JOptionPane.showInputDialog("Digite el Id del Pedido del Item a Actualizar");
        String cantidadActualizar = JOptionPane.showInputDialog("Digite la cantidad");
        item.setItemPK(new ItemPK(idProductoLeido, Integer.parseInt(idPedidoLeido)));
        item.setCantidad(Integer.parseInt(cantidadActualizar));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(item);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarItem() {
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto del Item a Eliminar");
        String idPedidoLeido = JOptionPane.showInputDialog("Digite el Id del Pedido del Item a Eliminar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Item.class,new ItemPK(idProductoLeido, Integer.parseInt(idPedidoLeido))));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void buscarUnItem() {
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto del Item a Buscar");
        String idPedidoLeido = JOptionPane.showInputDialog("Digite el Id del Pedido del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Item itemTemporal = em.find(Item.class, new ItemPK(idProductoLeido, Integer.parseInt(idPedidoLeido)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(itemTemporal.toString());
    }
    
    @Test
    public void buscarItemPorCantidad() {
        String itemLeido = JOptionPane.showInputDialog("Digite la cantidad del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Item.findByCantidad");
        q.setParameter("cantidad", Integer.parseInt(itemLeido));
        List<Item> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Item itemT : lis) {
            System.out.println(itemT.toString());
        }
    }
    
    @Test
    public void buscarItemPorCostoUnitario() {
        String itemLeido = JOptionPane.showInputDialog("Digite el costo unitario del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Item.findByCostoUnitario");
        q.setParameter("costoUnitario", Float.parseFloat(itemLeido));
        List<Item> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Item itemT : lis) {
            System.out.println(itemT.toString());
        }
    }
    
    @Test
    public void buscarItemPorCostoTotal() {
        String itemLeido = JOptionPane.showInputDialog("Digite el costo total del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Item.findByCostoTotal");
        q.setParameter("costoTotal", Float.parseFloat(itemLeido));
        List<Item> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Item itemT : lis) {
            System.out.println(itemT.toString());
        }
    }
    
    @Test
    public void buscarItemPorIdProducto() {
        String itemLeido = JOptionPane.showInputDialog("Digite el id del Producto del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Item.findByProductoidProducto");
        q.setParameter("productoidProducto",itemLeido);
        List<Item> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Item itemT : lis) {
            System.out.println(itemT.toString());
        }
    }
    
    @Test
    public void buscarItemPorIdPedidoIdFactura() {
        String itemLeido = JOptionPane.showInputDialog("Digite el id de la factura del pedido del Item a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Item.findByPedidoFacturaidFactura");
        q.setParameter("pedidoFacturaidFactura",Integer.parseInt(itemLeido));
        List<Item> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Item itemT : lis) {
            System.out.println(itemT.toString());
        }
    }
}
