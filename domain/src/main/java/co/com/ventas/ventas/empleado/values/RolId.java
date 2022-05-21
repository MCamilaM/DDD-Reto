package co.com.ventas.ventas.empleado.values;

import co.com.sofka.domain.generic.Identity;

/**
 * id de rol
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class RolId extends Identity {

    public RolId(String id){
        super(id);
    }
    public static RolId of(String id) {
        return new RolId(id);
    }

}
