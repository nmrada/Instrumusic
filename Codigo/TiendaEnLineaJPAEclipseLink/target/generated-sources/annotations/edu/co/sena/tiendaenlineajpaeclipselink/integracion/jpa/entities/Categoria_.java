package edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities;

import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-08T15:24:12")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, Integer> idCategoria;
    public static volatile SingularAttribute<Categoria, String> nombreCategoria;
    public static volatile SingularAttribute<Categoria, Boolean> activa;
    public static volatile SingularAttribute<Categoria, Integer> pariente;
    public static volatile CollectionAttribute<Categoria, Producto> productoCollection;

}