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

/**
 *
 * @author ColsutecR
 */
public class InventarioDAOImpl implements IInventarioDAO {

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
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }

    }

    @Override
    public void update(Inventario entity) {
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
    public void delete(Inventario entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Inventario.class, entity.getInventarioPK());
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
    public Inventario findByIdInventario(InventarioPK idInventario) {
        EntityManager em = getEntityManager();
        Inventario inventarioTemporal = null;
        try {
            inventarioTemporal = em.find(Inventario.class, idInventario);
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return inventarioTemporal;

    }

    @Override
    public List<Inventario> findAll() {
        EntityManager em = getEntityManager();
        List<Inventario> invetarioTemporal = null;
        Query query = em.createNamedQuery("Inventario.findAll");
        try {
            invetarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
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
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
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
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return inventarioTemporal;
    }

}
