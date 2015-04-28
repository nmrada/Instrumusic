/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ICarritoDeComprasDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.CarritoDeCompras;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author ColsutecR
 */
public class CarritoDeComprasDAOImpl extends AbstractDAO implements ICarritoDeComprasDAO {

    protected static final Logger logger = Logger.getLogger(CarritoDeComprasDAOImpl.class);
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
            logger.info("Se inserto el Carrito de Compras " + entity.getIdCarritoDeCompras());
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void update(CarritoDeCompras entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el Carrito de Compras " + entity.getIdCarritoDeCompras());
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            EntityManagerHelper.closeEntityManager();
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
            logger.info("Se elimino el Carrito de Compras " + entity.getIdCarritoDeCompras());
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public List<CarritoDeCompras> findByAll() {
        EntityManager em = getEntityManager();
        List<CarritoDeCompras> carritosComprasTemporal = null;
        try {
            Query query = em.createNamedQuery("CarritoDeCompras.findAll");
            carritosComprasTemporal = query.getResultList();
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            EntityManagerHelper.closeEntityManager();
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
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return carritoComprasTemporal;
    }

    @Override
    public List<CarritoDeCompras> findByTotal(float total) {
        EntityManager em = getEntityManager();
        List<CarritoDeCompras> carritosComprasTemporal = null;
        try {
            Query query = em.createNamedQuery("CarritoDeCompras.findByPrecioTotal");
            query.setParameter(CarritoDeComprasDAOImpl.TOTAL, total);
            carritosComprasTemporal = query.getResultList();
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return carritosComprasTemporal;
    }

    @Override
    public List<CarritoDeCompras> findBySubtotal(float subtotal) {
        EntityManager em = getEntityManager();
        List<CarritoDeCompras> carritosComprasTemporal = null;
        try {
            Query query = em.createNamedQuery("CarritoDeCompras.findBySubtotal");
            query.setParameter(CarritoDeComprasDAOImpl.SUBTOTAL, subtotal);
            carritosComprasTemporal = query.getResultList();
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return carritosComprasTemporal;
    }

    @Override
    public List<CarritoDeCompras> findByImpuestos(float impuesto) {
        EntityManager em = getEntityManager();
        List<CarritoDeCompras> carritosComprasTemporal = null;
        try {
            Query query = em.createNamedQuery("CarritoDeCompras.findByImpuestos");
            query.setParameter(CarritoDeComprasDAOImpl.IMPUESTOS, impuesto);
            carritosComprasTemporal = query.getResultList();
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return carritosComprasTemporal;
    }
}
