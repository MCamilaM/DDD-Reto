package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.FacturaId;
import co.com.ventas.ventas.venta.values.Total;
import co.com.ventas.ventas.venta.values.VentaId;

public class TotalDeFacturaPagado extends DomainEvent {
    private final VentaId ventaId;
    private final FacturaId facturaId;
    private final Total total;

    public TotalDeFacturaPagado(VentaId ventaId, FacturaId facturaId, Total total) {
        super("co.com.ventas.ventas.TotalDeFacturaPagado");
        this.ventaId = ventaId;
        this.facturaId = facturaId;
        this.total = total;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Total getTotal() {
        return total;
    }

}
