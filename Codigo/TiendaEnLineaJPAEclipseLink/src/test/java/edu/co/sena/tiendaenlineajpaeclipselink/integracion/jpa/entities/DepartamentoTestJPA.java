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
public class DepartamentoTestJPA {

    Departamento departamento;
    EntityManager em;

    public DepartamentoTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        departamento = new Departamento();
        departamento.setIdDepartamento("1");
        departamento.setNombre("Cundinamarca");
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
    public void insertarDepartamento() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(departamento);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarDepartamento() {
        String departamentoLeido = JOptionPane.showInputDialog("Digite el id del Departamento a Actualizar");
        String nombreActualizar = JOptionPane.showInputDialog("Digite el nombre del Departamento");
        departamento.setIdDepartamento(departamentoLeido);
        departamento.setNombre(nombreActualizar);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(departamento);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarDepartamento() {
        String departamentoLeido = JOptionPane.showInputDialog("Digite el id del Departamento a Eliminar");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Departamento.class, departamentoLeido));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se  pudo realizar la eliminacion por: " + e.getMessage());
        }
    }
  
    @Test
    public void buscarDepartamentoPorId() {
        String departamentoLeido = JOptionPane.showInputDialog("Digite el id del Departamento a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Departamento departamentoTemporal = em.find(Departamento.class, departamentoLeido);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(departamentoTemporal.toString());
    }
    
    
    @Test
    public void buscarDepartamentoPorNombre() {
        String departamentoLeido = JOptionPane.showInputDialog("Digite el nombre del Departamento a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Departamento.findByNombre");
        q.setParameter("nombre", departamentoLeido);
        List<Departamento> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Departamento departamentoT : lis) {
            System.out.println(departamentoT.toString());
        }
    }
}
