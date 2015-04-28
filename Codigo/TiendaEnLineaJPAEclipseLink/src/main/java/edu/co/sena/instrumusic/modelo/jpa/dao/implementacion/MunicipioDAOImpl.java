/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;


import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IMunicipioDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Municipio;
import static edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper.getEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author admin
 */
public class MunicipioDAOImpl extends AbstractDAO implements IMunicipioDAO{
    
    protected static final Logger logger = Logger.getLogger(MunicipioDAOImpl.class);
      public static final String NOMBRE = "nombre";
    
    @Override
    public void insert(Municipio entity) {
         try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto el municipio " + entity.getIdMunicipio());
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
           
                EntityManagerHelper.closeEntityManager();
            
        }
    }

    @Override
    public void update(Municipio entity) {
         try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el municipio " + entity.getIdMunicipio());
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
           
                EntityManagerHelper.closeEntityManager();
            
        }
    }

    @Override
    public void delete(Municipio entity) {
       EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Municipio.class, entity.getIdMunicipio());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se elimino el municipio " + entity.getIdMunicipio());
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
           
                EntityManagerHelper.closeEntityManager();
            
        }
    }

    @Override
    public Municipio findByIdMunicipio(String idMunicipio) {
        EntityManager em = getEntityManager();
        Municipio munTemporal = null;
        try {
            munTemporal = em.find(Municipio.class, idMunicipio);
        } catch (RuntimeException re) {
           logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return munTemporal;
    }

    @Override
    public List<Municipio> findByAll() {
        EntityManager em = getEntityManager();
        List<Municipio> munTemporal = null;
        Query query = em.createNamedQuery("Municipio.findAll");
        try {
            munTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return munTemporal;
    }

    @Override
    public List<Municipio> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        List<Municipio> munTemporal = null;

        try {
            Query query = em.createNamedQuery("Municipio.findByNombre");
            query.setParameter(MunicipioDAOImpl.NOMBRE, nombre);
            munTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return munTemporal;
    }

   
}
