package edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities;

import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Departamento;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.DomicilioCuenta;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.DomicilioProveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-08T15:24:13")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile SingularAttribute<Municipio, String> nombre;
    public static volatile SingularAttribute<Municipio, String> idMunicipio;
    public static volatile CollectionAttribute<Municipio, DomicilioProveedor> domicilioProveedorCollection;
    public static volatile SingularAttribute<Municipio, Departamento> departamentoidDepartamento;
    public static volatile CollectionAttribute<Municipio, DomicilioCuenta> domicilioCuentaCollection;

}