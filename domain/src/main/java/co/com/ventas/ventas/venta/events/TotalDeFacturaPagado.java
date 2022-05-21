package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.FacturaId;
import co.com.ventas.ventas.venta.values.Total;
import co.com.ventas.ventas.venta.values.VentaId;
/**
 * evento Total De Factura Pagado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class TotalDeFacturaPagado extends DomainEvent {
    private final VentaId ventaId;
    private final FacturaId facturaId;
    private final Total total;

    /**
     * Constructor
     * @param ventaId
     * @param facturaId
     * @param total
     */
    public TotalDeFacturaPagado(VentaId ventaId, FacturaId facturaId, Total total) {
        super("co.com.ventas.ventas.TotalDeFacturaPagado");
        this.ventaId = ventaId;
        this.facturaId = facturaId;
        this.total = total;
    }

    /**
     * Getters
     */
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
