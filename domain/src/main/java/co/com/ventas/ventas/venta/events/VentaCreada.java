package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.venta.Cliente;
import co.com.ventas.ventas.venta.Factura;

public class VentaCreada extends DomainEvent {
    private final EmpleadoId empleadoId;
    private final FormulaId formulaId;
    private final Cliente cliente;
    private final Factura factura;

    public VentaCreada(EmpleadoId empleadoId, FormulaId formulaId, Cliente cliente, Factura factura) {
        super("co.com.ventas.ventas.VentaCreada");
        this.empleadoId = empleadoId;
        this.formulaId = formulaId;
        this.cliente = cliente;
        this.factura = factura;
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
