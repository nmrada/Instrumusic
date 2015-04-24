/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.Usuario;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
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
public class UsuarioTestJPA {

    Usuario usuario;
    EntityManager em;

    public UsuarioTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        usuario = new Usuario();
        usuario.setIdUsuario("Usuario1");
        usuario.setRol("Cliente");
        usuario.setContrasena("123456");
        usuario.setEstado("Activo");
        usuario.setEmail("usuario1@gmail.com");
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
    public void insertarUsuario() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(usuario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarContrasenaUsuario() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        String idUsuarioLeido = JOptionPane.showInputDialog("Digite el Id del Usuario a Actualizar");
        String contrasenaActualizar = JOptionPane.showInputDialog("Digite la nueva contraseña");
        usuario.setIdUsuario(contrasenaActualizar);
        usuario.setContrasena(contrasenaActualizar);
        em.merge(usuario);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarPkUsuario() {
        em = EntityManagerHelper.getEntityManager();
        String viejoId = JOptionPane.showInputDialog("Digite el Id del Usuario a Actualizar");
        String nuevoId = JOptionPane.showInputDialog("Digite el nuevo id");
        String sql = "UPDATE `tiendaenlinea`.`usuario` "
                + "SET "
                + "`idUsuario` = '"+nuevoId+"' "
                + "WHERE `idUsuario` = '"+viejoId+"';";
        System.out.println(sql);
        Query query = em.createNativeQuery(sql);
        EntityManagerHelper.beginTransaction();
        int rowCount = query.executeUpdate();
        System.out.println("se actualizaron "+rowCount+" registros");
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void eliminarUsuario() {
        String idUsuarioLeido = JOptionPane.showInputDialog("Digite el Id del Usuario a Eliminar");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Usuario.class, idUsuarioLeido));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se  pudo realizar la eliminacion por: " + e.getMessage());
        }
    }
    
    
    @Test
    public void buscarUsuarioPorId() {
        String idUsuarioLeido = JOptionPane.showInputDialog("Digite el Id del Usuario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Usuario usuarioTemporal = em.find(Usuario.class, idUsuarioLeido);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        System.out.println(usuarioTemporal.toString());
    }
    
    @Test
    public void buscarUsuarioPorContrasena() {
        String usuarioLeido = JOptionPane.showInputDialog("Digite la contraseña del Usuario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Usuario.findByContrasena");
        q.setParameter("contrasena", usuarioLeido);
        List<Usuario> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Usuario usuarioT : lis) {
            System.out.println(usuarioT.toString());
        }
    }
    
    @Test
    public void buscarUsuarioPorRol() {
        String usuarioLeido = JOptionPane.showInputDialog("Digite el rol del Usuario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Usuario.findByRol");
        q.setParameter("rol", usuarioLeido);
        List<Usuario> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Usuario usuarioT : lis) {
            System.out.println(usuarioT.toString());
        }
    }
    
    @Test
    public void buscarUsuarioPorEstado() {
        String usuarioLeido = JOptionPane.showInputDialog("Digite el estado del Usuario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Usuario.findByEstado");
        q.setParameter("estado", usuarioLeido);
        List<Usuario> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Usuario usuarioT : lis) {
            System.out.println(usuarioT.toString());
        }
    }
    
    @Test
    public void buscarUsuarioPorEmail() {
        String usuarioLeido = JOptionPane.showInputDialog("Digite el estado del Usuario a Buscar");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Usuario.findByEmail");
        q.setParameter("email", usuarioLeido);
        List<Usuario> lis = q.getResultList();
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        for (Usuario usuarioT : lis) {
            System.out.println(usuarioT.toString());
        }
    }
}
