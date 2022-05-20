package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.FacturaId;
import co.com.ventas.ventas.venta.values.Total;

public class TotalDeFacturaActualizado extends DomainEvent {
    private final FacturaId facturaId;
    private final Total total;

    public TotalDeFacturaActualizado(FacturaId facturaId, Total total) {
        super("co.com.ventas.ventas.TotalDeFacturaActualizado");
        this.facturaId = facturaId;
        this.total = total;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Total getTotal() {
        return total;
    }
}
