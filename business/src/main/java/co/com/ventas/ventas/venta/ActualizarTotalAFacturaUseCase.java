package co.com.ventas.ventas.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.venta.commands.ActualizarTotalAFactura;

public class ActualizarTotalAFacturaUseCase extends UseCase<RequestCommand<ActualizarTotalAFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTotalAFactura> actualizarTotalAFacturaRequestCommand) {
        var command = actualizarTotalAFacturaRequestCommand.getCommand();

        var venta = Venta.from(command.getVentaId(),repository().getEventsBy(command.getVentaId().value()));

        venta.actualizarTotalDeFactura(command.getVentaId(),command.getFacturaId(), command.getTotal());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
