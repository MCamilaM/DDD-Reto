package co.com.ventas.ventas.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.venta.values.Composicion;
import co.com.ventas.ventas.venta.values.MedicamentoId;
import co.com.ventas.ventas.venta.values.VentaId;

public class AgregarComposicionAMedicamento extends Command {
    private final VentaId ventaId;
    private final MedicamentoId medicamentoId;
    private final Composicion composicion;

    public AgregarComposicionAMedicamento(VentaId ventaId, MedicamentoId medicamentoId, Composicion composicion) {
        this.ventaId = ventaId;
        this.medicamentoId = medicamentoId;
        this.composicion = composicion;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public MedicamentoId getMedicamentoId() {
        return medicamentoId;
    }

    public Composicion getComposicion() {
        return composicion;
    }
}
