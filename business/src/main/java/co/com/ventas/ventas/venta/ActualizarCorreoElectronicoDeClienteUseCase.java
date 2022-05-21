package co.com.ventas.ventas.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.venta.commands.ActualizarCorreoElectronicoDeCliente;


public class ActualizarCorreoElectronicoDeClienteUseCase extends UseCase<RequestCommand<ActualizarCorreoElectronicoDeCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCorreoElectronicoDeCliente> actualizarCorreoElectronicoDeClienteRequestCommand) {
        var command = actualizarCorreoElectronicoDeClienteRequestCommand.getCommand();

        var venta = Venta.from(command.getVentaId(),repository().getEventsBy(command.getVentaId().value()));

        venta.actualizarCorreoElectronicoDeCliente(command.getClienteId(), command.getCorreoElectronico());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));

    }
}
