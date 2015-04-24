/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.CarritoDeCompras;
import java.util.List;

/**
 *
 * @author ColsutecR
 */
public interface CarritoDeComprasDAO {

    public void insert(CarritoDeCompras entity);

    public void update(CarritoDeCompras entity);

    public void delete(CarritoDeCompras entity);

    public CarritoDeCompras findByIdCarrito(String idCarrito);

    public List<CarritoDeCompras> findByAll();
    public List<CarritoDeCompras> findByTotal(double total);
    public List<CarritoDeCompras> findBySubtotal(double subtotal);
    public List<CarritoDeCompras> findByImpuestos(double impuesto);

}
