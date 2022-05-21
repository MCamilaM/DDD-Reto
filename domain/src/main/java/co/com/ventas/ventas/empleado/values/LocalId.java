package co.com.ventas.ventas.empleado.values;

import co.com.sofka.domain.generic.Identity;

/**
 * id de local
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class LocalId extends Identity {
    public LocalId(String id){
        super(id);
    }
    public static LocalId of(String id) {
        return new LocalId(id);
    }
}
