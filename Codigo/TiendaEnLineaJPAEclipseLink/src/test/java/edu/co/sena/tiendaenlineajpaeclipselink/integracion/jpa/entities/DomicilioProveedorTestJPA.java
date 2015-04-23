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
public class DomicilioProveedorTestJPA {

    DomicilioProveedor domicilioProveedor;
    EntityManager em;

    public DomicilioProveedorTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        domicilioProveedor = new DomicilioProveedor();
        domicilioProveedor.setBarrio("San Jose");
        domicilioProveedor.setDireccion("KR 100 # 63-58)");
        domicilioProveedor.setLocalidad("Usaquen");
        domicilioProveedor.setTelefono("56789821");
        domicilioProveedor.setMunicipioidMunicipio(new Municipio("1"));
        domicilioProveedor.setDomicilioProveedorPK(new DomicilioProveedorPK("235689", "NIT"));
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
    public void insertarDomicilioProveedor() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(domicilioProveedor);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarDomicilioProveedor() {
        String idProveedorLeido = JOptionPane.showInputDialog("Digite el Id Proveedor del Domicilio a Actualizar");
        String tipoDocumentoLeido = JOptionPane.showInputDialog("Digite el Tipo Documento del Domicilio a Actualizar");
        String localidadActualizar = JOptionPane.showInputDialog("Digite la Localidad");
        DomicilioProveedorPK domicilioProveedorPK = new DomicilioProveedorPK(idProveedorLeido, tipoDocumentoLeido);
        domicilioProveedor.setDomicilioProveedorPK(domicilioProveedorPK);
        domicilioProveedor.setLocalidad(localidadActualizar);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(domicilioProveedor);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarDomicilioProveedor() {
        String tipoIdentificacionProveedor = JOptionPane.showInputDialog("Digite el tipo de Identificación del Proveedor del Domicilio a Eliminar");
        String idProveedor = JOptionPane.showInputDialog("Digite el id del Proveedor del Domicilio a Eliminar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(DomicilioProveedor.class, new DomicilioProveedorPK(idProveedor, tipoIdentificacionProveedor)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void buscarunDomicilioProveedor() {
        String tipoIdentificacionProveedor = JOptionPane.showInputDialog("Digite el tipo de Identificación del Proveedor del Domicilio a Buscar");
        String idProveedor = JOptionPane.showInputDialog("Digite el id del Proveedor del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        DomicilioProveedor domicilioProveedorTemporal = em.find(DomicilioProveedor.class, new DomicilioProveedorPK(idProveedor, tipoIdentificacionProveedor));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(domicilioProveedorTemporal.toString());
    }

    @Test
    public void buscarDomicilioProveedorPorTelefono() {
        String domicilioProveedorLeido = JOptionPane.showInputDialog("Digite el telefono del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioProveedor.findByTelefono");
        q.setParameter("telefono", domicilioProveedorLeido);
        List<DomicilioProveedor> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioProveedor domicilioProveedorT : lis) {
            System.out.println(domicilioProveedorT.toString());
        }
    }
    
    @Test
    public void buscarDomicilioProveedorPorDireccion() {
        String domicilioProveedorLeido = JOptionPane.showInputDialog("Digite la direción del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioProveedor.findByDireccion");
        q.setParameter("direccion", domicilioProveedorLeido);
        List<DomicilioProveedor> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioProveedor domicilioProveedorT : lis) {
            System.out.println(domicilioProveedorT.toString());
        }
    }
    
    @Test
    public void buscarDomicilioProveedorPorBarrio() {
        String domicilioProveedorLeido = JOptionPane.showInputDialog("Digite el barrio del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioProveedor.findByBarrio");
        q.setParameter("barrio", domicilioProveedorLeido);
        List<DomicilioProveedor> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioProveedor domicilioProveedorT : lis) {
            System.out.println(domicilioProveedorT.toString());
        }
    }
    
    @Test
    public void buscarDomicilioProveedorPorLocalidad() {
        String domicilioProveedorLeido = JOptionPane.showInputDialog("Digite la localidad del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioProveedor.findByLocalidad");
        q.setParameter("localidad", domicilioProveedorLeido);
        List<DomicilioProveedor> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioProveedor domicilioProveedorT : lis) {
            System.out.println(domicilioProveedorT.toString());
        }
    }
    
    @Test
    public void buscarDomicilioProveedorPorIdProveedor() {
        String domicilioProveedorLeido = JOptionPane.showInputDialog("Digite el Id del Proveedor del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioProveedor.findByProveedoridProveedor");
        q.setParameter("proveedoridProveedor", domicilioProveedorLeido);
        List<DomicilioProveedor> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioProveedor domicilioProveedorT : lis) {
            System.out.println(domicilioProveedorT.toString());
        }
    }
    
    @Test
    public void buscarDomicilioProveedorPorTipoIdentificacion() {
        String domicilioProveedorLeido = JOptionPane.showInputDialog("Digite el tipo de Identificación del Proveedor del Domicilio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("DomicilioProveedor.findByProveedortipoDeIdentificacion");
        q.setParameter("proveedortipoDeIdentificacion", domicilioProveedorLeido);
        List<DomicilioProveedor> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (DomicilioProveedor domicilioProveedorT : lis) {
            System.out.println(domicilioProveedorT.toString());
        }
    }
}