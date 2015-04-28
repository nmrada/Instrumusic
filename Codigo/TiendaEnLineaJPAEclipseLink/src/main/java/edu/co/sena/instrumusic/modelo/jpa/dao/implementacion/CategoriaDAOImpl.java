/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ICategoriaDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Categoria;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import static edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper.getEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author BERNATE
 */
public class CategoriaDAOImpl extends AbstractDAO implements ICategoriaDAO {

    protected static final Logger logger = Logger.getLogger(CategoriaDAOImpl.class);
    public static final String IDCATEGORIA = "idCategoria";
    public static final String NOMBRECATEGORIA = "nombreCategoria";
    public static final String ACTIVA = "activa";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Categoria entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto la Categoria " + entity.getIdCategoria());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(Categoria entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo la Categoria " + entity.getIdCategoria());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }

        }
    }

    @Override
    public void delete(Categoria entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Categoria.class, entity.getIdCategoria());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se elimino la Categoria " + entity.getIdCategoria());
        } catch (RuntimeException re) {
           logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }


    @Override
    public List<Categoria> findAll() {
        EntityManager em = getEntityManager();
        List<Categoria> categoriaTemp = null;
        Query query = em.createNamedQuery("Categoria.findAll");
        try {
            categoriaTemp = query.getResultList();
        } catch (RuntimeException re) {
           logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriaTemp;
    }

    @Override
    public List<Categoria> findByNombreCategoria(String nombreCategoria) {
        EntityManager em = getEntityManager();
        List<Categoria> categoriaTemp = null;
        try {
            Query query = em.createNamedQuery("Categoria.findByNombreCategoria");
            query.setParameter(CategoriaDAOImpl.NOMBRECATEGORIA, nombreCategoria);
            categoriaTemp = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriaTemp;
    }


    @Override
    public Categoria findByIdCategoria(Integer idCategoria) {
        EntityManager em = getEntityManager();
        Categoria categoriaTemp = null;
        try {
            categoriaTemp = em.find(Categoria.class, idCategoria);
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return categoriaTemp;
    }

    @Override
    public List<Categoria> findByActiva(Boolean activa) {
        EntityManager em = getEntityManager();
        List<Categoria> categoriaTemp = null;
        try {
            Query query = em.createNamedQuery("Categoria.findByActiva");
            query.setParameter(CategoriaDAOImpl.ACTIVA, activa);
            categoriaTemp = query.getResultList();
        } catch (RuntimeException re) {
             logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriaTemp;
    }

}
