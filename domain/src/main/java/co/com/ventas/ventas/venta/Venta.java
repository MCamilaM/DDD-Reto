package co.com.ventas.ventas.venta;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.venta.values.MedicamentoId;
import co.com.ventas.ventas.venta.values.VentaId;

import java.util.List;
import java.util.Map;

public class Venta extends AggregateEvent<VentaId> {

    protected Map<MedicamentoId, Medicamento> medicamentos;
    protected EmpleadoId empleadoId;
    protected FormulaId formulaId;

    public Venta(VentaId ventaId,
                 Map<MedicamentoId, Medicamento> medicamentos,
                 EmpleadoId empleadoId,
                 FormulaId formulaId)
    {
        super(ventaId);
        this.medicamentos = medicamentos;
        this.empleadoId = empleadoId;
        this.formulaId = formulaId;
        appendChange(new VentaCreada(medicamentos, empleadoId, formulaId)).apply();
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
}
