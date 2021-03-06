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

/**
 *
 * @author BERNATE
 */
public class CategoriaDAOImpl implements ICategoriaDAO {

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }
    public static final String IDCATEGORIA = "idCategoria";
    public static final String NOMBRECATEGORIA = "nombreCategoria";
    public static final String ACTIVA = "activa";

    @Override
    public void insert(Categoria entity) {
        EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
        } catch (RuntimeException re) {
            System.out.println("erorr:------------" + re.getMessage());
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
        } catch (RuntimeException re) {
            System.out.println("error:--------------" + re.getMessage());
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

        } catch (RuntimeException re) {
            System.out.println("erorrr:-------------" + re.getMessage());
        } finally {
            if (em != null) {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

//    @Override
//    public Categoria findByIdCategoria(int idCategoria) {
//        EntityManager em = getEntityManager();
//        Categoria categoriaTemp = null;
//        try {
//            categoriaTemp = em.find(Categoria.class, idCategoria);
//        } catch (RuntimeException re) {
//            System.out.println("erorrr:-------------" + re.getMessage());
//        } finally {
//            if (em != null) {
//                EntityManagerHelper.closeEntityManager();
//            }
//        }
//        return categoriaTemp;
 //   }

    @Override
    public List<Categoria> findAll() {
        EntityManager em = getEntityManager();
        List<Categoria> categoriaTemp = null;
        Query query = em.createNamedQuery("Categoria.findAll");
        try {
            categoriaTemp = query.getResultList();
        } catch (RuntimeException re) {
            System.out.println("erorrr:---------" + re.getMessage());
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
            System.out.println("erorrr:-------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriaTemp;
    }

//    @Override
//    public List<Categoria> findByActiva(boolean activa) {
//        EntityManager em = getEntityManager();
//        List<Categoria> categoriaTemp = null;
//        try {
//            Query query = em.createNamedQuery("Categoria.findByActiva");
//            query.setParameter(CategoriaDAOImpl.ACTIVA, activa);
//            categoriaTemp = query.getResultList();
//        } catch (RuntimeException re) {
//            System.out.println("erorrr:-------------" + re.getMessage());
//        } finally {
//            EntityManagerHelper.closeEntityManager();
//        }
//        return categoriaTemp;
//
//    }
    @Override
    public Categoria findByIdCategoria(Integer idCategoria) {
        EntityManager em = getEntityManager();
        Categoria categoriaTemp = null;
        try {
            categoriaTemp = em.find(Categoria.class, idCategoria);
        } catch (RuntimeException re) {
            System.out.println("erorrr:-------------" + re.getMessage());
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
            System.out.println("erorrr:-------------" + re.getMessage());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return categoriaTemp;
    }

}
