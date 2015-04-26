/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.Factura;
import java.util.Date;
import java.util.List;

/**
 *
 * @author My PC
 */
public interface IFacturaDAO {
    
    public void insert(Factura entity);

    public void update(Factura entity);

    public void delete(Factura entity);

    public Factura findByIdFactura(int idFactura);
    
    public List<Factura> findByAll();
    public List<Factura> findByFecha(Date fecha);
    public List<Factura> findByTotal(float total);
    
}
