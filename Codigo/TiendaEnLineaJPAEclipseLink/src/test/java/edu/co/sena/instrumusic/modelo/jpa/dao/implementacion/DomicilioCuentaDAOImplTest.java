/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioCuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioCuentaPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.Municipio;
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
public class DomicilioCuentaDAOImplTest {

    DomicilioCuenta entity = new DomicilioCuenta();

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public DomicilioCuentaDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity.setDomicilioCuentaPK(new DomicilioCuentaPK("C.C", "1023006468"));
        entity.setTelefono("4521678");
        entity.setDireccion("Calle 84 C # 45-12");
        entity.setBarrio("santa librada");
        entity.setLocalidad("Usme");
        entity.setMunicipioidMunicipio(new Municipio("1"));
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
        DomicilioCuentaDAOImpl instance = new DomicilioCuentaDAOImpl();
        instance.insert(entity);

    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        entity.setDireccion("Calle 69 B # 3-40 sur");
        CuentaDAOImpl instance = new CuentaDAOImpl();
        instance.update(entity);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        DomicilioCuentaDAOImpl instance = new DomicilioCuentaDAOImpl();
        DomicilioCuenta ct = instance.findByIdDomicilioCuenta(new DomicilioCuentaPK("C.C", "1023006468"));
        instance.delete(ct);
    }

    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        DomicilioCuentaDAOImpl instance = new DomicilioCuentaDAOImpl();
        List<DomicilioCuenta> result = instance.findByAll();
        for (DomicilioCuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByIdDomicilioCuenta() {

        String tipoDocumento = "C.C";
        String numeroDocumento = "1023006468";
        DomicilioCuentaDAOImpl instance = new DomicilioCuentaDAOImpl();
        DomicilioCuenta it = instance.findByIdDomicilioCuenta(new DomicilioCuentaPK("C.C", "1023006468"));
        System.out.println(it.toString());
    }
    
    @Test
    public void testFindByTelefono() {
        System.out.println("findByTelefono");
        String telefono = "4521678";
        DomicilioCuentaDAOImpl instance = new DomicilioCuentaDAOImpl();
        List<DomicilioCuenta> result = instance.findByTelefono(telefono);
        for (DomicilioCuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    @Test
    public void testFindByDireccion() {
        System.out.println("findByDireccion");
        String direccion = "Calle 84 C # 45-12";
        DomicilioCuentaDAOImpl instance = new DomicilioCuentaDAOImpl();
        List<DomicilioCuenta> result = instance.findByDireccion(direccion);
        for (DomicilioCuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByBarrio() {
        System.out.println("findByBarrio");
        String barrio = "santa librada";
        DomicilioCuentaDAOImpl instance = new DomicilioCuentaDAOImpl();
        List<DomicilioCuenta> result = instance.findByBario(barrio);
        for (DomicilioCuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
     @Test
    public void testFindByLocalidad() {
        System.out.println("findByLocalidad");
        String localidad = "Usme";
        DomicilioCuentaDAOImpl instance = new DomicilioCuentaDAOImpl();
        List<DomicilioCuenta> result = instance.findByLocalidad(localidad);
        for (DomicilioCuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }
}
