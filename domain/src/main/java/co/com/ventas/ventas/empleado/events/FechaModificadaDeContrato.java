package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.ContratoId;
import generics.Fecha;

public class FechaModificadaDeContrato extends DomainEvent {
    private final ContratoId contratoId;
    private final Fecha fecha;

    public FechaModificadaDeContrato(ContratoId contratoId, Fecha fecha) {
        super("co.com.ventas.ventas.FechaModificadaAContrato");
        this.contratoId = contratoId;
        this.fecha = fecha;
    }

    public ContratoId getContratoId() {
        return contratoId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
