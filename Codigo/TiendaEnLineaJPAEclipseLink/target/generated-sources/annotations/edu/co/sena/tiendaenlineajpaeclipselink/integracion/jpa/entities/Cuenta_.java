package edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities;

import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.CuentaPK;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.DomicilioCuenta;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Factura;
import edu.co.sena.tiendaenlineajpaeclipselink.integracion.jpa.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-08T15:24:12")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, DomicilioCuenta> domicilioCuenta;
    public static volatile SingularAttribute<Cuenta, Usuario> usuarioidUsuario;
    public static volatile SingularAttribute<Cuenta, String> primerApellido;
    public static volatile SingularAttribute<Cuenta, CuentaPK> cuentaPK;
    public static volatile CollectionAttribute<Cuenta, Factura> facturaCollection;
    public static volatile SingularAttribute<Cuenta, String> segundoNombre;
    public static volatile SingularAttribute<Cuenta, String> primerNombre;
    public static volatile SingularAttribute<Cuenta, String> segundoApellido;

}