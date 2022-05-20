package co.com.ventas.ventas.empleado.values;

import co.com.sofka.domain.generic.Identity;

public class EmpleadoId extends Identity {
    public EmpleadoId(String id){
        super(id);
    }
    public static EmpleadoId of(String id) {
        return new EmpleadoId(id);
    }
}
