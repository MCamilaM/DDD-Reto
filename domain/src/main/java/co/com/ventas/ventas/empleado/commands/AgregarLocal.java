package co.com.ventas.ventas.empleado.commands;

import co.com.sofka.domain.generic.Command;
import generics.Direccion;
import co.com.ventas.ventas.empleado.values.EmpleadoId;

/**
 * comando Agregar Local
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class AgregarLocal extends Command {

    private final EmpleadoId empleadoId;
    private final Direccion direccion;

    /**
     * Constructor
     * @param empleadoId
     * @param direccion
     */
    public AgregarLocal(EmpleadoId empleadoId, Direccion direccion) {
        this.empleadoId = empleadoId;
        this.direccion = direccion;
    }

    /**
     * Getters
     */
    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
