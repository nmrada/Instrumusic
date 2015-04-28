/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IInventarioDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Inventario;
import edu.co.sena.instrumusic.modelo.jpa.entities.InventarioPK;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author ColsutecR
 */
public class InventarioDAOImpl extends AbstractDAO implements IInventarioDAO {

    protected static final Logger logger = Logger.getLogger(InventarioDAOImpl.class);
    public static final String FECHA = "fecha";
    public static final String CANTIDAD = "cantidad";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Inventario entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto el inventario " + entity.getInventarioPK());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

    }

    @Override
    public void update(Inventario entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el invetario " + entity.getInventarioPK());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void delete(Inventario entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Inventario.class, entity.getInventarioPK());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se elimino el inventario " + entity.getInventarioPK());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public Inventario findByIdInventario(InventarioPK idInventario) {
        EntityManager em = getEntityManager();
        Inventario inventarioTemporal = null;
        try {
            inventarioTemporal = em.find(Inventario.class, idInventario);
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return inventarioTemporal;

    }

    @Override
    public List<Inventario> findAll() {
        EntityManager em = getEntityManager();
        List<Inventario> invetarioTemporal = null;
        try {
            Query query = em.createNamedQuery("Inventario.findAll");
            invetarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return invetarioTemporal;
    }

    @Override
    public List<Inventario> findByFecha(Date fecha) {

        EntityManager em = getEntityManager();
        List<Inventario> inventarioTemporal = null;
        try {
            Query query = em.createNamedQuery("Inventario.findByFecha");
            query.setParameter(InventarioDAOImpl.FECHA, fecha);
            inventarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return inventarioTemporal;

    }

    @Override
    public List<Inventario> findByCantidad(int cantidad) {
        EntityManager em = getEntityManager();
        List<Inventario> inventarioTemporal = null;
        try {
            Query query = em.createNamedQuery("Inventario.findByCantidad");
            query.setParameter(InventarioDAOImpl.CANTIDAD, cantidad);
            inventarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return inventarioTemporal;
    }

}
