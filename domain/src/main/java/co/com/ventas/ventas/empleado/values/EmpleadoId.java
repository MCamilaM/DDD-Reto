package co.com.ventas.ventas.empleado.values;

import co.com.sofka.domain.generic.Identity;

/**
 * id de descripcion
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class EmpleadoId extends Identity {
    public EmpleadoId(String id){
        super(id);
    }
    public static EmpleadoId of(String id) {
        return new EmpleadoId(id);
    }
}
