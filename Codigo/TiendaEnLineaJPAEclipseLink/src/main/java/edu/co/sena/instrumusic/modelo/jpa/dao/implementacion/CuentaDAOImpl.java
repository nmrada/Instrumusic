/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.CuentaDAO;
import static edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper.getEntityManager;
import edu.co.sena.instrumusic.modelo.jpa.entities.Cuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.CuentaPK;
import edu.co.sena.instrumusic.modelo.jpa.entities.DomicilioCuenta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author admin
 */
public class CuentaDAOImpl implements CuentaDAO{
    
    public static final String PRIMERNOMBRE= "primerNombre";
    public static final String SEGUNDONOMBRE = "segundoNombre";
    public static final String PRIMERAPELLIDO = "primerApellido";
    public static final String SEGUNDOAPELLIDO= "segundoApellido";

    @Override
    public void insert(Cuenta entity) {
      EntityManager em = EntityManagerHelper.getEntityManager();
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
    public void update(Cuenta entity) {
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
    public void delete(Cuenta entity) {
         EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.remove(em.find(Cuenta.class, entity.getCuentaPK()));
            EntityManagerHelper.commit();
        } catch (RuntimeException re) {
            System.out.println("Error : " + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
    }
        }
    }
    
    @Override
    public List<Cuenta> findByAll() {
       EntityManager em = getEntityManager();
        List<Cuenta> cuTemporal = null;
        Query query = em.createNamedQuery("Cuenta.findAll");
        try {
           cuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuTemporal;
    }

    @Override
    public List<Cuenta> findByPrimerNombre(String primerNombre) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuTemporal = null;

        try {
            Query query = em.createNamedQuery("Cuenta.findByPrimerNombre");
            query.setParameter(CuentaDAOImpl.PRIMERNOMBRE, primerNombre);
            cuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuTemporal;
    }

    @Override
    public List<Cuenta> findBySegundoNombre(String segundoNombre) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuTemporal = null;

        try {
            Query query = em.createNamedQuery("Cuenta.findBySegundoNombre");
            query.setParameter(CuentaDAOImpl.SEGUNDONOMBRE, segundoNombre);
            cuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuTemporal;
    }

    @Override
    public List<Cuenta> findByPrimerApellido(String primerApellido) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuTemporal = null;

        try {
            Query query = em.createNamedQuery("Cuenta.findByPrimerApellido");
            query.setParameter(CuentaDAOImpl.PRIMERAPELLIDO, primerApellido);
            cuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuTemporal;
    }

    @Override
    public List<Cuenta> findBySegundoApellido(String segundoApellido) {
        EntityManager em = getEntityManager();
        List<Cuenta> cuTemporal = null;

        try {
            Query query = em.createNamedQuery("Cuenta.findBySegundoApellido");
            query.setParameter(CuentaDAOImpl.SEGUNDOAPELLIDO, segundoApellido);
            cuTemporal = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cuTemporal;
    }

    @Override
    public Cuenta findByIdCuenta(CuentaPK cuentaPk) {
    
        Cuenta cuentaTemporal = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {

            cuentaTemporal = em.find(Cuenta.class, cuentaPk);

        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return cuentaTemporal;
    }

    void update(DomicilioCuenta entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
