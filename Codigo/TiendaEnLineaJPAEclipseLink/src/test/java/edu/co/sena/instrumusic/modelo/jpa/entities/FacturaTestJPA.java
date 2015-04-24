/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.Factura;
import edu.co.sena.instrumusic.modelo.jpa.entities.Cuenta;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
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
public class FacturaTestJPA {

    Factura factura;
    EntityManager em;

    public FacturaTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws ParseException {
        factura = new Factura();
        Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
        Date fechaActual = calendario.getTime();
        factura.setFecha(fechaActual);
        factura.setTotal(600000);
        factura.setCuenta(new Cuenta("CC", "55889663"));
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
    public void insertarFactura() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(factura);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarFactura() {
        String idFacturaLeida = JOptionPane.showInputDialog("Digite el Id de la Factura a Actualizar");
        String totalActualizar = JOptionPane.showInputDialog("Digite el valor del Total");
        factura.setIdFactura(Integer.parseInt(idFacturaLeida));
        factura.setTotal(Float.parseFloat(totalActualizar));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(factura);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarFactura() {
        String idFactura = JOptionPane.showInputDialog("Digite el id de la Factura a Eliminar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Factura.class, Integer.parseInt(idFactura)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void buscarFacturaPorId() {
        String idFactura = JOptionPane.showInputDialog("Digite el id de la Factura a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Factura facturaTemporal = em.find(Factura.class, Integer.parseInt(idFactura));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(facturaTemporal.toString());
    }

    @Test
    public void buscarFacturaPorTotal() {
        String facturaLeida = JOptionPane.showInputDialog("Digite el total de la Factura a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Factura.findByTotal");
        q.setParameter("total", Float.parseFloat(facturaLeida));
        List<Factura> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Factura facturaT : lis) {
            System.out.println(facturaT.toString());
        }
    }
    
    @Test
    public void buscarFacturaPorFecha() {
        String facturaLeida = JOptionPane.showInputDialog("Digite la fecha de la Factura a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Factura.findByFecha");
        q.setParameter("fecha", facturaLeida);
        List<Factura> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Factura facturaT : lis) {
            System.out.println(facturaT.toString());
        }
    }
}
