package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.ClienteId;
import co.com.ventas.ventas.venta.values.CorreoElectronico;
/**
 * evento Correo Electronico De Cliente Actualizado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class CorreoElectronicoDeClienteActualizado extends DomainEvent {
    private final ClienteId clienteId;
    private final CorreoElectronico correoElectronico;

    /**
     * Constructor
     * @param clienteId
     * @param correoElectronico
     */
    public CorreoElectronicoDeClienteActualizado(ClienteId clienteId, CorreoElectronico correoElectronico) {
        super("co.com.ventas.ventas.CorreoElectronicoDeClienteActualizado");
        this.clienteId = clienteId;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Getters
     */
    public ClienteId getClienteId() {
        return clienteId;
    }

    public CorreoElectronico getCorreoElectronico() {
        return correoElectronico;
    }
}
