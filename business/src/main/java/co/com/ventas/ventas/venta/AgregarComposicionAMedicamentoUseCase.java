package co.com.ventas.ventas.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.venta.commands.AgregarComposicionAMedicamento;

public class AgregarComposicionAMedicamentoUseCase extends UseCase<RequestCommand<AgregarComposicionAMedicamento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarComposicionAMedicamento> agregarComposicionAMedicamentoRequestCommand) {
        var command = agregarComposicionAMedicamentoRequestCommand.getCommand();
        var venta = Venta.from(command.getVentaId(),repository().getEventsBy(command.getVentaId().value()));

        venta.agregarComposicionDeMedicamento(command.getMedicamentoId(), command.getComposicion());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));

    }
}
