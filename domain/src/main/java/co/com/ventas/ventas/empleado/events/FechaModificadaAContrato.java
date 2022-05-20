package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.Fecha;
import co.com.ventas.ventas.empleado.values.LocalId;

public class FechaModificadaAContrato extends DomainEvent {
    private final LocalId localId;
    private final Fecha fecha;

    public FechaModificadaAContrato(LocalId localId, Fecha fecha) {
        super("co.com.ventas.ventas.FechaModificadaAContrato");
        this.localId = localId;
        this.fecha = fecha;
    }

    public LocalId getLocalId() {
        return localId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
