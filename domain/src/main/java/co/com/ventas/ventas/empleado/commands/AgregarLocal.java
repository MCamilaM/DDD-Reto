package co.com.ventas.ventas.empleado.commands;

import co.com.sofka.domain.generic.Command;
import generics.Direccion;
import co.com.ventas.ventas.empleado.values.EmpleadoId;

public class AgregarLocal extends Command {

    private final EmpleadoId empleadoId;
    private final Direccion direccion;

    public AgregarLocal(EmpleadoId empleadoId, Direccion direccion) {
        this.empleadoId = empleadoId;
        this.direccion = direccion;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
