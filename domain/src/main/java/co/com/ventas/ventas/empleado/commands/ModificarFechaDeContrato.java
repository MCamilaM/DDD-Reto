package co.com.ventas.ventas.empleado.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.empleado.values.ContratoId;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import generics.Fecha;
/**
 * comando  Modificar Fecha De Contrato
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class ModificarFechaDeContrato extends Command {
    private final EmpleadoId empleadoId;
    private final ContratoId contratoId;
    private final Fecha fecha;

    /**
     * Constructor
     * @param empleadoId
     * @param contratoId
     * @param fecha
     */
    public ModificarFechaDeContrato(EmpleadoId empleadoId, ContratoId contratoId, Fecha fecha) {
        this.empleadoId = empleadoId;
        this.contratoId = contratoId;
        this.fecha = fecha;
    }

    /**
     * Getters
     */
    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public ContratoId getContratoId() {
        return contratoId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
