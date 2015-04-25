package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.ItemCarrito;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-24T22:27:06")
@StaticMetamodel(CarritoDeCompras.class)
public class CarritoDeCompras_ { 

    public static volatile ListAttribute<CarritoDeCompras, ItemCarrito> itemCarritoList;
    public static volatile SingularAttribute<CarritoDeCompras, Float> subtotal;
    public static volatile SingularAttribute<CarritoDeCompras, Float> impuestos;
    public static volatile SingularAttribute<CarritoDeCompras, Float> precioTotal;
    public static volatile SingularAttribute<CarritoDeCompras, String> idCarritoDeCompras;

}