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

/**
 *
 * @author admin
 */
public class DepartamentoDAOImpl implements IDepartamentoDAO{

     public static final String NOMBRE = "nombre";
    
    @Override
    public void insert(Departamento entity) {
         try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (RuntimeException er) {
            System.err.println("error: ---"+er.getMessage());
        }
    }

    @Override
    public void update(Departamento entity) {
         try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
        } catch (RuntimeException er) {
            System.err.println("error: ---"+er.getMessage());
        }
    }

    @Override
    public void delete(Departamento entity) {
         EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Departamento.class, entity.getIdDepartamento());
            em.remove(entity);
            EntityManagerHelper.commit();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public Departamento findByIdDepartamento(String idDepartamento) {
        EntityManager em = getEntityManager();
        Departamento deparTemporal = null;
        try {
            deparTemporal = em.find(Departamento.class, idDepartamento);
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return deparTemporal;
    }

    @Override
    public List<Departamento> findByAll() {
        EntityManager em = getEntityManager();
        List<Departamento> deparTemporal = null;
        Query query = em.createNamedQuery("Departamento.findAll");
        try {
            deparTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return deparTemporal;
    }

    @Override
    public List<Departamento> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        List<Departamento> deparTemporal = null;

        try {
            Query query = em.createNamedQuery("Departamento.findByNombre");
            query.setParameter(DepartamentoDAOImpl.NOMBRE, nombre);
            deparTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return deparTemporal;
    }
    
}
