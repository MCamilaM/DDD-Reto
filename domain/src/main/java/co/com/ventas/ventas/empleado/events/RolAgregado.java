package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import generics.Nombre;
import co.com.ventas.ventas.empleado.values.RolId;

public class RolAgregado extends DomainEvent {
    private final RolId rolId;
    private final Nombre nombre;

    public RolAgregado(RolId rolId, Nombre nombre) {
        super("co.com.ventas.ventas.RolCreado");
        this.rolId = rolId;
        this.nombre = nombre;
    }

    public RolId getRolId() {
        return rolId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}


