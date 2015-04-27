/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IDomicilioCuentaDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioCuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioCuentaPK;
import static edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper.getEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
public class DomicilioCuentaDAOImpl implements IDomicilioCuentaDAO {

    public static final String TELEFONO = "telefono";
    public static final String DIRECCION = "direccion";
    public static final String BARRIO = "barrio";
    public static final String LOCALIDAD = "localidad";

    @Override
    public void insert(DomicilioCuenta entity) {
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        }
    }

    @Override
    public void update(DomicilioCuenta entity) {
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        }
    }

    @Override
    public void delete(DomicilioCuenta entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(DomicilioCuenta.class, entity.getDomicilioCuentaPK());
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
    public List<DomicilioCuenta> findByAll() {
        EntityManager em = getEntityManager();
        List<DomicilioCuenta> domCuTemporal = null;
        Query query = em.createNamedQuery("DomicilioCuenta.findAll");
        try {
            domCuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domCuTemporal;
    }

    @Override
    public DomicilioCuenta findByIdDomicilioCuenta(DomicilioCuentaPK domiciliocuentaPk) {

        EntityManager em = getEntityManager();
        DomicilioCuenta domicilioCueTemporal = null;
        try {
            domicilioCueTemporal = em.find(DomicilioCuenta.class, domiciliocuentaPk);
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return domicilioCueTemporal;
    }

    @Override
    public List<DomicilioCuenta> findByTelefono(String telefono) {
        EntityManager em = getEntityManager();
        List<DomicilioCuenta> domCuTemporal = null;

        try {
            Query query = em.createNamedQuery("DomicilioCuenta.findByTelefono");
            query.setParameter(DomicilioCuentaDAOImpl.TELEFONO, telefono);
            domCuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domCuTemporal;
    }

    @Override
    public List<DomicilioCuenta> findByDireccion(String direccion) {
        EntityManager em = getEntityManager();
        List<DomicilioCuenta> domCuTemporal = null;

        try {
            Query query = em.createNamedQuery("DomicilioCuenta.findByDireccion");
            query.setParameter(DomicilioCuentaDAOImpl.DIRECCION, direccion);
            domCuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domCuTemporal;
    }

    @Override
    public List<DomicilioCuenta> findByBario(String barrio) {
        EntityManager em = getEntityManager();
        List<DomicilioCuenta> domCuTemporal = null;

        try {
            Query query = em.createNamedQuery("DomicilioCuenta.findByBarrio");
            query.setParameter(DomicilioCuentaDAOImpl.BARRIO, barrio);
            domCuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domCuTemporal;
    }

    @Override
    public List<DomicilioCuenta> findByLocalidad(String localidad) {
        EntityManager em = getEntityManager();
        List<DomicilioCuenta> domCuTemporal = null;

        try {
            Query query = em.createNamedQuery("DomicilioCuenta.findByLocalidad");
            query.setParameter(DomicilioCuentaDAOImpl.LOCALIDAD, localidad);
            domCuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return domCuTemporal;
    }
}
