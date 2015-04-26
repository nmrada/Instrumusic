/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IPedidoDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Pedido;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author My PC
 */
public class PedidoDAOImpl implements IPedidoDAO{
    
    public static final String FACTURA = "facturaidFactura";
    public static final String TOTAL = "total";
    public static final String SUBTOTAL = "subtotal";
    public static final String IMPUESTOS = "impuestos";
    
    
    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Pedido entity) {
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
    public void update(Pedido entity) {
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
    public void delete(Pedido entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Pedido.class, entity.getFacturaidFactura());
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
    public Pedido findByIdPedido(int idFactura) {
        EntityManager em = getEntityManager();
        Pedido pedidoT=  null;
        try {
            pedidoT = em.find(Pedido.class, idFactura);
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pedidoT;
    }

    @Override
    public List<Pedido> findByAll() {
        
        EntityManager em = getEntityManager();
        List<Pedido> pedidoT = null;
        Query query = em.createNamedQuery("Pedido.findAll");
        try {
            pedidoT = query.getResultList();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pedidoT;
    }

    @Override
    public List<Pedido> findByFacturaidFactura(int idFactura) {
        
        EntityManager em = getEntityManager();
        List<Pedido> pedidoT=  null;
        try {
            Query query = em.createNamedQuery("Pedido.findByFacturaidFactura");
            query.setParameter(PedidoDAOImpl.FACTURA, idFactura);
            pedidoT = query.getResultList();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pedidoT;
        
    }

    @Override
    public List<Pedido> findByTotal(float total) {
        
        EntityManager em = getEntityManager();
        List<Pedido> pedidoT=  null;
        try {
            Query query = em.createNamedQuery("Pedido.findByTotal");
            query.setParameter(PedidoDAOImpl.TOTAL, total);
            pedidoT = query.getResultList();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pedidoT;
        
    }

    @Override
    public List<Pedido> findBySubtotal(float subtotal) {
        
        EntityManager em = getEntityManager();
        List<Pedido> pedidoT=  null;
        try {
            Query query = em.createNamedQuery("Pedido.findBySubtotal");
            query.setParameter(PedidoDAOImpl.SUBTOTAL, subtotal);
            pedidoT = query.getResultList();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pedidoT;
        
    }

    @Override
    public List<Pedido> findByImpuestos(float impuestos) {
        
        EntityManager em = getEntityManager();
        List<Pedido> pedidoT=  null;
        try {
            Query query = em.createNamedQuery("Pedido.findByImpuestos");
            query.setParameter(PedidoDAOImpl.IMPUESTOS, impuestos);
            pedidoT = query.getResultList();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pedidoT;
        
    }
    
}
