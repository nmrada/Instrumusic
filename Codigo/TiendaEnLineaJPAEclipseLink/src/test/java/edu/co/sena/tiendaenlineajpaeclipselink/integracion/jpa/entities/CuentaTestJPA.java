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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ColsutecR
 */
public class CuentaTestJPA {

    Cuenta cuenta;
    EntityManager em;

    public CuentaTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cuenta = new Cuenta();
        cuenta.setPrimerNombre("Diana");
        cuenta.setSegundoNombre("Carolina");
        cuenta.setPrimerApellido("Ramirez");
        cuenta.setSegundoApellido("Perez");
        cuenta.setUsuarioidUsuario(new Usuario("Usuario1"));
        cuenta.setCuentaPK(new CuentaPK("CC", "55889663"));
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
    public void insertarCuenta() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(cuenta);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarCuenta() {
        String tipoDocumentoLeido = JOptionPane.showInputDialog("Digite el Tipo de Documento de la Cuenta a Actualizar");
        String numeroDocumentoLeido = JOptionPane.showInputDialog("Digite el Número de Documento de la Cuenta a Actualizar");
        String primerNombreActualizar = JOptionPane.showInputDialog("Digite el primer nombre");
        CuentaPK cuentaPK = new CuentaPK(tipoDocumentoLeido, numeroDocumentoLeido);
        cuenta.setCuentaPK(cuentaPK);
        cuenta.setPrimerNombre(primerNombreActualizar);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(cuenta);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarCuenta() {
        String tipoDocumento = JOptionPane.showInputDialog("Digite el tipo de Documento de la Cuenta a Buscar");
        String numeroDocumento = JOptionPane.showInputDialog("Digite el numero de Documento de la Cuenta a Buscar");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Cuenta.class, new CuentaPK(tipoDocumento, numeroDocumento)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se  pudo realizar la eliminacion por: " + e.getMessage());
        }
    }
    
    @Test
    public void buscarunaCuenta() {
        String tipoDocumento = JOptionPane.showInputDialog("Digite el tipo de Documento de la Cuenta a Buscar");
        String numeroDocumento = JOptionPane.showInputDialog("Digite el numero de Documento de la Cuenta a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Cuenta cuentaTemporal = em.find(Cuenta.class, new CuentaPK(tipoDocumento, numeroDocumento));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(cuentaTemporal.toString());
    }

    @Test
    public void buscarCuentaPorPrimerNombre() {
        String cuentaLeida = JOptionPane.showInputDialog("Digite el primer Nombre de la Cuenta a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Cuenta.findByPrimerNombre");
        q.setParameter("primerNombre", cuentaLeida);
        List<Cuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Cuenta cuentaT : lis) {
            System.out.println(cuentaT.toString());
        }
    }
    
    @Test
    public void buscarCuentaPorSegundoNombre() {
        String cuentaLeida = JOptionPane.showInputDialog("Digite el segundo Nombre de la Cuenta a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Cuenta.findBySegundoNombre");
        q.setParameter("segundoNombre", cuentaLeida);
        List<Cuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Cuenta cuentaT : lis) {
            System.out.println(cuentaT.toString());
        }
    }
    
    @Test
    public void buscarCuentaPorPrimerApellido() {
        String cuentaLeida = JOptionPane.showInputDialog("Digite el primer Apellido de la Cuenta a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Cuenta.findByPrimerApellido");
        q.setParameter("primerApellido", cuentaLeida);
        List<Cuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Cuenta cuentaT : lis) {
            System.out.println(cuentaT.toString());
        }
    }
    
    @Test
    public void buscarCuentaPorSegundoApellido() {
        String cuentaLeida = JOptionPane.showInputDialog("Digite el segundo Apellido de la Cuenta a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Cuenta.findBySegundoApellido");
        q.setParameter("segundoApellido", cuentaLeida);
        List<Cuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Cuenta cuentaT : lis) {
            System.out.println(cuentaT.toString());
        }
    }
    
    @Test
    public void buscarCuentaPorTipoDocumento() {
        String cuentaLeida = JOptionPane.showInputDialog("Digite el tipo de Documento de la Cuenta a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Cuenta.findByTipoDocumento");
        q.setParameter("tipoDocumento", cuentaLeida);
        List<Cuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Cuenta cuentaT : lis) {
            System.out.println(cuentaT.toString());
        }
    }
    
    @Test
    public void buscarCuentaPorNumeroDocumento() {
        String cuentaLeida = JOptionPane.showInputDialog("Digite el numero de Documento de la Cuenta a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Cuenta.findByNumeroDocumento");
        q.setParameter("numeroDocumento", cuentaLeida);
        List<Cuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Cuenta cuentaT : lis) {
            System.out.println(cuentaT.toString());
        }
    }
}
