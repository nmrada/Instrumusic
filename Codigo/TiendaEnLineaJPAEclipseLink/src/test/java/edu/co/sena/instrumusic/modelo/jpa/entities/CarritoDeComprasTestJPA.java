/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.CarritoDeCompras;
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
 * @author ColsutecR
 */
public class CarritoDeComprasTestJPA {

    CarritoDeCompras carritoCompras;
    EntityManager em;

    public CarritoDeComprasTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        carritoCompras = new CarritoDeCompras();
        carritoCompras.setIdCarritoDeCompras("QWERTY123456");
        carritoCompras.setImpuestos(60000);
        carritoCompras.setPrecioTotal(600000);
        carritoCompras.setSubtotal(540000);
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
    public void insertarCarritoDeCompras() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(carritoCompras);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarCarritoDeCompras() {
        String carritoLeido = JOptionPane.showInputDialog("Digite el Id de Carrito de Compras a Actualizar");
        String impuestosActualizar = JOptionPane.showInputDialog("Digite el valor de los impuestos");
        carritoCompras.setIdCarritoDeCompras(carritoLeido);
        carritoCompras.setImpuestos(Float.parseFloat(impuestosActualizar));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(carritoCompras);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarCarritoDeCompras() {
        String carritoDeComprasLeido = JOptionPane.showInputDialog("Digite el Id del Carrito de Compras a Eliminar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(CarritoDeCompras.class, carritoDeComprasLeido));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void buscarCarritoDeComprasPorId() {
        String carritoLeido = JOptionPane.showInputDialog("Digite el Id de Carrito de Compras a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        CarritoDeCompras carritoTemporal = em.find(CarritoDeCompras.class, carritoLeido);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(carritoTemporal.toString());
    }

    @Test
    public void buscarCarritoDeComprasPorSubTotal() {
        String carritoLeido = JOptionPane.showInputDialog("Digite el subtotal de Carrito de Compras a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Carritodecompras.findBySubtotal");
        q.setParameter("subtotal", Float.parseFloat(carritoLeido));
        List<CarritoDeCompras> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (CarritoDeCompras carritoT : lis) {
            System.out.println(carritoT.toString());
        }
    }
    
    @Test
    public void buscarCarritoDeComprasPorPrecioTotal() {
        String carritoLeido = JOptionPane.showInputDialog("Digite el precio total de Carrito de Compras a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Carritodecompras.findByPrecioTotal");
        q.setParameter("precioTotal", Float.parseFloat(carritoLeido));
        List<CarritoDeCompras> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (CarritoDeCompras carritoT : lis) {
            System.out.println(carritoT.toString());
        }
    }
    
    @Test
    public void buscarCarritoDeComprasPorImpuestos() {
        String carritoLeido = JOptionPane.showInputDialog("Digite el precio total de Carrito de Compras a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Carritodecompras.findByImpuestos");
        q.setParameter("impuestos", Float.parseFloat(carritoLeido));
        List<CarritoDeCompras> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (CarritoDeCompras carritoT : lis) {
            System.out.println(carritoT.toString());
        }
    }
}
