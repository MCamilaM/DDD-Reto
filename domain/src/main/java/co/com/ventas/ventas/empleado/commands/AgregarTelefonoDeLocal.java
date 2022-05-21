package co.com.ventas.ventas.empleado.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.empleado.values.LocalId;
import generics.Telefono;

/**
 * comando  Agregar Telefono De Local
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class AgregarTelefonoDeLocal extends Command {
    private final EmpleadoId empleadoId;
    private final LocalId localId;
    private final Telefono telefono;

    /**
     * Constructor
     * @param empleadoId
     * @param localId
     * @param telefono
     */
    public AgregarTelefonoDeLocal(EmpleadoId empleadoId, LocalId localId, Telefono telefono) {
        this.empleadoId = empleadoId;
        this.localId = localId;
        this.telefono = telefono;
    }

    /**
     * Getters
     */
    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public LocalId getLocalId() {
        return localId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
