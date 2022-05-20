package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.LocalId;
import co.com.ventas.ventas.empleado.values.Telefono;

public class TelefonoAgregadoALocal extends DomainEvent {
    private final LocalId localId;
    private final Telefono telefono;

    public TelefonoAgregadoALocal(LocalId localId, Telefono telefono) {
        super("co.com.ventas.ventas.TelefonoAgregadoALocal");
        this.localId = localId;
        this.telefono = telefono;
    }

    public LocalId getLocalId() {
        return localId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
