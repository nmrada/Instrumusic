package edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities;

import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.InventarioPK;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Producto;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Proveedor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-08T15:24:12")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, InventarioPK> inventarioPK;
    public static volatile SingularAttribute<Inventario, Date> fecha;
    public static volatile SingularAttribute<Inventario, Integer> cantidad;
    public static volatile SingularAttribute<Inventario, Producto> producto;
    public static volatile SingularAttribute<Inventario, Proveedor> proveedor;

}