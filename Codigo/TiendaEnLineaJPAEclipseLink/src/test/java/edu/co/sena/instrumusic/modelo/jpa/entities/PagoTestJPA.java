/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.Pago;
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
public class PagoTestJPA {

    Pago pago;
    EntityManager em;

    public PagoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pago = new Pago();
        pago.setFacturaidFactura(1);
        pago.setBanco("Banco AV Villas");
        pago.setNumTarCredito("12348554664");
        pago.setTipoCuentaTar("Ahorros");
        pago.setTipoTransaccion("ATH");
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
    public void insertarPago() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(pago);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarPago() {
        String idFacturaLeida = JOptionPane.showInputDialog("Digite el Id Factura del Pago a Actualizar");
        String bancoActualizar = JOptionPane.showInputDialog("Digite el banco");
        pago.setFacturaidFactura(Integer.parseInt(idFacturaLeida));
        pago.setBanco(bancoActualizar);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(pago);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarPago() {
        String idFacturaLeida = JOptionPane.showInputDialog("Digite el Id Factura del Pago a Eliminar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Pago.class, Integer.parseInt(idFacturaLeida)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void buscarPagoPorId() {
        String idFacturaLeida = JOptionPane.showInputDialog("Digite el Id Factura del Pago a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Pago pagoTemporal = em.find(Pago.class, Integer.parseInt(idFacturaLeida));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(pagoTemporal.toString());
    }

    @Test
    public void buscarPagoPorNumeroTarjetaCredito() {
        String pagoLeido = JOptionPane.showInputDialog("Digite el numero de la tarjeta de credito del Pago a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Pago.findByNumTarCredito");
        q.setParameter("numTarCredito", pagoLeido);
        List<Pago> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Pago pagoT : lis) {
            System.out.println(pagoT.toString());
        }
    }
    
    @Test
    public void buscarPagoPorBanco() {
        String pagoLeido = JOptionPane.showInputDialog("Digite el banco del Pago a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Pago.findByBanco");
        q.setParameter("banco", pagoLeido);
        List<Pago> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Pago pagoT : lis) {
            System.out.println(pagoT.toString());
        }
    }
    
    @Test
    public void buscarPagoPorTipoCuentaTarjeta() {
        String pagoLeido = JOptionPane.showInputDialog("Digite el tipo de la cuenta de la tarjeta del Pago a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Pago.findByTipoCuentaTar");
        q.setParameter("tipoCuentaTar", pagoLeido);
        List<Pago> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Pago pagoT : lis) {
            System.out.println(pagoT.toString());
        }
    }
    
    @Test
    public void buscarPagoPorTipoTransaccion() {
        String pagoLeido = JOptionPane.showInputDialog("Digite el tipo de la transaccion del Pago a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Pago.findByTipoTransaccion");
        q.setParameter("tipoTransaccion", pagoLeido);
        List<Pago> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Pago pagoT : lis) {
            System.out.println(pagoT.toString());
        }
    }
}
