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
public class MunicipioTestJPA {

    Municipio municipio;
    EntityManager em;

    public MunicipioTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        municipio = new Municipio();
        municipio.setIdMunicipio("1");
        municipio.setNombre("Bogotá");
        municipio.setDepartamentoidDepartamento(new Departamento("1"));
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
    public void insertarMunicipio() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(municipio);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarMunicipio() {
        String idMunicipioLeido = JOptionPane.showInputDialog("Digite el Id del Municipio a Actualizar");
        String nombreActualizar = JOptionPane.showInputDialog("Digite el nombre del municipio");
        municipio.setIdMunicipio(idMunicipioLeido);
        municipio.setNombre(nombreActualizar);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(municipio);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarMunicipio() {
        String idMunicipioLeido = JOptionPane.showInputDialog("Digite el Id del Municipio a Eliminar");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Municipio.class, idMunicipioLeido));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se  pudo realizar la eliminacion por: " + e.getMessage());
        }
    }
    
    
    @Test
    public void buscarMunicipioPorId() {
        String idMunicipioLeido = JOptionPane.showInputDialog("Digite el Id del Municipio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Municipio municipioTemporal = em.find(Municipio.class, idMunicipioLeido);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(municipioTemporal.toString());
    }
    
    
    @Test
    public void buscarMunicipioPorNombre() {
        String municipioLeido = JOptionPane.showInputDialog("Digite el nombre del Municipio a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Municipio.findByNombre");
        q.setParameter("nombre", municipioLeido);
        List<Municipio> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Municipio municipioT : lis) {
            System.out.println(municipioT.toString());
        }
    }
}
