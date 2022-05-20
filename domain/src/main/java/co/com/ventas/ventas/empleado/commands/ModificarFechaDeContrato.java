package co.com.ventas.ventas.empleado.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.empleado.values.ContratoId;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.empleado.values.Fecha;

public class ModificarFechaDeContrato extends Command {
    private final EmpleadoId empleadoId;
    private final ContratoId contratoId;
    private final Fecha fecha;

    public ModificarFechaDeContrato(EmpleadoId empleadoId, ContratoId contratoId, Fecha fecha) {
        this.empleadoId = empleadoId;
        this.contratoId = contratoId;
        this.fecha = fecha;
    }

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
