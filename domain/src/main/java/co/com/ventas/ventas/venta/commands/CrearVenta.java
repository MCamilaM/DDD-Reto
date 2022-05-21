package co.com.ventas.ventas.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.venta.Cliente;
import co.com.ventas.ventas.venta.Factura;
import co.com.ventas.ventas.venta.values.VentaId;
/**
 * Comando Crear Venta
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class CrearVenta extends Command {

    private final VentaId ventaId;
    private final EmpleadoId empleadoId;
    private final FormulaId formulaId;
    private final Cliente cliente;
    private final Factura factura;

    /**
     * Constructor
     * @param ventaId
     * @param empleadoId
     * @param formulaId
     * @param cliente
     * @param factura
     */
    public CrearVenta(VentaId ventaId,
                      EmpleadoId empleadoId,
                      FormulaId formulaId,
                      Cliente cliente,
                      Factura factura) {
        this.ventaId = ventaId;
        this.empleadoId = empleadoId;
        this.formulaId = formulaId;
        this.cliente = cliente;
        this.factura = factura;
    }

    /**
     * Getters
     */
    public VentaId getVentaId() {
        return ventaId;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public FormulaId getFormulaId() {
        return formulaId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Factura getFactura() {
        return factura;
    }
}
