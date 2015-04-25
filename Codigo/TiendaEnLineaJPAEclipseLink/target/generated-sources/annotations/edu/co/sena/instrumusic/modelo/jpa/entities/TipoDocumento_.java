package edu.co.sena.instrumusic.modelo.jpa.entities;

import edu.co.sena.instrumusic.modelo.jpa.entities.Cuenta;
import edu.co.sena.instrumusic.modelo.jpa.entities.Proveedor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-24T22:27:06")
@StaticMetamodel(TipoDocumento.class)
public class TipoDocumento_ { 

    public static volatile SingularAttribute<TipoDocumento, String> descripcion;
    public static volatile ListAttribute<TipoDocumento, Proveedor> proveedorList;
    public static volatile SingularAttribute<TipoDocumento, String> tipoDocumento;
    public static volatile ListAttribute<TipoDocumento, Cuenta> cuentaList;
    public static volatile SingularAttribute<TipoDocumento, Boolean> activo;

}