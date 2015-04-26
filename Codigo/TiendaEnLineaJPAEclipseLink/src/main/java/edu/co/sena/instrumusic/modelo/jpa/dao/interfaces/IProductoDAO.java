/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.Producto;
import java.util.List;

/**
 *
 * @author BERNATE
 */
public interface IProductoDAO {

    public void insert(Producto entity);

    public void update(Producto entity);

    public void delete(Producto entity);

    public Producto findByIdProducto(String idproducto);

    public List<Producto> findAll();

    public List<Producto> findByNombre(String nombre);

    public List<Producto> findByMarca(String marca);

    public List<Producto> findByReferencia(String referencia);

    public List<Producto> findByDescripcion(String descripcion);

    public List<Producto> findByMaterial(String material);

    public List<Producto> findByColor(String color);

    public List<Producto> findByCantidad(int cantidad);

    public List<Producto> findByActivo(boolean activo);

    public List<Producto> findByPrecioUnitario(float precioUnitario);

    public List<Producto> findByDescuento(float descuento);

}
