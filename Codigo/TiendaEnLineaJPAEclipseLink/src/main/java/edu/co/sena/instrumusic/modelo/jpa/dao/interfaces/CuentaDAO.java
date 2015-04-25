/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.jpa.dao.interfaces;

import edu.co.sena.instrumusic.modelo.jpa.entities.Cuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.CuentaPK;
import java.util.List;

/**
 *
 * @author admin
 */
public interface CuentaDAO {
    
    public void insert(Cuenta entity);

    public void update(Cuenta entity);

    public void delete(Cuenta entity);
    
     public Cuenta findByIdCuenta(CuentaPK cuentaPk);
    
    public List<Cuenta> findByAll();
    public List<Cuenta> findByPrimerNombre(String primerNombre);
    public List<Cuenta> findBySegundoNombre(String segundoNombre);
    public List<Cuenta> findByPrimerApellido(String primerApellido);
    public List<Cuenta> findBySegundoApellido(String segundoApellido);;
}
