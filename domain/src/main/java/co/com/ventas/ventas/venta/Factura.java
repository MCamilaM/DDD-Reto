package co.com.ventas.ventas.venta;

import co.com.sofka.domain.generic.Entity;
import co.com.ventas.ventas.venta.values.FacturaId;
import co.com.ventas.ventas.venta.values.Total;
import generics.Fecha;

import java.util.Objects;
/**
 * Entidad Factura
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Factura extends Entity<FacturaId> {
    protected Fecha fecha;
    protected Total total;


    /**
     * Constructor
     * @param facturaId
     * @param fecha
     * @param total
     */
    public Factura(FacturaId facturaId, Fecha fecha, Total total) {
        super(facturaId);
        this.fecha = fecha;
        this.total = total;
    }

    /**
     * metodo para actualizar total
     * @param total
     */
    public void actualizarTotal(Total total){
        this.total = Objects.requireNonNull(total);
    }
}

