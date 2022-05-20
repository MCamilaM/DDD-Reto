package co.com.ventas.ventas.venta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.venta.events.*;
import co.com.ventas.ventas.venta.values.*;
import generics.Nombre;

import java.util.List;
import java.util.Map;

public class Venta extends AggregateEvent<VentaId> {

    protected EmpleadoId empleadoId;
    protected FormulaId formulaId;
    protected Cliente cliente;
    protected Factura factura;
    protected Map<MedicamentoId, Medicamento> medicamentos;

    public Venta(VentaId ventaId,
                 EmpleadoId empleadoId,
                 FormulaId formulaId,
                 Cliente cliente,
                 Factura factura)
    {
        super(ventaId);
        this.empleadoId = empleadoId;
        this.formulaId = formulaId;
        this.cliente = cliente;
        this.factura = factura;
        appendChange(new VentaCreada(empleadoId, formulaId, cliente, factura)).apply();
        subscribe(new VentaEventChange(this));
    }

    private Venta(VentaId ventaId){
        super(ventaId);
        subscribe(new VentaEventChange(this));
    }

    public static Venta from(VentaId ventaId, List<DomainEvent> events){
        var venta = new Venta(ventaId);
        events.forEach(venta::applyEvent);
        return venta;
    }

    public void agregarMedicamento(MedicamentoId medicamentoId,
                                   Nombre nombre,
                                   Laboratorio laboratorio,
                                   EfectoFarmacologico efectoFarmacologico,
                                   Composicion composicion,
                                   Precio precio,
                                   Cantidad cantidad){
        appendChange(new MedicamentoCreado(medicamentoId, nombre, laboratorio, efectoFarmacologico, composicion, precio, cantidad));
    }
    public void agregarComposicionDeMedicamento(MedicamentoId medicamentoId, Composicion composicion){
        appendChange(new ComposicionAgregadaAMedicamento(medicamentoId, composicion));
    }

    public void actualizarTotalDeFactura(FacturaId facturaId, Total total){
        appendChange(new TotalDeFacturaActualizado(facturaId, total));
    }

    public void actualizarCorreoElectronicoDeCliente(ClienteId clienteId, CorreoElectronico correoElectronico){
        appendChange(new CorreoElectronicoDeClienteActualizado(clienteId,correoElectronico));
    }
}
