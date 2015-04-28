/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.implementacion;

import static edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.DepartamentoDAOImpl.logger;
import edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IUsuarioDAO;
import edu.co.sena.instrumusic.modelo.jpa.entities.Municipio;
import edu.co.sena.instrumusic.modelo.jpa.entities.Usuario;
import static edu.co.sena.instrumusic.modelo.jpa.util.EntityManagerHelper.getEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author admin
 */
public class UsuarioDAOImpl extends AbstractDAO implements IUsuarioDAO {

    protected static final Logger logger = Logger.getLogger(UsuarioDAOImpl.class);
    public static final String CONTRASENA = "contrasena";
    public static final String ROL = "rol";
    public static final String ESTADO = "estado";
    public static final String EMAIL = "email";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @Override
    public void insert(Usuario entity) {
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.persist(entity);
            EntityManagerHelper.commit();
            logger.info("Se inserto el usuario" + entity.getIdUsuario());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        }finally {
              EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void update(Usuario entity) {
        try {
            EntityManager em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();
            em.merge(entity);
            EntityManagerHelper.commit();
            logger.info("Se actualizo el usuario " + entity.getIdUsuario());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        }finally {
              EntityManagerHelper.closeEntityManager();
        }
    }

    @Override
    public void delete(Usuario entity) {
       EntityManager em = getEntityManager();
        try {
            EntityManagerHelper.beginTransaction();
            entity = getEntityManager().getReference(Usuario.class, entity.getIdUsuario());
            em.remove(entity);
            EntityManagerHelper.commit();
            logger.info("Se elimino el usuario" + entity.getIdUsuario());
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
             EntityManagerHelper.closeEntityManager();
            
        }
    }

    @Override
    public Usuario findByIdUsuario(String idUsuario) {
        EntityManager em = getEntityManager();
        Usuario usuarioTemporal = null;
        try {
            usuarioTemporal = em.find(Usuario.class, idUsuario);
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
              EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;

    }

    @Override
    public List<Usuario> findByAll() {
        EntityManager em = getEntityManager();
        List<Usuario> usuarioTemporal = null;
        Query query = em.createNamedQuery("Usuario.findAll");
        try {
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByContrasena(String contrasena) {
        EntityManager em = getEntityManager();
        List<Usuario> usuarioTemporal = null;

        try {
            Query query = em.createNamedQuery("Usuario.findByContrasena");
            query.setParameter(UsuarioDAOImpl.CONTRASENA, contrasena);
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByRol(String rol) {
        EntityManager em = getEntityManager();
        List<Usuario> usuarioTemporal = null;

        try {
            Query query = em.createNamedQuery("Usuario.findByRol");
            query.setParameter(UsuarioDAOImpl.ROL, rol);
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByEstado(String estado) {
        EntityManager em = getEntityManager();
        List<Usuario> usuarioTemporal = null;

        try {
            Query query = em.createNamedQuery("Usuario.findByEstado");
            query.setParameter(UsuarioDAOImpl.ESTADO, estado);
            usuarioTemporal = query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }

    @Override
    public List<Usuario> findByEmail(String email) {
        EntityManager em = getEntityManager();
        List<Usuario> usuarioTemporal = null;
        try {
            Query query = em.createNamedQuery("Usuario.findByEmail");
            query.setParameter(UsuarioDAOImpl.EMAIL, email);
            usuarioTemporal = query.getResultList();
            
        } catch (RuntimeException re) {
            logger.error("Exception: " + re.getMessage(), re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return usuarioTemporal;
    }
}
