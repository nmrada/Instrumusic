/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.TipoDocumento;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public interface TipoDocumentoDAO {
    public void insert(TipoDocumento entity);

    public void update(TipoDocumento entity);

    public void delete(TipoDocumento entity);

    public TipoDocumento findByTipoDocumento(String tipoDocumento);

    public List<TipoDocumento> findByAll();
    public List<TipoDocumento> findByDescripcion(String descripcion);
    public List<TipoDocumento> findByActivo(boolean activo);
}
