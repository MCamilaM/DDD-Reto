package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.VentaId;

public class VentaFinalizada extends DomainEvent {
    private final VentaId ventaId;

    public VentaFinalizada(VentaId ventaId) {
        super("co.com.ventas.ventas.VentaFinalizada");
        this.ventaId = ventaId;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
