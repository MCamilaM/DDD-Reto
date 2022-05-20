package co.com.ventas.ventas.empleado.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.empleado.values.Descripcion;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.empleado.values.RolId;

public class AgregarDescripcionDeRol extends Command {

    private final EmpleadoId empleadoId;
    private final RolId rolId;
    private final Descripcion descripcion;

    public AgregarDescripcionDeRol(EmpleadoId empleadoId, RolId rolId, Descripcion descripcion) {
        this.empleadoId = empleadoId;
        this.rolId = rolId;
        this.descripcion = descripcion;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public RolId getRolId() {
        return rolId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
