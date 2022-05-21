package co.com.ventas.ventas.empleado.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.empleado.Contrato;
import generics.Nombre;
import co.com.ventas.ventas.empleado.values.EmpleadoId;

/**
 * comando  Crear Empleado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class CrearEmpleado extends Command {
    private final EmpleadoId empleadoId;
    private final Nombre nombre;
    private final Contrato contrato;

    /**
     * Constructor
     * @param empleadoId
     * @param nombre
     * @param contrato
     */
    public CrearEmpleado(EmpleadoId empleadoId, Nombre nombre, Contrato contrato) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.contrato = contrato;
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

    public Contrato getContrato() {
        return contrato;
    }
}
