package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.VentaId;
/**
 * evento Venta Finalizada
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class VentaFinalizada extends DomainEvent {
    private final VentaId ventaId;

    /**
     * Constructor
     * @param ventaId
     */
    public VentaFinalizada(VentaId ventaId) {
        super("co.com.ventas.ventas.VentaFinalizada");
        this.ventaId = ventaId;
    }

    /**
     * Getters
     */
    public VentaId getVentaId() {
        return ventaId;
    }
}
