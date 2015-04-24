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
import javax.persistence.Query;

/**
 *
 * @author ColsutecR
 */
public class CarritoDeComprasDAOImpl implements CarritoDeComprasDAO {

    public static final String TOTAL = "precioTotal";
    public static final String SUBTOTAL = "subtotal";
    public static final String IMPUESTOS = "impuestos";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(CarritoDeCompras entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(CarritoDeCompras entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(CarritoDeCompras entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(CarritoDeCompras.class, entity.getIdCarritoDeCompras());
            em.remove(entity);
            EntityManagerHelper.commit();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public List<CarritoDeCompras> findByAll() {
        EntityManager em = getEntityManager();
        List<CarritoDeCompras> carritosComprasTemporal = null;
        Query query = em.createNamedQuery("CarritoDeCompras.findAll");
        try {
            carritosComprasTemporal = query.getResultList();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return carritosComprasTemporal;
    }

    @Override
    public CarritoDeCompras findByIdCarrito(String idCarrito) {
        EntityManager em = getEntityManager();
        CarritoDeCompras carritoComprasTemporal = null;
        try {
            carritoComprasTemporal = em.find(CarritoDeCompras.class, idCarrito);
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return carritoComprasTemporal;
    }

    @Override
    public List<CarritoDeCompras> findByTotal(double total) {
        EntityManager em = getEntityManager();
        List<CarritoDeCompras> carritosComprasTemporal = null;
        try {
            Query query = em.createNamedQuery("CarritoDeCompras.findByPrecioTotal");
            query.setParameter(CarritoDeComprasDAOImpl.TOTAL, total);
            carritosComprasTemporal = query.getResultList();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return carritosComprasTemporal;
    }

    @Override
    public List<CarritoDeCompras> findBySubtotal(double subtotal) {
        EntityManager em = getEntityManager();
        List<CarritoDeCompras> carritosComprasTemporal = null;
        try {
            Query query = em.createNamedQuery("CarritoDeCompras.findBySubtotal");
            query.setParameter(CarritoDeComprasDAOImpl.SUBTOTAL, subtotal);
            carritosComprasTemporal = query.getResultList();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return carritosComprasTemporal;
    }

    @Override
    public List<CarritoDeCompras> findByImpuestos(double impuesto) {
        EntityManager em = getEntityManager();
        List<CarritoDeCompras> carritosComprasTemporal = null;
        try {
            Query query = em.createNamedQuery("CarritoDeCompras.findByImpuestos");
            query.setParameter(CarritoDeComprasDAOImpl.IMPUESTOS, impuesto);
            carritosComprasTemporal = query.getResultList();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return carritosComprasTemporal;
    }

}
