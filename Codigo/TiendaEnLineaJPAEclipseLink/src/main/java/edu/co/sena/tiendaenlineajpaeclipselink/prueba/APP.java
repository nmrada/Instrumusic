/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendaenlineajpaeclipselink.prueba;

import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Categoria;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ColsutecR
 */
public class APP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Categoria c1 = new Categoria();
        c1.setIdCategoria(1);
        c1.setNombreCategoria("Categoria Padre");
        c1.setPariente(1);
        c1.setActiva(true);
        
        
        Producto p1 = new Producto();
        p1.setIdProducto("001");
        p1.setNombre("Guitarra Electrica");
        p1.setDescripcion("Guitarra Elcetrica Color Azul Referencia 69");
        p1.setCantidad(5);
        p1.setActivo(true);
        p1.setCategoriaidCategoria(c1);
        p1.setColor("Azul");
        p1.setDescuento(0);
        p1.setMarca("Fander");
        p1.setMaterial("Caoba");
        p1.setPrecioUnitario(500000);
        p1.setReferencia("69");
        
        Producto p2 = new Producto();
        p2.setIdProducto("00");
        p2.setNombre("Guitarra Acustica");
        p2.setDescripcion("Guitarra Acustica Color Negro Referencia 6969");
        p2.setCantidad(5);
        p2.setActivo(true);
        p2.setCategoriaidCategoria(c1);
        p2.setColor("Negro");
        p2.setDescuento(0);
        p2.setMarca("Fander");
        p2.setMaterial("Caoba");
        p2.setPrecioUnitario(300000);
        p2.setReferencia("6969");

        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("edu.co.sena_TiendaEnLineaJPAEclipseLink_jar_1.0-SNAPSHOTPU");
        EntityManager em1 = emf1.createEntityManager();
        em1.getTransaction().begin();

        //em1.persist(c1);
        //em1.persist(catalogo1);
        em1.merge(p1);
        em1.merge(p2);

        em1.getTransaction().commit();

        em1.close();
        emf1.close();

    }

}
