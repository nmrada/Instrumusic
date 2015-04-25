/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.Pedido;
import java.util.List;

/**
 *
 * @author My PC
 */
public interface IPedidoDAO {
    
    public void insert(Pedido entity);

    public void update(Pedido entity);

    public void delete(Pedido entity);

    public Pedido findByIdPedido(Integer idFactura);

    public List<Pedido> findByAll();
    public List<Pedido> findByFacturaidFactura(Integer idFactura);
    public List<Pedido> findByTotal(Integer total);
    public List<Pedido> findBySubtotal(Integer subtotal);
    public List<Pedido> findByImpuestos(Integer impuestos);
    
}
