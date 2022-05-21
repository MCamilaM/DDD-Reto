package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import generics.Direccion;
import co.com.ventas.ventas.empleado.values.LocalId;
/**
 * evento Local Agregado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class LocalAgregado extends DomainEvent {
    private final LocalId localId;
    private final Direccion direccion;

    /**
     * Constructor
     * @param localId
     * @param direccion
     */
    public LocalAgregado(LocalId localId, Direccion direccion) {
        super("co.com.ventas.ventas.LocalCreado");
        this.localId = localId;
        this.direccion = direccion;
    }

    /**
     * Getters
     */
    public LocalId getLocalId() {
        return localId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
