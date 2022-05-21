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

/**
 * Agregado Venta
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Venta extends AggregateEvent<VentaId> {

    protected EmpleadoId empleadoId;
    protected FormulaId formulaId;
    protected Cliente cliente;
    protected Factura factura;
    protected Map<MedicamentoId, Medicamento> medicamentos;

    /**
     * Constructor
     * @param ventaId
     * @param empleadoId
     * @param formulaId
     * @param cliente
     * @param factura
     */
    public Venta(VentaId ventaId,
                 EmpleadoId empleadoId,
                 FormulaId formulaId,
                 Cliente cliente,
                 Factura factura)
    {
        super(ventaId);
        appendChange(new VentaCreada(empleadoId, formulaId, cliente, factura)).apply();
        subscribe(new VentaEventChange(this));
    }

    /**
     * Constructor
     * @param ventaId
     */
    private Venta(VentaId ventaId){
        super(ventaId);
        subscribe(new VentaEventChange(this));
    }

    /**
     * Metodo para aplicar todos los eventos
     * @param ventaId
     * @param events
     * @return
     */
    public static Venta from(VentaId ventaId, List<DomainEvent> events){
        var venta = new Venta(ventaId);
        events.forEach(venta::applyEvent);
        return venta;
    }

    /**
     * Metodo para actualizar
      * @param medicamentoId
     * @param nombre
     * @param laboratorio
     * @param efectoFarmacologico
     * @param precio
     * @param cantidad
     */
    public void agregarMedicamento(MedicamentoId medicamentoId,
                                   Nombre nombre,
                                   Laboratorio laboratorio,
                                   EfectoFarmacologico efectoFarmacologico,
                                   Precio precio,
                                   Cantidad cantidad){
        appendChange(new MedicamentoCreado(medicamentoId, nombre, laboratorio, efectoFarmacologico, precio, cantidad));
    }

    /**
     * Metodo para agregar composicion al medicamento
      * @param medicamentoId
     * @param composicion
     */
    public void agregarComposicionDeMedicamento(MedicamentoId medicamentoId, Composicion composicion){
        appendChange(new ComposicionAgregadaAMedicamento(medicamentoId, composicion));
    }

    /**
     * Metodo para actualizar total de una factura
     * @param ventaId
     * @param facturaId
     * @param total
     */
    public void actualizarTotalDeFactura(VentaId ventaId, FacturaId facturaId, Total total){
        appendChange(new TotalDeFacturaActualizado(ventaId, facturaId, total));
    }

    /**
     * Metodo para actualizar el correo electronico de un cliente
     * @param clienteId
     * @param correoElectronico
     */
    public void actualizarCorreoElectronicoDeCliente(ClienteId clienteId, CorreoElectronico correoElectronico){
        appendChange(new CorreoElectronicoDeClienteActualizado(clienteId,correoElectronico));
    }

    /**
     * Metodo para actualizar venta
     * @param ventaId
     */
    public void actualizarVenta(VentaId ventaId){
        appendChange(new VentaActualizada(ventaId));
    }
}
