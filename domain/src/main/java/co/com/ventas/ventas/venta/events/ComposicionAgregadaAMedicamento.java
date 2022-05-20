package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.Composicion;
import co.com.ventas.ventas.venta.values.MedicamentoId;

public class ComposicionAgregadaAMedicamento extends DomainEvent {
    private final MedicamentoId medicamentoId;
    private final Composicion composicion;

    public ComposicionAgregadaAMedicamento(MedicamentoId medicamentoId, Composicion composicion) {
        super("co.com.ventas.ventas.ComposicionAgregadaAMedicamento");
        this.medicamentoId = medicamentoId;
        this.composicion = composicion;
    }

    public MedicamentoId getMedicamentoId() {
        return medicamentoId;
    }

    public Composicion getComposicion() {
        return composicion;
    }
}
