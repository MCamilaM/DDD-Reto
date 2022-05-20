package co.com.ventas.ventas.empleado.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.empleado.Contrato;
import co.com.ventas.ventas.empleado.Nombre;
import co.com.ventas.ventas.empleado.values.EmpleadoId;

public class CrearEmpleado extends Command {
    private final EmpleadoId empleadoId;
    private final Nombre nombre;
    private final Contrato contrato;

    public CrearEmpleado(EmpleadoId empleadoId, Nombre nombre, Contrato contrato) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.contrato = contrato;
    }

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
