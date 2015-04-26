/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ITipoDocumentoDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.TipoDocumento;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Nicolas
 */
public class TipoDocumentoDAOImpl implements ITipoDocumentoDAO {

    public static final String DESCRIPCION = "descripcion";
    public static final String ACTIVO = "activo";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(TipoDocumento entity) {
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
    public void update(TipoDocumento entity) {
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
    public void delete(TipoDocumento entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(TipoDocumento.class, entity.getTipoDocumento());
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
    public TipoDocumento findByTipoDocumento(String tipoDocumento) {
        EntityManager em = getEntityManager();
        TipoDocumento tipoDocumentoTemporal = null;
        try {
            tipoDocumentoTemporal = em.find(TipoDocumento.class, tipoDocumento);
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return tipoDocumentoTemporal;
    }

    @Override
    public List<TipoDocumento> findByAll() {
        EntityManager em = getEntityManager();
        List<TipoDocumento> tiposDocumentosTemporal = null;
        Query query = em.createNamedQuery("TipoDocumento.findAll");
        try {
            tiposDocumentosTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return tiposDocumentosTemporal;
    }

    @Override
    public List<TipoDocumento> findByDescripcion(String descripcion) {
        EntityManager em = getEntityManager();
        List<TipoDocumento> tiposDocumentosTemporal = null;
        try {
            Query query = em.createNamedQuery("TipoDocumento.findByDescripcion");
            query.setParameter(TipoDocumentoDAOImpl.DESCRIPCION, descripcion);
            tiposDocumentosTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return tiposDocumentosTemporal;
    }

    @Override
    public List<TipoDocumento> findByActivo(boolean activo) {
        EntityManager em = getEntityManager();
        List<TipoDocumento> tiposDocumentosTemporal = null;
        try {
            Query query = em.createNamedQuery("TipoDocumento.findByActivo");
            query.setParameter(TipoDocumentoDAOImpl.ACTIVO, activo);
            tiposDocumentosTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return tiposDocumentosTemporal;
    }

}
