/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IProductoDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Producto;
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
public class ProductoDAOImpl extends AbstractDAO implements IProductoDAO {

    protected static final Logger logger = Logger.getLogger(ProductoDAOImpl.class);
    public static final String NOMBRE = "nombre";
    public static final String MARCA = "marca";
    public static final String REFERENCIA = "referencia";
    public static final String DESCRIPCION = "descripcion";
    public static final String MATERIAL = "material";
    public static final String COLOR = "color";
    public static final String CANTIDAD = "cantidad";
    public static final String ACTIVO = "activo";
    public static final String PRECIOUNITARIO = "precioUnitario";
    public static final String DESCUENTO = "descuento";

    @Override
    public void insert(Producto entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto el producto " + entity.getIdProducto());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void update(Producto entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el Producto " + entity.getIdProducto());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public void delete(Producto entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Producto.class, entity.getIdProducto());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se elimino el producto " + entity.getIdProducto());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    @Override
    public Producto findByIdProducto(String idproducto) {
        EntityManager em = getEntityManager();
        Producto productoTemporal = null;
        try {
            productoTemporal = em.find(Producto.class, idproducto);
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
        return productoTemporal;
    }

    @Override
    public List<Producto> findAll() {
        EntityManager em = getEntityManager();
        List<Producto> productoTemporal = null;
        Query query = em.createNamedQuery("Producto.findAll");
        try {
            productoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productoTemporal;
    }

    @Override
    public List<Producto> findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        List<Producto> productoTemporal = null;

        try {
            Query query = em.createNamedQuery("Producto.findByNombre");
            query.setParameter(ProductoDAOImpl.NOMBRE, nombre);
            productoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productoTemporal;
    }

    @Override
    public List<Producto> findByMarca(String marca) {
        EntityManager em = getEntityManager();
        List<Producto> productoTemporal = null;

        try {
            Query query = em.createNamedQuery("Producto.findByMarca");
            query.setParameter(ProductoDAOImpl.MARCA, marca);
            productoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productoTemporal;
    }

    @Override
    public List<Producto> findByReferencia(String referencia) {
        EntityManager em = getEntityManager();
        List<Producto> productoTemporal = null;

        try {
            Query query = em.createNamedQuery("Producto.findByReferencia");
            query.setParameter(ProductoDAOImpl.REFERENCIA, referencia);
            productoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productoTemporal;
    }

    @Override
    public List<Producto> findByDescripcion(String descripcion) {
        EntityManager em = getEntityManager();
        List<Producto> productoTemporal = null;

        try {
            Query query = em.createNamedQuery("Producto.findByDescripcion");
            query.setParameter(ProductoDAOImpl.DESCRIPCION, descripcion);
            productoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productoTemporal;
    }

    @Override
    public List<Producto> findByMaterial(String material) {
        EntityManager em = getEntityManager();
        List<Producto> productoTemporal = null;

        try {
            Query query = em.createNamedQuery("Producto.findByMaterial");
            query.setParameter(ProductoDAOImpl.MATERIAL, material);
            productoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productoTemporal;
    }

    @Override
    public List<Producto> findByColor(String color) {
        EntityManager em = getEntityManager();
        List<Producto> productoTemporal = null;

        try {
            Query query = em.createNamedQuery("Producto.findByColor");
            query.setParameter(ProductoDAOImpl.COLOR, color);
            productoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productoTemporal;
    }

    @Override
    public List<Producto> findByCantidad(int cantidad) {
        EntityManager em = getEntityManager();
        List<Producto> productoTemporal = null;

        try {
            Query query = em.createNamedQuery("Producto.findByCantidad");
            query.setParameter(ProductoDAOImpl.CANTIDAD, cantidad);
            productoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productoTemporal;
    }

    @Override
    public List<Producto> findByActivo(boolean activo) {
        EntityManager em = getEntityManager();
        List<Producto> productoTemporal = null;

        try {
            Query query = em.createNamedQuery("Producto.findByActivo");
            query.setParameter(ProductoDAOImpl.ACTIVO, activo);
            productoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productoTemporal;

    }

    @Override
    public List<Producto> findByPrecioUnitario(float precioUnitario) {
        EntityManager em = getEntityManager();
        List<Producto> productoTemporal = null;

        try {
            Query query = em.createNamedQuery("Producto.findByPrecioUnitario");
            query.setParameter(ProductoDAOImpl.PRECIOUNITARIO, precioUnitario);
            productoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productoTemporal;
    }

    @Override
    public List<Producto> findByDescuento(float descuento) {
        EntityManager em = getEntityManager();
        List<Producto> productoTemporal = null;

        try {
            Query query = em.createNamedQuery("Producto.findByDescuento");
            query.setParameter(ProductoDAOImpl.DESCUENTO, descuento);
            productoTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return productoTemporal;
    }

}
