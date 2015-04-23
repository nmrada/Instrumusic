package edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities;

import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.DomicilioProveedor;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Inventario;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.ProveedorPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-08T15:24:13")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> nombre;
    public static volatile CollectionAttribute<Proveedor, Inventario> inventarioCollection;
    public static volatile SingularAttribute<Proveedor, String> email;
    public static volatile SingularAttribute<Proveedor, DomicilioProveedor> domicilioProveedor;
    public static volatile SingularAttribute<Proveedor, ProveedorPK> proveedorPK;

}