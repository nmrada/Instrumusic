package edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities;

import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.ItemCarrito;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-08T15:24:12")
@StaticMetamodel(Carritodecompras.class)
public class Carritodecompras_ { 

    public static volatile CollectionAttribute<Carritodecompras, ItemCarrito> itemCarritoCollection;
    public static volatile SingularAttribute<Carritodecompras, Float> precioTotal;
    public static volatile SingularAttribute<Carritodecompras, Float> impuestos;
    public static volatile SingularAttribute<Carritodecompras, Float> subtotal;
    public static volatile SingularAttribute<Carritodecompras, String> idCarritoDeCompras;

}