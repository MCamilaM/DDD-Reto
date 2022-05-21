package co.com.ventas.ventas.venta;

import co.com.sofka.domain.generic.EventChange;
import co.com.ventas.ventas.venta.events.*;

import java.util.HashMap;

public class VentaEventChange extends EventChange {
    public VentaEventChange(Venta venta) {
        apply((VentaCreada event)  ->{
            venta.factura = event.getFactura();
            venta.cliente = event.getCliente();
            venta.empleadoId = event.getEmpleadoId();
            venta.formulaId = event.getFormulaId();
            venta.medicamentos =  new HashMap<>();
        });
        apply((MedicamentoCreado event) ->{
            var medicamento = new Medicamento(event.getMedicamentoId(),
                    event.getNombre(),
                    event.getLaboratorio(),
                    event.getEfectoFarmacologico(),
                    event.getPrecio(),
                    event.getCantidad());

            venta.medicamentos.put(event.getMedicamentoId(), medicamento);

        });
        apply((ComposicionAgregadaAMedicamento event) ->{
            venta.medicamentos.get(event.getMedicamentoId()).agregarComposicion(event.getComposicion());
        });

        apply((TotalDeFacturaActualizado event) ->{
            venta.actualizarTotalDeFactura(event.getVentaId(), event.getFacturaId(),event.getTotal());
        });

        apply((CorreoElectronicoDeClienteActualizado event) ->{
            venta.actualizarCorreoElectronicoDeCliente(event.getClienteId(), event.getCorreoElectronico());
        });

    }

}
