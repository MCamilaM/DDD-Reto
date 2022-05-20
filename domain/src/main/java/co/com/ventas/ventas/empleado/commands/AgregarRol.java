package co.com.ventas.ventas.empleado.commands;

import co.com.sofka.domain.generic.Command;
import generics.Nombre;
import co.com.ventas.ventas.empleado.values.EmpleadoId;

public class AgregarRol extends Command {
    private final EmpleadoId empleadoId;
    private final Nombre nombre;

    public AgregarRol(EmpleadoId empleadoId, Nombre nombre) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
