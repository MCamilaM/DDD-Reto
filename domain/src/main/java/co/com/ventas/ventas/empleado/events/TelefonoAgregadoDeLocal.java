package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.LocalId;
import generics.Telefono;

/**
 * evento Telefono Agregado DeLocal
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class TelefonoAgregadoDeLocal extends DomainEvent {
    private final LocalId localId;
    private final Telefono telefono;

    /**
     * Constructo
     * @param localId
     * @param telefono
     */
    public TelefonoAgregadoDeLocal(LocalId localId, Telefono telefono) {
        super("co.com.ventas.ventas.TelefonoAgregadoALocal");
        this.localId = localId;
        this.telefono = telefono;
    }

    /**
     * Getters
     */
    public LocalId getLocalId() {
        return localId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
