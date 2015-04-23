/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities;

import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.util.EntityManagerHelper;
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
public class PedidoTestJPA {

    Pedido pedido;
    EntityManager em;

    public PedidoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pedido = new Pedido();
        pedido.setFacturaidFactura(1);
        pedido.setImpuestos(60000);
        pedido.setSubtotal(540000);
        pedido.setTotal(600000);
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
    public void insertarPedido() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(pedido);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarPedido() {
        String idFacturaLeida = JOptionPane.showInputDialog("Digite el Id Factura del Pedido a Actualizar");
        String impuestosActualizar = JOptionPane.showInputDialog("Digite el valor de los impuestos");
        pedido.setFacturaidFactura(Integer.parseInt(idFacturaLeida));
        pedido.setImpuestos(Float.parseFloat(impuestosActualizar));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(pedido);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarPedido() {
        String idFacturaLeida = JOptionPane.showInputDialog("Digite el Id Factura del Pedido a Eliminar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Pedido.class, Integer.parseInt(idFacturaLeida)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void buscarPedidoPorId() {
        String idFacturaLeida = JOptionPane.showInputDialog("Digite el Id Factura del Pedido a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Pedido pedidoTemporal = em.find(Pedido.class, Integer.parseInt(idFacturaLeida));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(pedidoTemporal.toString());
    }
    
    @Test
    public void buscarPedidoPorTotal() {
        String pedidoLeido = JOptionPane.showInputDialog("Digite el total del Pedido a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Pedido.findByTotal");
        q.setParameter("total", Float.parseFloat(pedidoLeido));
        List<Pedido> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Pedido pedidoT : lis) {
            System.out.println(pedidoT.toString());
        }
    }
    
    @Test
    public void buscarPedidoPorSubtotal() {
        String pedidoLeido = JOptionPane.showInputDialog("Digite el subtotal del Pedido a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Pedido.findBySubtotal");
        q.setParameter("subtotal", Float.parseFloat(pedidoLeido));
        List<Pedido> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Pedido pedidoT : lis) {
            System.out.println(pedidoT.toString());
        }
    }
    
    @Test
    public void buscarPedidoPorImpuestos() {
        String pedidoLeido = JOptionPane.showInputDialog("Digite los impuestos del Pedido a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Pedido.findByImpuestos");
        q.setParameter("impuestos", Float.parseFloat(pedidoLeido));
        List<Pedido> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Pedido pedidoT : lis) {
            System.out.println(pedidoT.toString());
        }
    }
}
