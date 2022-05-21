package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.VentaId;

/**
 * evento Venta Actualizada
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class VentaActualizada extends DomainEvent {

    private final VentaId ventaId;

    /**
     * Constructor
     * @param ventaId
     */
    public VentaActualizada(VentaId ventaId) {
        super("co.com.ventas.ventas.VentaActualizada");
        this.ventaId = ventaId;
    }

    /**
     * Getters
     */
    public VentaId getVentaId() {
        return ventaId;
    }
}
