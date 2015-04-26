/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IFacturaDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Factura;
import edu.co.sena.instrumusic.modelo.jpa.entities.Item;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author My PC
 */
public class FacturaDAOImpl implements IFacturaDAO{
    
    public static final String FECHA = "fecha";
    public static final String TOTAL = "total";
    
    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Factura entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
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
    public void update(Factura entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
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
    public void delete(Factura entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Factura.class, entity.getIdFactura());
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
    public Factura findByIdFactura(int idFactura) {

        EntityManager em = getEntityManager();
        Factura facturaT = null;
        try {
            facturaT = em.find(Factura.class, idFactura);
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return facturaT;
        
    }

    @Override
    public List<Factura> findByAll() {
        
        EntityManager em = getEntityManager();
        List<Factura> facturaT = null;
        Query query = em.createNamedQuery("Factura.findAll");
        try {
            facturaT = query.getResultList();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return facturaT;
        
    }

    @Override
    public List<Factura> findByFecha(Date fecha) {

        EntityManager em = getEntityManager();
        List<Factura> facturaT = null;
        try {
            Query query = em.createNamedQuery("Factura.findByFecha");
            query.setParameter(FacturaDAOImpl.FECHA, fecha);
            facturaT = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return facturaT;
    }

    @Override
    public List<Factura> findByTotal(double total) {
        
        EntityManager em = getEntityManager();
        List<Factura> facturaT = null;
        try {
            Query query = em.createNamedQuery("Factura.findByTotal");
            query.setParameter(FacturaDAOImpl.TOTAL, total);
            facturaT = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return facturaT;
    }
    
    
    
}
