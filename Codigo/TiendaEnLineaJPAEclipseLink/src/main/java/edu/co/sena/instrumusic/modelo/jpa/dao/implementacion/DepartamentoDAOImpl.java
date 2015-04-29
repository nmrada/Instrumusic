/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IDepartamentoDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Departamento;
import static edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper.getEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author admin
 */
public class DepartamentoDAOImpl extends AbstractDAO implements IDepartamentoDAO {

    protected static final Logger logger = Logger.getLogger(DepartamentoDAOImpl.class);
    public static final String NOMBRE = "nombre";

    @Override
    public void insert(Departamento entity) {
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto el Departamento " + entity.getIdDepartamento());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void update(Departamento entity) {
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el Departamento " + entity.getIdDepartamento());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void delete(Departamento entity) {
        try {
            EntityManager em = getEntityManager();
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Departamento.class, entity.getIdDepartamento());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se elimino el Departamento " + entity.getIdDepartamento());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public Departamento findByIdDepartamento(String idDepartamento) {
        Departamento deparTemporal = null;
        try {
            EntityManager em = getEntityManager();
            deparTemporal = em.find(Departamento.class, idDepartamento);
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return deparTemporal;
    }

    @Override
    public List<Departamento> findByAll() {
        List<Departamento> deparTemporal = null;
        try {
            EntityManager em = getEntityManager();
            Query query = em.createNamedQuery("Departamento.findAll");
            deparTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return deparTemporal;
    }

    @Override
    public List<Departamento> findByNombre(String nombre) {
        List<Departamento> deparTemporal = null;
        try {
            EntityManager em = getEntityManager();
            Query query = em.createNamedQuery("Departamento.findByNombre");
            query.setParameter(DepartamentoDAOImpl.NOMBRE, nombre);
            deparTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return deparTemporal;
    }
}
