package co.com.ventas.ventas.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.venta.values.Composicion;
import co.com.ventas.ventas.venta.values.MedicamentoId;
import co.com.ventas.ventas.venta.values.VentaId;
/**
 * Comando Agregar Composicion A Medicamento
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class AgregarComposicionAMedicamento extends Command {
    private final VentaId ventaId;
    private final MedicamentoId medicamentoId;
    private final Composicion composicion;

    /**
     * Constructor
     * @param ventaId
     * @param medicamentoId
     * @param composicion
     */
    public AgregarComposicionAMedicamento(VentaId ventaId, MedicamentoId medicamentoId, Composicion composicion) {
        this.ventaId = ventaId;
        this.medicamentoId = medicamentoId;
        this.composicion = composicion;
    }

    /**
     * Getters
     */
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
