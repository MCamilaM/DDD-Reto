package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.Direccion;
import co.com.ventas.ventas.empleado.values.LocalId;

public class LocalAgregado extends DomainEvent {
    private final LocalId localId;
    private final Direccion direccion;

    public LocalAgregado(LocalId localId, Direccion direccion) {
        super("co.com.ventas.ventas.LocalCreado");
        this.localId = localId;
        this.direccion = direccion;
    }

    public LocalId getLocalId() {
        return localId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
