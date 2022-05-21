package co.com.ventas.ventas.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.ventas.ventas.venta.events.TotalDeFacturaPagado;
import co.com.ventas.ventas.venta.events.VentaFinalizada;

public class ActualizarVentaUseCase  extends UseCase<TriggeredEvent<VentaFinalizada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<VentaFinalizada> ventaFinalizadaTriggeredEvent) {

        var event = ventaFinalizadaTriggeredEvent.getDomainEvent();

        var venta = Venta.from(event.getVentaId(),repository().getEventsBy(event.getVentaId().value()));

        venta.actualizarVenta(event.getVentaId());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
