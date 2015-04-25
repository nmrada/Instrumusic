/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.entities.Cuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.CuentaPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.Usuario;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class CuentaDAOImplTest {

    Cuenta entity = new Cuenta();

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public CuentaDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity.setCuentaPK(new CuentaPK("C.C", "1023006468"));
        entity.setPrimerNombre("Maicol");
        entity.setSegundoNombre("Steven");
        entity.setPrimerApellido("Chunza");
        entity.setSegundoApellido("Alfonso");
        entity.setUsuarioidUsuario(new Usuario("Usuario1"));
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
    public void testInsert() {
        System.out.println("insert");
        CuentaDAOImpl instance = new CuentaDAOImpl();
        instance.insert(entity);

    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        entity.setSegundoApellido("Gonzales");
        CuentaDAOImpl instance = new CuentaDAOImpl();
        instance.update(entity);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        CuentaDAOImpl instance = new CuentaDAOImpl();
        Cuenta ct = instance.findByIdCuenta(new CuentaPK("C.C", "1023006468"));
        instance.delete(ct);

    }

    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findByAll();
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByIdCuenta() {
        
        String tipoDocumento = "C.C";
        String numeroDocumento = "1023006468";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        Cuenta it = instance.findByIdCuenta(new CuentaPK("C.C", "1023006468"));
        System.out.println(it.toString());

    }

    @Test
    public void testFindByPrimerNombre() {
        System.out.println("findByPrimerNombre");
        String primerNombre = "Maicol";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findByPrimerNombre(primerNombre);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindBySegundoNombre() {
        System.out.println("findBySegundoNombre");
        String segundoNombre = "Steven";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findBySegundoNombre(segundoNombre);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    
     @Test
    public void testFindByPrimerApellido() {
        System.out.println("findByPrimerNombre");
        String primerNombre = "Steven";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findByPrimerApellido(primerNombre);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    
     @Test
    public void testFindBySegundoApellido() {
        System.out.println("findBySegundoApellido");
        String segundoApellido = "Steven";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findBySegundoApellido(segundoApellido);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }
}
