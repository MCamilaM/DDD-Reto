package co.com.ventas.ventas.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.ventas.ventas.venta.events.TotalDeFacturaPagado;

public class TotalDeFacturaActualizadoUseCase extends UseCase<TriggeredEvent<TotalDeFacturaPagado>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<TotalDeFacturaPagado> totalDeFacturaPagadoTriggeredEvent) {
        var event = totalDeFacturaPagadoTriggeredEvent.getDomainEvent();

        var venta = Venta.from(event.getVentaId(),repository().getEventsBy(event.getVentaId().value()));

        venta.actualizarTotalDeFacturaPagado(event.getVentaId(),event.getFacturaId(), event.getTotal());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));


    }
}
