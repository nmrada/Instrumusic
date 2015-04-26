/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.Usuario;
import java.util.List;

/**
 *
 * @author admin
 */
public interface IUsuarioDAO {
    
     public void insert(Usuario entity);

    public void update(Usuario entity);

    public void delete(Usuario entity);

    public Usuario findByIdUsuario(String idUsuario);

    public List<Usuario> findByAll();
    public List<Usuario> findByContrasena(String contrasena);
    public List<Usuario> findByRol(String rol);
    public List<Usuario> findByEstado(String estado);
    public List<Usuario> findByEmail(String email);
}
