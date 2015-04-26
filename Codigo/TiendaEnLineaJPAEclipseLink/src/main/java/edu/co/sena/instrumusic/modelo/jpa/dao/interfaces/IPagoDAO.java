/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.Pago;
import java.util.List;

/**
 *
 * @author My PC
 */
public interface IPagoDAO {
    
    public void insert(Pago entity);

    public void update(Pago entity);

    public void delete(Pago entity);

    public Pago findByIdPago(int idFactura);

    public List<Pago> findByAll();
    public List<Pago> findByFacturaidFactura(int idFactura);
    public List<Pago> findByNumTarCredito(String numTarjetaCredito);
    public List<Pago> findByBanco(String banco);
    public List<Pago> findByTipoCuentaTar(String tipoCuetaTar);
    public List<Pago> findByTipoTransaccion(String tipoTransaccion);
    
}
