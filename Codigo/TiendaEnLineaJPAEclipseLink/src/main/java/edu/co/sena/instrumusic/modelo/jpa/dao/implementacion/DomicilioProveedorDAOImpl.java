/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IDomicilioProveedorDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedor;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioProveedorPK;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author ColsutecR
 */
public class DomicilioProveedorDAOImpl extends AbstractDAO implements IDomicilioProveedorDAO {

    protected static final Logger logger = Logger.getLogger(DomicilioProveedorDAOImpl.class);
    public static final String TELEFONO = "telefono";
    public static final String DIRECCION = "direccion";
    public static final String BARRIO = "barrio";
    public static final String LOCALIDAD = "localidad";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(DomicilioProveedor entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto el Domicilio Proveedor "+entity.getDomicilioProveedorPK());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(DomicilioProveedor entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el Domicilio Proveedor "+entity.getDomicilioProveedorPK());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(DomicilioProveedor entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(DomicilioProveedor.class, entity.getDomicilioProveedorPK());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se elimino el Domicilio Proveedor "+entity.getDomicilioProveedorPK());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public DomicilioProveedor findByIdDomicilioProveedor(DomicilioProveedorPK domicilioProveedorPk) {
        EntityManager em = getEntityManager();
        DomicilioProveedor domicilioProveedorTemporal = null;
        try {
            domicilioProveedorTemporal = em.find(DomicilioProveedor.class, domicilioProveedorPk);
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return domicilioProveedorTemporal;
    }

    @Override
    public List<DomicilioProveedor> findByAll() {
        EntityManager em = getEntityManager();
        List<DomicilioProveedor> domiciliosProveedorTemporal = null;
        Query query = em.createNamedQuery("DomicilioProveedor.findAll");
        try {
            domiciliosProveedorTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return domiciliosProveedorTemporal;
    }

    @Override
    public List<DomicilioProveedor> findByTelefono(String telefono) {
        EntityManager em = getEntityManager();
        List<DomicilioProveedor> domiciliosProveedorTemporal = null;
        try {
            Query query = em.createNamedQuery("DomicilioProveedor.findByTelefono");
            query.setParameter(DomicilioProveedorDAOImpl.TELEFONO, telefono);
            domiciliosProveedorTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return domiciliosProveedorTemporal;
    }

    @Override
    public List<DomicilioProveedor> findByDireccion(String direccion) {
        EntityManager em = getEntityManager();
        List<DomicilioProveedor> domiciliosProveedorTemporal = null;
        try {
            Query query = em.createNamedQuery("DomicilioProveedor.findByDireccion");
            query.setParameter(DomicilioProveedorDAOImpl.DIRECCION, direccion);
            domiciliosProveedorTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return domiciliosProveedorTemporal;
    }

    @Override
    public List<DomicilioProveedor> findByBarrio(String barrio) {
        EntityManager em = getEntityManager();
        List<DomicilioProveedor> domiciliosProveedorTemporal = null;
        try {
            Query query = em.createNamedQuery("DomicilioProveedor.findByBarrio");
            query.setParameter(DomicilioProveedorDAOImpl.BARRIO, barrio);
            domiciliosProveedorTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return domiciliosProveedorTemporal;
    }

    @Override
    public List<DomicilioProveedor> findByLocalidad(String localidad) {
        EntityManager em = getEntityManager();
        List<DomicilioProveedor> domiciliosProveedorTemporal = null;
        try {
            Query query = em.createNamedQuery("DomicilioProveedor.findByLocalidad");
            query.setParameter(DomicilioProveedorDAOImpl.LOCALIDAD, localidad);
            domiciliosProveedorTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return domiciliosProveedorTemporal;
    }

}
