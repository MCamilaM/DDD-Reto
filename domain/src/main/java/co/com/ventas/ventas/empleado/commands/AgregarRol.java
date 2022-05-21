package co.com.ventas.ventas.empleado.commands;

import co.com.sofka.domain.generic.Command;
import generics.Nombre;
import co.com.ventas.ventas.empleado.values.EmpleadoId;

/**
 * comando Agregar Rol
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class AgregarRol extends Command {
    private final EmpleadoId empleadoId;
    private final Nombre nombre;

    /**
     * Constructor
     * @param empleadoId
     * @param nombre
     */
    public AgregarRol(EmpleadoId empleadoId, Nombre nombre) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
    }

    /**
     * Getters
     */
    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
