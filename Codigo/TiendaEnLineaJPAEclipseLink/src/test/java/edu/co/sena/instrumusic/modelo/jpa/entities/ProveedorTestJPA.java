/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.Proveedor;
import edu.co.sena.instrumusic.modelo.jpa.entities.ProveedorPK;
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
public class ProveedorTestJPA {
    Proveedor proveedor;
    EntityManager em;
    
    public ProveedorTestJPA() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        proveedor = new Proveedor();
        proveedor.setEmail("instrumentosdeoro@gmail.com");
        proveedor.setNombre("Instrumentos de Oro");
        proveedor.setProveedorPK(new ProveedorPK("235689", "NIT"));
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
    public void insertarProveedor(){
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(proveedor);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void actualizarProveedor(){
        String idProveedorLeido = JOptionPane.showInputDialog("Digite el Id del Proveedor a Actualizar");
        String tipoDocumentoProveedorLeido = JOptionPane.showInputDialog("Digite el Tipo de Identificacion del Proveedor a Actualizar");
        String nombreActualizar = JOptionPane.showInputDialog("Digite el nombre del Proveedor");
        proveedor.setProveedorPK(new ProveedorPK(idProveedorLeido, tipoDocumentoProveedorLeido));
        proveedor.setNombre(nombreActualizar);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(proveedor);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void eliminarProveedor() {
        String tipoIdentificacionProveedor = JOptionPane.showInputDialog("Digite el tipo de Identificación del Proveedor del Domicilio a Eliminar");
        String idProveedor = JOptionPane.showInputDialog("Digite el id del Proveedor del Domicilio a Eliminar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Proveedor.class, new ProveedorPK(idProveedor, tipoIdentificacionProveedor)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void buscarUnProveedor() {
        String idProveedorLeido = JOptionPane.showInputDialog("Digite el Id del Proveedor a buscar");
        String tipoDocumentoProveedorLeido = JOptionPane.showInputDialog("Digite el Tipo de Identificacion del Proveedor a buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Proveedor proveedorTemporal = em.find(Proveedor.class,new ProveedorPK(idProveedorLeido, tipoDocumentoProveedorLeido));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(proveedorTemporal.toString());
    }
    
    @Test
    public void buscarProveedorPorNombre() {
        String proveedorLeido = JOptionPane.showInputDialog("Digite el nombre del Proveedor a buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Proveedor.findByNombre");
        q.setParameter("nombre", proveedorLeido);
        List<Proveedor> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Proveedor proveedorT : lis) {
            System.out.println(proveedorT.toString());
        }
    }
    
    @Test
    public void buscarProveedorPorEmail() {
        String proveedorLeido = JOptionPane.showInputDialog("Digite el email del Proveedor a buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Proveedor.findByEmail");
        q.setParameter("email", proveedorLeido);
        List<Proveedor> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Proveedor proveedorT : lis) {
            System.out.println(proveedorT.toString());
        }
    }
    
    @Test
    public void buscarProveedorPorIdProveedor() {
        String proveedorLeido = JOptionPane.showInputDialog("Digite el id del Proveedor a buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Proveedor.findByIdProveedor");
        q.setParameter("idProveedor", proveedorLeido);
        List<Proveedor> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Proveedor proveedorT : lis) {
            System.out.println(proveedorT.toString());
        }
    }
    
    @Test
    public void buscarProveedorPorTipoDeIdentificacion() {
        String proveedorLeido = JOptionPane.showInputDialog("Digite el tipo de identificacion del Proveedor a buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Proveedor.findByTipoDeIdentificacion");
        q.setParameter("tipoDeIdentificacion", proveedorLeido);
        List<Proveedor> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Proveedor proveedorT : lis) {
            System.out.println(proveedorT.toString());
        }
    }
}
