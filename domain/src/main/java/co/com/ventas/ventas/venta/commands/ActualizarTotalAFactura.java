package co.com.ventas.ventas.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.venta.values.FacturaId;
import co.com.ventas.ventas.venta.values.Total;
import co.com.ventas.ventas.venta.values.VentaId;

public class ActualizarTotalAFactura extends Command {
    private final VentaId ventaId;
    private final FacturaId facturaId;
    private final Total total;

    public ActualizarTotalAFactura(VentaId ventaId, FacturaId facturaId, Total total) {
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
