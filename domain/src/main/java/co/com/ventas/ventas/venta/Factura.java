package co.com.ventas.ventas.venta;

import co.com.sofka.domain.generic.Entity;
import co.com.ventas.ventas.venta.values.FacturaId;
import co.com.ventas.ventas.venta.values.Total;
import generics.Fecha;

import java.util.Objects;

public class Factura extends Entity<FacturaId> {
    protected Fecha fecha;
    protected Total total;


    public Factura(FacturaId facturaId, Fecha fecha, Total total) {
        super(facturaId);
        this.fecha = fecha;
        this.total = total;
    }
    public void actualizarTotal(Total total){
        this.total = Objects.requireNonNull(total);
    }
}

