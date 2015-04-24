/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.CarritoDeComprasDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.CarritoDeCompras;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author ColsutecR
 */
public class CarritoDeComprasDAOImpl implements CarritoDeComprasDAO {

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(CarritoDeCompras entity) {
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (RuntimeException er) {
            System.err.println("error: ---"+er.getMessage());
        }
    }

    @Override
    public void update(CarritoDeCompras entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(CarritoDeCompras entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CarritoDeCompras findByIdCarrito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CarritoDeCompras> findByAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CarritoDeCompras> findByTotal(Object total) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CarritoDeCompras> findBySubtotal(Object subtotal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CarritoDeCompras> findByImpuestos(Object impuesto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
