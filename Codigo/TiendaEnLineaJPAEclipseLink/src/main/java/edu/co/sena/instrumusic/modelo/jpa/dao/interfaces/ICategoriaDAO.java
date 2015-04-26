/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.Categoria;
import java.util.List;

/**
 *
 * @author BERNATE
 */
public interface ICategoriaDAO {

    public void insert(Categoria entity);

    public void update(Categoria entity);

    public void delete(Categoria entity);
    
    public Categoria findByIdCategoria(Integer idCategoria);
    
    public List<Categoria> findAll();
    
    public List<Categoria> findByNombreCategoria(String nombreCategoria);
    
    public List<Categoria> findByActiva (Boolean activa);
    
     
    
    
    

}
