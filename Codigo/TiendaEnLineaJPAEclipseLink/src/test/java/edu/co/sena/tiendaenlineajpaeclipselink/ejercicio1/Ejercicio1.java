/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlineajpaeclipselink.ejercicio1;

import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Categoria;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Departamento;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Municipio;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Producto;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.util.EntityManagerHelper;
import java.util.ArrayList;

import java.util.List;
import javax.persistence.EntityManager;
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
public class Ejercicio1 {

    Categoria categoria;
    List<Producto> productos;
    EntityManager em;
    Producto producto4;

    public Ejercicio1() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        categoria = new Categoria();
        categoria.setIdCategoria(1);
        categoria.setNombreCategoria("Categoria 1");
        categoria.setActiva(true);
        categoria.setPariente(1);
        productos = new ArrayList<>();
        Producto producto;
        producto = new Producto();
        producto.setIdProducto("001");
        producto.setMarca("Fander");
        producto.setNombre("Guitarra Electrica");
        producto.setMaterial("Caoba");
        producto.setReferencia("xxz");
        producto.setDescripcion("Guitarra Electrica referencia xxz marca fander");
        producto.setActivo(true);
        producto.setCantidad(5);
        producto.setColor("Negro");
        producto.setDescuento(0);
        producto.setPrecioUnitario(600000);
        producto.setCategoriaidCategoria(categoria);

        Producto producto2;
        producto2 = new Producto();
        producto2.setIdProducto("002");
        producto2.setMarca("Fander");
        producto2.setNombre("Guitarra Electrica");
        producto2.setMaterial("Caoba");
        producto2.setReferencia("xxz");
        producto2.setDescripcion("Guitarra Electrica referencia xxz marca fander");
        producto2.setActivo(true);
        producto2.setCantidad(5);
        producto2.setColor("Negro");
        producto2.setDescuento(0);
        producto2.setPrecioUnitario(600000);
        producto2.setCategoriaidCategoria(categoria);

        Producto producto3;
        producto3 = new Producto();
        producto3.setIdProducto("003");
        producto3.setMarca("Fander");
        producto3.setNombre("Guitarra Electrica");
        producto3.setMaterial("Caoba");
        producto3.setReferencia("xxz");
        producto3.setDescripcion("Guitarra Electrica referencia xxz marca fander");
        producto3.setActivo(true);
        producto3.setCantidad(5);
        producto3.setColor("Negro");
        producto3.setDescuento(0);
        producto3.setPrecioUnitario(600000);
        producto3.setCategoriaidCategoria(categoria);

        producto4 = new Producto();
        producto4.setIdProducto("004");
        producto4.setMarca("Fander");
        producto4.setNombre("Guitarra Electrica");
        producto4.setMaterial("Caoba");
        producto4.setReferencia("xxz");
        producto4.setDescripcion("Guitarra Electrica referencia xxz marca fander");
        producto4.setActivo(true);
        producto4.setCantidad(5);
        producto4.setColor("Negro");
        producto4.setDescuento(0);
        producto4.setPrecioUnitario(600000);
        producto4.setCategoriaidCategoria(new Categoria(2, "Categoria 2", true, 2));

        productos.add(producto);
        productos.add(producto2);
        productos.add(producto3);
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
    public void insertarCategoria() {
        categoria.setProductoCollection(productos);
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(categoria);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void insertarProducto() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(producto4);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }
    
    @Test
    public void buscarMunicipiosporIdDepartamento(){
        String idDep = JOptionPane.showInputDialog("Digite el id del Departamento");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Departamento departamentoTemporal = em.find(Departamento.class, idDep);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
        List<Municipio> municipios = (List)departamentoTemporal.getMunicipioCollection();
        for (Municipio municipio : municipios) {
            System.out.println(municipio.toString());
        }
    }
}
