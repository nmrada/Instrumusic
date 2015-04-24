/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ItemCarritoDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarrito;
import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarritoPK;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ColsutecR
 */
public class ItemCarritoDAOImpl implements ItemCarritoDAO {

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
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
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
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
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
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
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
            System.out.println("erorrr:----------------" + re.getMessage());
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
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemsCarritoTemporal;
    }

    @Override
    public List<ItemCarrito> findByCostoUnitario(double costoUnitario) {
        EntityManager em = getEntityManager();
        List<ItemCarrito> itemsCarritoTemporal = null;
        try {
            Query query = em.createNamedQuery("ItemCarrito.findByCostoUnitario");
            query.setParameter(ItemCarritoDAOImpl.COSTO_UNITARIO, costoUnitario);
            itemsCarritoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemsCarritoTemporal;
    }

    @Override
    public List<ItemCarrito> findByCostoTotal(double costoTotal) {
        EntityManager em = getEntityManager();
        List<ItemCarrito> itemsCarritoTemporal = null;
        try {
            Query query = em.createNamedQuery("ItemCarrito.findByCostoTotal");
            query.setParameter(ItemCarritoDAOImpl.COSTO_TOTAL, costoTotal);
            itemsCarritoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
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
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemCarritoTemporal;
    }

}
