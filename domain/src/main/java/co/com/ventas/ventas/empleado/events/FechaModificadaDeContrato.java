package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.ContratoId;
import generics.Fecha;

/**
 * evento Fecha Modificada De Contrato
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class FechaModificadaDeContrato extends DomainEvent {
    private final ContratoId contratoId;
    private final Fecha fecha;

    /**
     * Constructor
     * @param contratoId
     * @param fecha
     */
    public FechaModificadaDeContrato(ContratoId contratoId, Fecha fecha) {
        super("co.com.ventas.ventas.FechaModificadaAContrato");
        this.contratoId = contratoId;
        this.fecha = fecha;
    }

    /**
     * Getters
     */
    public ContratoId getContratoId() {
        return contratoId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
