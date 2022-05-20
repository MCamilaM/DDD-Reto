package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.ClienteId;
import co.com.ventas.ventas.venta.values.CorreoElectronico;

public class CorreoElectronicoDeClienteActualizado extends DomainEvent {
    private final ClienteId clienteId;
    private final CorreoElectronico correoElectronico;

    public CorreoElectronicoDeClienteActualizado(ClienteId clienteId, CorreoElectronico correoElectronico) {
        super("co.com.ventas.ventas.CorreoElectronicoDeClienteActualizado");
        this.clienteId = clienteId;
        this.correoElectronico = correoElectronico;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public CorreoElectronico getCorreoElectronico() {
        return correoElectronico;
    }
}
