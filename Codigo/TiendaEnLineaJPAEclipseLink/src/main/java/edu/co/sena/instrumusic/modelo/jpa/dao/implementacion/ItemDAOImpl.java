/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IItemDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Item;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author My PC
 */
public class ItemDAOImpl implements IItemDAO{
    
    public static final String IDPRODUCTO = "productoidProducto";
    public static final String IDFACTURA = "pedidoFacturaidFactura";
    public static final String CANTIDAD = "cantidad";
    public static final String COSTOUNITARIO = "costoUnitario";
    public static final String COSTOTOTAL = "costoTotal";
    
    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Item entity) {
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
    public void update(Item entity) {
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
    public void delete(Item entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Item.class, entity.getItemPK());
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
    public Item findByIdItem(Integer idFactura) {
        
        EntityManager em = getEntityManager();
        Item itemT = null;
        try {
            itemT = em.find(Item.class, idFactura);
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemT;
        
    }

    @Override
    public List<Item> findByAll() {
        
        EntityManager em = getEntityManager();
        List<Item> itemT = null;
        Query query = em.createNamedQuery("Item.findAll");
        try {
            itemT = query.getResultList();
        } catch (RuntimeException er) {
            System.err.println("error: ---" + er.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return itemT;
        
    }

    @Override
    public List<Item> findByProductoidProducto(Integer idProducto) {
        EntityManager em = getEntityManager();
        List<Item> temT = null;
        try {
            Query query = em.createNamedQuery("Item.findByProductoidProducto");
            query.setParameter(ItemDAOImpl.IDPRODUCTO, idProducto);
            temT = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return temT;
    }

    @Override
    public List<Item> findByPedidoFacturaidFactura(Integer idFactura) {
        
        EntityManager em = getEntityManager();
        List<Item> temT = null;
        try {
            Query query = em.createNamedQuery("Item.findByProductoidProducto");
            query.setParameter(ItemDAOImpl.IDFACTURA, idFactura);
            temT = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return temT;
    }

    @Override
    public List<Item> findByCantidad(Integer cantidad) {
         
        EntityManager em = getEntityManager();
        List<Item> temT = null;
        try {
            Query query = em.createNamedQuery("Item.findByCantidad");
            query.setParameter(ItemDAOImpl.CANTIDAD, cantidad);
            temT = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return temT;
        
    }
    
    @Override
    public List<Item> findByCostoUnitario(Integer costoUnitario) {
         
        EntityManager em = getEntityManager();
        List<Item> temT = null;
        try {
            Query query = em.createNamedQuery("Item.costoUnitario");
            query.setParameter(ItemDAOImpl.COSTOUNITARIO, costoUnitario);
            temT = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return temT;
        
    }

    @Override
    public List<Item> findByCostoTotal(Integer costoTotal) {
         
        EntityManager em = getEntityManager();
        List<Item> temT = null;
        try {
            Query query = em.createNamedQuery("Item.costoUnitario");
            query.setParameter(ItemDAOImpl.COSTOTOTAL, costoTotal);
            temT = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:----------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return temT;
        
    }
    
}
