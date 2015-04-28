/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IPagoDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Pago;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author My PC
 */
public class PagoDAOImpl extends AbstractDAO implements IPagoDAO{
    
    protected static final Logger logger = Logger.getLogger(PagoDAOImpl.class);
    public static final String NUMTARCREDITO = "numTarCredito";
    public static final String BANCO = "banco";
    public static final String TIPOCUENTATAR = "tipoCuentaTar";
    public static final String TIPOTRANSACCION = "tipoTransaccion";
    public static final String FACTURA = "facturaidFactura";
    
    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Pago entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            logger.info("Se inserto el Pago "+ entity.getFacturaidFactura());
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(Pago entity) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            logger.info("Se actualizo el Pago "+ entity.getFacturaidFactura());
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        
    }

    @Override
    public void delete(Pago entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Pago.class, entity.getFacturaidFactura());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el Pago "+ entity.getFacturaidFactura());
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public Pago findByIdPago(int idFactura) {
        
        EntityManager em = getEntityManager();
        Pago pagoT = null;
        try {
            pagoT = em.find(Pago.class, idFactura);
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pagoT;
    }

    @Override
    public List<Pago> findByAll() {
        
        EntityManager em = getEntityManager();
        List<Pago> pagoT = null;
        Query query = em.createNamedQuery("Pago.findAll");
        try {
            pagoT = query.getResultList();
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pagoT;
    }

    @Override
    public List<Pago> findByFacturaidFactura(int idFactura) {
        
        EntityManager em = getEntityManager();
        List<Pago> pagoT = null;
        try {
            Query query = em.createNamedQuery("Pago.findByFacturaidFactura");
            query.setParameter(PagoDAOImpl.FACTURA, idFactura);
            pagoT = query.getResultList();
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pagoT;
        
    }

    @Override
    public List<Pago> findByNumTarCredito(String numTarjetaCredito) {
        
        EntityManager em = getEntityManager();
        List<Pago> pagoT = null;
        try {
            Query query = em.createNamedQuery("Pago.findByNumTarCredito");
            query.setParameter(PagoDAOImpl.NUMTARCREDITO, numTarjetaCredito);
            pagoT = query.getResultList();
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pagoT;
        
    }

    @Override
    public List<Pago> findByBanco(String banco) {
        
        EntityManager em = getEntityManager();
        List<Pago> pagoT = null;
        try {
            Query query = em.createNamedQuery("Pago.findByBanco");
            query.setParameter(PagoDAOImpl.BANCO, banco);
            pagoT = query.getResultList();
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pagoT;
        
    }

    @Override
    public List<Pago> findByTipoCuentaTar(String tipoCuetaTar) {
        
        EntityManager em = getEntityManager();
        List<Pago> pagoT = null;
        try {
            Query query = em.createNamedQuery("Pago.findByTipoCuentaTar");
            query.setParameter(PagoDAOImpl.TIPOCUENTATAR, tipoCuetaTar);
            pagoT = query.getResultList();
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pagoT;
        
    }

    @Override
    public List<Pago> findByTipoTransaccion(String tipoTransaccion) {
        
        EntityManager em = getEntityManager();
        List<Pago> pagoT = null;
        try {
            Query query = em.createNamedQuery("Pago.findByTipoTransaccion");
            query.setParameter(PagoDAOImpl.TIPOTRANSACCION, tipoTransaccion);
            pagoT = query.getResultList();
        } catch (RuntimeException er) {
            logger.error("Exception: " + er.getMessage(), er);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return pagoT;
        
    }
    
}
