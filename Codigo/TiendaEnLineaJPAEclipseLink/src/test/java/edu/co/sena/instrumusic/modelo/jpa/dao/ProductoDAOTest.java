/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.factory.DAOFactory;
import edu.co.sena.instrumusic.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IProductoDAO;
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
public class ProductoDAOTest {

    Producto entity = new Producto();

    public ProductoDAOTest() {
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
        entity.setCategoriaidCategoria( new Categoria(2));

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
        System.out.println("insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        instance.insert(entity);
    }

    //Test of update  method, of class PruductoDAOImpl.
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        entity.setReferencia("ST12323");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        instance.update(entity);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        Producto pro = instance.findByIdProducto("DA123");
        instance.delete(pro);

    }

    @Test
    public void testFindByIdProducto() throws Exception {
        System.out.println("findByIdCarrito");
        Producto pro;
        String idProducto = "DA123";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        pro = instance.findByIdProducto(idProducto);
        System.out.println(pro.getIdProducto());

    }

    @Test
    public void testFindByAll() throws Exception {
        System.out.println("findByAll");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        List<Producto> prolis = instance.findAll();
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }

    @Test
    public void testFindByNombre() throws Exception {
        System.out.println("findByNombre");
        String nombre = "Bateria";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        List<Producto> prolis = instance.findByNombre(nombre);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }

    @Test
    public void testFindByMarca() throws Exception {
        System.out.println("findByMarca");
        String marca = "Yamaha";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        List<Producto> prolis = instance.findByMarca(marca);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }

    @Test
    public void testFindByReferencia() throws Exception {
        System.out.println("findByReferencia");
        String referencia = "ST12323";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        List<Producto> prolis = instance.findByReferencia(referencia);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }

    @Test
    public void testFindByDescripcion() throws Exception {
        System.out.println("findByDescripcion");
        String descripcion = "Es una bateria de 16 platillos";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        List<Producto> prolis = instance.findByDescripcion(descripcion);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }

    @Test
    public void testFindByMaterial() throws Exception {
        System.out.println("findByMaterial");
        String material = "Plastico con acerado de metal";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        List<Producto> prolis = instance.findByMaterial(material);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }

    @Test
    public void testFindByColor() throws Exception {
        System.out.println("findByColor");
        String color = "negro";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        List<Producto> prolis = instance.findByColor(color);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }

    @Test
    public void testFindByCantidad() throws Exception {
        System.out.println("findByNombre");
        int cantidad = 6;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        List<Producto> prolis = instance.findByCantidad(cantidad);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }

    @Test
    public void testFindByCActivo() throws Exception {
        System.out.println("findByActivo");
        boolean activo = true;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        List<Producto> prolis = instance.findByActivo(activo);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }

    @Test
    public void testFindByPrecioUnitario() throws Exception {
        System.out.println("findByPrecioUnitario");
        float precioUnitario = 800000;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        List<Producto> prolis = instance.findByPrecioUnitario(precioUnitario);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }

    @Test
    public void testFindByDescuento() throws Exception {
        System.out.println("findByDescuento");
        float Descuento = 0;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        IProductoDAO instance = fabrica.createProductoDAO();
        List<Producto> prolis = instance.findByDescuento(Descuento);
        for (Producto prolis1 : prolis) {
            System.out.println(prolis1.getIdProducto());
        }
    }

}
