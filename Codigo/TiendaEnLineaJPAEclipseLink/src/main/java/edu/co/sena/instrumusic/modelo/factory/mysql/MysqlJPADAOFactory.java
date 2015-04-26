/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.instrumusic.modelo.factory.mysql;

import edu.co.sena.instrumusic.modelo.factory.DAOAbstractFactory;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.CarritoDeComprasDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.CategoriaDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.CuentaDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.DepartamentoDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.DomicilioCuentaDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.DomicilioProveedorDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.FacturaDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.InventarioDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.ItemCarritoDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.ItemDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.MunicipioDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.PagoDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.PedidoDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.ProductoDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.ProveedorDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.TipoDocumentoDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.implementacion.UsuarioDAOImpl;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.ICuentaDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IDepartamentoDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IDomicilioCuentaDAO;
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
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IMunicipioDAO;
import edu.co.sena.instrumusic.modelo.jpa.dao.interfaces.IUsuarioDAO;

/**
 *
 * @author Nicolas
 */
public class MysqlJPADAOFactory extends DAOAbstractFactory {

    @Override
    public ICarritoDeComprasDAO createCarritoDeComprasDAO() {
        return new CarritoDeComprasDAOImpl();
    }
    
    @Override
    public ICategoriaDAO createCategoriaDAO() {
        return new CategoriaDAOImpl();
    }
    
    @Override
    public ICuentaDAO createCuentaDAO() {
        return new CuentaDAOImpl();
    }

    @Override
    public IDepartamentoDAO createDepartamentoDAO() {
        return new DepartamentoDAOImpl();
    }

    @Override
    public IDomicilioCuentaDAO createDomicilioCuentaDAO() {
        return new DomicilioCuentaDAOImpl();
    }
    
    @Override
    public IDomicilioProveedorDAO createDomicilioProveedorDAO() {
        return new DomicilioProveedorDAOImpl();
    }

    @Override
    public IFacturaDAO createFacturaDAO() {
        return new FacturaDAOImpl();
    }

    @Override
    public IInventarioDAO createInventarioDAO() {
        return new InventarioDAOImpl();
    }
    
    @Override
    public IItemCarritoDAO createItemCarritoDAO() {
        return new ItemCarritoDAOImpl();
    }

    @Override
    public IItemDAO createItemDAO() {
        return new ItemDAOImpl();
    }

    @Override
    public IMunicipioDAO createMunicipioDAO() {
        return new MunicipioDAOImpl();
    }

    @Override
    public IPagoDAO createPagoDAO() {
        return new PagoDAOImpl();
    }

    @Override
    public IPedidoDAO createPedidoDAO() {
        return new PedidoDAOImpl();
    }

    @Override
    public IProductoDAO createProductoDAO() {
        return new ProductoDAOImpl();
    }

    @Override
    public IProveedorDAO createProveedorDAO() {
        return new ProveedorDAOImpl();
    }
    
    @Override
    public ITipoDocumentoDAO createTipoDocumentoDAO() {
        return new TipoDocumentoDAOImpl();
    }

    @Override
    public IUsuarioDAO createUsuarioDAO() {
        return new UsuarioDAOImpl();
    }

}
