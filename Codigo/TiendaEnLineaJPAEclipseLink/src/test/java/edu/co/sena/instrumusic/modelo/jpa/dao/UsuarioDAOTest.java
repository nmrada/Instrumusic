/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IUsuarioDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Usuario;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class UsuarioDAOTest {
    
     Usuario entity = new Usuario();

    public UsuarioDAOTest() {
    }
    
       
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity.setIdUsuario("usuario1");
        entity.setContrasena("123456");
        entity.setRol("Cliente");
        entity.setEstado("Activo");
        entity.setEmail("usuario1@gmail.com");
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
    public void testInsert() throws Exception {
        System.out.println("Insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IUsuarioDAO instance = fabrica.createUsuarioDAO();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() throws Exception {
        System.out.println("Update");
        entity.setContrasena("jdkjh542045");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IUsuarioDAO instance = fabrica.createUsuarioDAO();
        instance.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IUsuarioDAO instance = fabrica.createUsuarioDAO();
        Usuario ut = instance.findByIdUsuario("usuario1");
        instance.delete(ut);
    }
    
    @Test
    public void testFindByIdUsuario() throws Exception {
        System.out.println("FindByIdCarritoDeCompras");
        Usuario ut;
        String idUsuario = "Usuario1";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IUsuarioDAO instance = fabrica.createUsuarioDAO();
        ut = instance.findByIdUsuario(idUsuario);
        System.out.println(ut.getIdUsuario());
    }
    
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IUsuarioDAO instance = fabrica.createUsuarioDAO();
        List<Usuario> result = instance.findByAll();
        for (Usuario result1 : result) {
            System.out.println(result1.getIdUsuario());
        }
    }
    
    @Test
    public void testFindByContrasena() throws Exception {
        System.out.println("FindByContrasena");
        String contrasena = "jdkjh542045";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IUsuarioDAO instance = fabrica.createUsuarioDAO();
        List<Usuario> result = instance.findByContrasena(contrasena);
        for (Usuario result1 : result) {
            System.out.println(result1.getIdUsuario());
        }
    }
    
    @Test
    public void testFindByRol() throws Exception {
        System.out.println("FindByRol");
        String rol = "Cliente";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IUsuarioDAO instance = fabrica.createUsuarioDAO();
        List<Usuario> result = instance.findByRol(rol);
         for (Usuario result1 : result) {
            System.out.println(result1.getIdUsuario());
        }
    }
    
    @Test
    public void testFindByEstado() throws Exception {
        System.out.println("FindByEstado");
        String estado = "Activo";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IUsuarioDAO instance = fabrica.createUsuarioDAO();
        List<Usuario> result = instance.findByEstado(estado);
         for (Usuario result1 : result) {
            System.out.println(result1.getIdUsuario());
        }
    }
    
    @Test
    public void testFindByEmail() throws Exception {
        System.out.println("FindByEmail");
        String email = "usuario1@gmail.com";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IUsuarioDAO instance = fabrica.createUsuarioDAO();
        List<Usuario> result = instance.findByEstado(email);
         for (Usuario result1 : result) {
            System.out.println(result1.getIdUsuario());
        }
    }
}
