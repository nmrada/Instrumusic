/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.InventarioPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.Inventario;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
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
 * @author Nicolas
 */
public class InventarioTestJPA {

    Inventario inventario;
    EntityManager em;

    public InventarioTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        inventario = new Inventario();
        InventarioPK inventarioPK = new InventarioPK();
        inventarioPK.setProductoidProducto("001");
        inventarioPK.setProveedorTipoDocumentotipoDocumento("NIT");
        inventarioPK.setProveedornumeroDocumento("235689");
        inventario.setInventarioPK(inventarioPK);
        inventario.setCantidad(2);
        Calendar calendario = Calendar.getInstance(TimeZone.getTimeZone("GMT-5"));
        Date fechaActual = calendario.getTime();
        inventario.setFecha(fechaActual);
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
    public void insertarInventario() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(inventario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarInventario() {
        String idInventarioLeido = JOptionPane.showInputDialog("Digite el Id del Inventario a Actualizar");
        String idProveedorLeido = JOptionPane.showInputDialog("Digite el Id del Proveedor del Inventario a Actualizar");
        String tipoDocumentoProveedorLeido = JOptionPane.showInputDialog("Digite el tipo de Documento Proveedor del Inventario a Actualizar");
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto del Inventario a Actualizar");
        String cantidadActualizar = JOptionPane.showInputDialog("Digite la cantidad");
        inventario.setInventarioPK(new InventarioPK(Integer.parseInt(idInventarioLeido), idProductoLeido, idProveedorLeido, tipoDocumentoProveedorLeido));
        inventario.setCantidad(Integer.parseInt(cantidadActualizar));
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(inventario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void eliminarInventario() {
        String idInventarioLeido = JOptionPane.showInputDialog("Digite el Id del Inventario a Eliminar");
        String idProveedorLeido = JOptionPane.showInputDialog("Digite el Id del Proveedor del Inventario a Eliminar");
        String tipoDocumentoProveedorLeido = JOptionPane.showInputDialog("Digite el tipo de Documento Proveedor del Inventario a Eliminar");
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto del Inventario a Eliminar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.remove(em.find(Inventario.class, new InventarioPK(Integer.parseInt(idInventarioLeido), idProductoLeido, idProveedorLeido, tipoDocumentoProveedorLeido)));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void buscarUnInventario() {
        String idInventarioLeido = JOptionPane.showInputDialog("Digite el Id del Inventario a Buscar");
        String idProveedorLeido = JOptionPane.showInputDialog("Digite el Id del Proveedor del Inventario a Buscar");
        String tipoDocumentoProveedorLeido = JOptionPane.showInputDialog("Digite el tipo de Documento Proveedor del Inventario a Buscar");
        String idProductoLeido = JOptionPane.showInputDialog("Digite el Id del Producto del Inventario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Inventario inventarioTemporal = em.find(Inventario.class, new InventarioPK(Integer.parseInt(idInventarioLeido), idProductoLeido, idProveedorLeido, tipoDocumentoProveedorLeido));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(inventarioTemporal.toString());
    }
    
    @Test
    public void buscarInventarioPorCantidad() {
        String inventarioLeido = JOptionPane.showInputDialog("Digite la cantidad del Inventario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Inventario.findByCantidad");
        q.setParameter("cantidad", Integer.parseInt(inventarioLeido));
        List<Inventario> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Inventario inventarioT : lis) {
            System.out.println(inventarioT.toString());
        }
    }
    
    @Test
    public void buscarInventarioPorFecha() {
        String inventarioLeido = JOptionPane.showInputDialog("Digite la fecha del Inventario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Inventario.findByFecha");
        q.setParameter("fecha", inventarioLeido);
        List<Inventario> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Inventario inventarioT : lis) {
            System.out.println(inventarioT.toString());
        }
    }
    
    @Test
    public void buscarInventarioPorIdProducto() {
        String inventarioLeido = JOptionPane.showInputDialog("Digite el id del producto del Inventario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Inventario.findByProductoidProducto");
        q.setParameter("productoidProducto", inventarioLeido);
        List<Inventario> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Inventario inventarioT : lis) {
            System.out.println(inventarioT.toString());
        }
    }
    
    @Test
    public void buscarInventarioPorIdProveedor() {
        String inventarioLeido = JOptionPane.showInputDialog("Digite el id del proveedor del Inventario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Inventario.findByProveedoridProveedor");
        q.setParameter("proveedoridProveedor", inventarioLeido);
        List<Inventario> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Inventario inventarioT : lis) {
            System.out.println(inventarioT.toString());
        }
    }
    
    @Test
    public void buscarInventarioPorTipoIdentificacionProveedor() {
        String inventarioLeido = JOptionPane.showInputDialog("Digite el tipo de identificación del proveedor del Inventario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Inventario.findByProveedortipoDeIdentificacion");
        q.setParameter("proveedortipoDeIdentificacion", inventarioLeido);
        List<Inventario> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Inventario inventarioT : lis) {
            System.out.println(inventarioT.toString());
        }
    }
    
    @Test
    public void buscarInventarioPorIdInventario() {
        String inventarioLeido = JOptionPane.showInputDialog("Digite el id del Inventario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Inventario.findByIdInventario");
        q.setParameter("idInventario", Integer.parseInt(inventarioLeido));
        List<Inventario> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Inventario inventarioT : lis) {
            System.out.println(inventarioT.toString());
        }
    }
}
