/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ProveedorDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Proveedor;
import edu.co.sena.instrumusic.modelo.jpa.entities.ProveedorPK;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ColsutecR
 */
public class ProveedorDAOImpl implements ProveedorDAO {

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Proveedor entity) {
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
    public void update(Proveedor entity) {
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
    public void delete(Proveedor entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = em.getReference(Proveedor.class,
                    entity.getProveedorPK());
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
    public Proveedor findByIdProveedor(ProveedorPK llavePrimaria) {
        EntityManager em = getEntityManager();
        Proveedor proveedorTemporal = null;
        try {
            proveedorTemporal = em.find(Proveedor.class, llavePrimaria);
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return proveedorTemporal;
    }

    @Override
    public List<Proveedor> findAll() {
        EntityManager em = getEntityManager();
        List<Proveedor> proveedorTemporal = null;
        Query query = em.createNamedQuery("Proveedor.findAll");
        try {
            proveedorTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return proveedorTemporal;
    }

    @Override
    public List<Proveedor> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        List<Proveedor> proveedorTemporal = null;
        Query query = em.createNamedQuery("Proveedor.findByNombre");
        query.setParameter(ProveedorDAO.NOMBRE, nombre);
        try {
            proveedorTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return proveedorTemporal;
    }

    @Override
    public List<Proveedor> findByEmail(String email) {
     EntityManager em = getEntityManager();
        List<Proveedor> proveedorTemporal = null;
        Query query = em.createNamedQuery("Proveedor.findByEmail");
        query.setParameter(ProveedorDAO.EMAIL, email);
        try {
            proveedorTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return proveedorTemporal;
    }

}
