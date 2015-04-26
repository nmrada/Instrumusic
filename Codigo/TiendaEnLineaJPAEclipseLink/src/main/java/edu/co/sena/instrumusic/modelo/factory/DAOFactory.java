/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.factory;

import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.CuentaDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.DepartamentoDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.DomicilioCuentaDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ICarritoDeComprasDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ICategoriaDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IDomicilioProveedorDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IFacturaDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IInventarioDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IItemCarritoDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IItemDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IPagoDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IPedidoDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IProductoDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IProveedorDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ITipoDocumentoDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.MunicipioDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.UsuarioDAO;

/**
 *
 * @author Nicolas
 */
public interface DAOFactory {

    public ICarritoDeComprasDAO createCarritoDeComprasDAO();

    public ICategoriaDAO createCategoriaDAO();
    
    public CuentaDAO createCuentaDAO();
    
    public DepartamentoDAO createDepartamentoDAO();
    
    public DomicilioCuentaDAO createDomicilioCuentaDAO();

    public IDomicilioProveedorDAO createDomicilioProveedorDAO();

    public IFacturaDAO createFacturaDAO();

    public IInventarioDAO createInventarioDAO();

    public IItemCarritoDAO createItemCarritoDAO();
    
    public IItemDAO createItemDAO();
    
    public MunicipioDAO createMunicipioDAO();
    
    public IPagoDAO createPagoDAO();
    
    public IPedidoDAO createPedidoDAO();
    
    public IProductoDAO createProductoDAO();
    
    public IProveedorDAO createProveedorDAO();

    public ITipoDocumentoDAO createTipoDocumentoDAO();
    
    public UsuarioDAO createUsuarioDAO();

}
