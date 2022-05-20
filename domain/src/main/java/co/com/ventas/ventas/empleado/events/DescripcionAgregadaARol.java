package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.Descripcion;
import co.com.ventas.ventas.empleado.values.RolId;

public class DescripcionAgregadaARol extends DomainEvent {
    private final RolId rolId;
    private final Descripcion descripcion;

    public DescripcionAgregadaARol(RolId rolId, Descripcion descripcion) {
        super("co.com.ventas.ventas.DescripcionAgregadaARol");
        this.rolId = rolId;
        this.descripcion = descripcion;
    }

    public RolId getRolId() {
        return rolId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
