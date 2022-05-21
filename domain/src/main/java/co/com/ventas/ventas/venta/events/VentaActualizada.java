package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.VentaId;

public class VentaActualizada extends DomainEvent {

    private final VentaId ventaId;

    public VentaActualizada(VentaId ventaId) {
        super("co.com.ventas.ventas.VentaActualizada");
        this.ventaId = ventaId;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
