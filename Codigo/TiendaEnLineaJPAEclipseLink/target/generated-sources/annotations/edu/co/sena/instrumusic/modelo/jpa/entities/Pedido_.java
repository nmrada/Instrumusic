package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.Factura;
import edu.co.sena.instrumusic.modelo.jpa.entities.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-24T22:27:06")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Float> total;
    public static volatile SingularAttribute<Pedido, Factura> factura;
    public static volatile SingularAttribute<Pedido, Float> subtotal;
    public static volatile SingularAttribute<Pedido, Float> impuestos;
    public static volatile SingularAttribute<Pedido, Integer> facturaidFactura;
    public static volatile ListAttribute<Pedido, Item> itemList;

}