/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IItemCarritoDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarrito;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarritoPK;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author ColsutecR
 */
public class ItemCarritoDAOImpl extends AbstractDAO implements IItemCarritoDAO {

    protected static final Logger logger = Logger.getLogger(ItemCarritoDAOImpl.class);
    public static final String CANTIDAD = "cantidad";
    public static final String COSTO_UNITARIO = "costoUnitario";
    public static final String COSTO_TOTAL = "costoTotal";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(ItemCarrito entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto el Item Carrito "+entity.getItemCarritoPK());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(ItemCarrito entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el Item Carrito "+entity.getItemCarritoPK());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(ItemCarrito entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(ItemCarrito.class, entity.getItemCarritoPK());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se elimino el Item Carrito "+entity.getItemCarritoPK());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public List<ItemCarrito> findByAll() {
        EntityManager em = getEntityManager();
        List<ItemCarrito> itemsCarritoTemporal = null;
        Query query = em.createNamedQuery("ItemCarrito.findAll");
        try {
            itemsCarritoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemsCarritoTemporal;
    }

    @Override
    public List<ItemCarrito> findByCantidad(int cantidad) {
        EntityManager em = getEntityManager();
        List<ItemCarrito> itemsCarritoTemporal = null;
        try {
            Query query = em.createNamedQuery("ItemCarrito.findByCantidad");
            query.setParameter(ItemCarritoDAOImpl.CANTIDAD, cantidad);
            itemsCarritoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemsCarritoTemporal;
    }

    @Override
    public List<ItemCarrito> findByCostoUnitario(float costoUnitario) {
        EntityManager em = getEntityManager();
        List<ItemCarrito> itemsCarritoTemporal = null;
        try {
            Query query = em.createNamedQuery("ItemCarrito.findByCostoUnitario");
            query.setParameter(ItemCarritoDAOImpl.COSTO_UNITARIO, costoUnitario);
            itemsCarritoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemsCarritoTemporal;
    }

    @Override
    public List<ItemCarrito> findByCostoTotal(float costoTotal) {
        EntityManager em = getEntityManager();
        List<ItemCarrito> itemsCarritoTemporal = null;
        try {
            Query query = em.createNamedQuery("ItemCarrito.findByCostoTotal");
            query.setParameter(ItemCarritoDAOImpl.COSTO_TOTAL, costoTotal);
            itemsCarritoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemsCarritoTemporal;
    }

    @Override
    public ItemCarrito findByIdItemCarrito(ItemCarritoPK itemCarritoPk) {
        EntityManager em = getEntityManager();
        ItemCarrito itemCarritoTemporal = null;
        try {
            itemCarritoTemporal = em.find(ItemCarrito.class, itemCarritoPk);
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemCarritoTemporal;
    }

}
