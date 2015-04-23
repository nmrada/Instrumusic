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
 * @author ColsutecR
 */
public class DomicilioCuentaTestJPA {

    DomicilioCuenta domicilioCuenta;
    EntityManager em;

    public DomicilioCuentaTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        domicilioCuenta = new DomicilioCuenta();
        domicilioCuenta.setBarrio("Chico");
        domicilioCuenta.setDireccion("Kr 85 # 15-34");
        domicilioCuenta.setTelefono("5896321");
        domicilioCuenta.setLocalidad("Santa Fe");
        domicilioCuenta.setMunicipioidMunicipio(new Municipio("1"));
        DomicilioCuentaPK domicilioCuentaPk = new DomicilioCuentaPK("CC", "55889663");
        domicilioCuenta.setDomicilioCuentaPK(domicilioCuentaPk);
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
    public void insertarDomicilioCuenta() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(domicilioCuenta);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarDomicilioCuenta() {
        String tipoDocumentoLeido = JOptionPane.showInputDialog("Digite el Tipo de Documento del Domicilio a Actualizar");
        String numeroDocumentoLeido = JOptionPane.showInputDialog("Digite el Número de Documento del Domicilio a Actualizar");
        String barrioActualizar = JOptionPane.showInputDialog("Digite el Barrio");
        DomicilioCuentaPK domicilioCuentaPK = new DomicilioCuentaPK(tipoDocumentoLeido, numeroDocumentoLeido);
        domicilioCuenta.setDomicilioCuentaPK(domicilioCuentaPK);
        domicilioCuenta.setBarrio(barrioActualizar);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(domicilioCuenta);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarDomicilioCuenta() {
        String tipoDocumento = JOptionPane.showInputDialog("Digite el tipo de Documento de la Cuenta del Domicilio a Eliminar");
        String numeroDocumento = JOptionPane.showInputDialog("Digite el numero de Documento de la Cuenta del Domicilio a Eliminar");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(DomicilioCuenta.class, new DomicilioCuentaPK(tipoDocumento, numeroDocumento)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se  pudo realizar la eliminacion por: " + e.getMessage());
        }
    }
    
    @Test
    public void buscarDomicilioCuentaPorTelefono() {
        String domicilioCuentaLeido = JOptionPane.showInputDialog("Digite el telefono del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioCuenta.findByTelefono");
        q.setParameter("telefono", domicilioCuentaLeido);
        List<DomicilioCuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioCuenta domicilioCuentaT : lis) {
            System.out.println(domicilioCuentaT.toString());
        }
    }
    
    @Test
    public void buscarDomicilioCuentaPorDireccion() {
        String domicilioCuentaLeido = JOptionPane.showInputDialog("Digite la dirección del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioCuenta.findByDireccion");
        q.setParameter("direccion", domicilioCuentaLeido);
        List<DomicilioCuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioCuenta domicilioCuentaT : lis) {
            System.out.println(domicilioCuentaT.toString());
        }
    }
    
    @Test
    public void buscarDomicilioCuentaPorBarrio() {
        String domicilioCuentaLeido = JOptionPane.showInputDialog("Digite el barrio del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioCuenta.findByBarrio");
        q.setParameter("barrio", domicilioCuentaLeido);
        List<DomicilioCuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioCuenta domicilioCuentaT : lis) {
            System.out.println(domicilioCuentaT.toString());
        }
    }
    
    @Test
    public void buscarDomicilioCuentaPorLocalidad() {
        String domicilioCuentaLeido = JOptionPane.showInputDialog("Digite la localidad del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioCuenta.findByLocalidad");
        q.setParameter("localidad", domicilioCuentaLeido);
        List<DomicilioCuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioCuenta domicilioCuentaT : lis) {
            System.out.println(domicilioCuentaT.toString());
        }
    }
    
    @Test
    public void buscarDomicilioCuentaPorTipoDocumento() {
        String domicilioCuentaLeido = JOptionPane.showInputDialog("Digite el tipo de Documento de la Cuenta del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioCuenta.findByCuentatipoDocumento");
        q.setParameter("cuentatipoDocumento", domicilioCuentaLeido);
        List<DomicilioCuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioCuenta domicilioCuentaT : lis) {
            System.out.println(domicilioCuentaT.toString());
        }
    }
    
    @Test
    public void buscarDomicilioCuentaPorNumeroDocumento() {
        String domicilioCuentaLeido = JOptionPane.showInputDialog("Digite el numero de Documento de la Cuenta del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioCuenta.findByCuentanumeroDocumento");
        q.setParameter("cuentanumeroDocumento", domicilioCuentaLeido);
        List<DomicilioCuenta> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioCuenta domicilioCuentaT : lis) {
            System.out.println(domicilioCuentaT.toString());
        }
    }
}
