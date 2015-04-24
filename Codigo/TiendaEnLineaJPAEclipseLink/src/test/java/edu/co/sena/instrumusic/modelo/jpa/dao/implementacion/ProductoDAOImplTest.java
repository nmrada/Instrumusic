/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.entities.Categoria;
import edu.co.sena.instrumusic.modelo.jpa.entities.Producto;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNATE
 */
public class ProductoDAOImplTest {
    Producto entity = new Producto();
    
    public ProductoDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        entity.setIdProducto("DA123");
        entity.setNombre("Bateria");
        entity.setMarca("Yamaha");
        entity.setReferencia("TS123");
        entity.setDescripcion("Es uan bateria de 16 platillos");
        entity.setMaterial("Plastico con acerado de metal");
        entity.setColor("negro");
        entity.setCantidad(6);
        entity.setActivo(true);
        entity.setPrecioUnitario(800000);
        entity.setDescuento(0);
        entity.setCategoriaidCategoria( new Categoria(1));
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
      //Test of insert method, of class PruductoDAOImpl.
     
    @Test
    public void testInsert() {
        System.out.println("insert");
        ProductoDAOImpl instance = new ProductoDAOImpl();
        instance.insert(entity);
    }
    
     //Test of update  method, of class PruductoDAOImpl.
        @Test
    public void testUpdate() {
        System.out.println("update");
        entity.setReferencia("ST12323");
        ProductoDAOImpl instance = new ProductoDAOImpl();
        instance.update(entity);
    }
    
    @Test
    public void testDelete() {
        System.out.println("delete");
       ProductoDAOImpl instance = new ProductoDAOImpl();
        Producto pro = instance.findByIdProducto("DA123");
        instance.delete(pro);
        
    }
    
     @Test
    public void testFindByIdProducto() {
        System.out.println("findByIdCarrito");
        Producto pro;
        String idProducto = "Da123";
        ProductoDAOImpl producto = new ProductoDAOImpl();
        pro = producto.findByIdProducto(idProducto);
        System.out.println(pro.getIdProducto());

    }
    
      @Test
    public void testFindByAll() {
        System.out.println("findByAll");
       ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> prolis = instance.findAll();
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }
    
    
     @Test
    public void testFindByNombre() {
        System.out.println("findByNombre");
        String nombre = "Bateria";
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> prolis = instance.findByNombre(nombre);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }
    
       @Test
    public void testFindByMarca() {
        System.out.println("findByMarca");
        String marca = "Yamaha";
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> prolis = instance.findByMarca(marca);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }
       @Test
    public void testFindByReferencia() {
        System.out.println("findByReferencia");
        String referencia = "ST12323";
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> prolis = instance.findByReferencia(referencia);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }
       @Test
    public void testFindByDescripcion() {
        System.out.println("findByDescripcion");
        String descripcion = "Es una bateria de 16 platillos";
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> prolis = instance.findByDescripcion(descripcion);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }
    
       @Test
    public void testFindByMaterial() {
        System.out.println("findByMaterial");
        String material = "Plastico con acerado de metal";
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> prolis = instance.findByMaterial(material);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }
    
       @Test
    public void testFindByColor() {
        System.out.println("findByColor");
        String color = "negro";
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> prolis = instance.findByColor(color);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }
    
       @Test
    public void testFindByCantidad() {
        System.out.println("findByNombre");
        int cantidad = 6;
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> prolis = instance.findByCantidad(cantidad);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }
    
    
        @Test
    public void testFindByCActivo() {
        System.out.println("findByActivo");
        boolean activo = true;
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> prolis = instance.findByActivo(activo);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }
    
        @Test
    public void testFindByPrecioUnitario() {
        System.out.println("findByPrecioUnitario");
        float precioUnitario = 800000;
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> prolis = instance.findByPrecioUnitario(precioUnitario);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }
    
       @Test
    public void testFindByDescuento() {
        System.out.println("findByDescuento");
        float Descuento = 0;
        ProductoDAOImpl instance = new ProductoDAOImpl();
        List<Producto> prolis = instance.findByDescuento(Descuento);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }
    
}
