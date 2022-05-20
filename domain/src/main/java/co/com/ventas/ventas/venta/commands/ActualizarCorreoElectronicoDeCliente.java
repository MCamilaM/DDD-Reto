package co.com.ventas.ventas.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.venta.values.ClienteId;
import co.com.ventas.ventas.venta.values.CorreoElectronico;
import co.com.ventas.ventas.venta.values.VentaId;

public class ActualizarCorreoElectronicoDeCliente extends Command {
    private final VentaId ventaId;
    private final ClienteId clienteId;
    private final CorreoElectronico correoElectronico;

    public ActualizarCorreoElectronicoDeCliente(VentaId ventaId, ClienteId clienteId, CorreoElectronico correoElectronico) {
        this.ventaId = ventaId;
        this.clienteId = clienteId;
        this.correoElectronico = correoElectronico;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public CorreoElectronico getCorreoElectronico() {
        return correoElectronico;
    }
}
