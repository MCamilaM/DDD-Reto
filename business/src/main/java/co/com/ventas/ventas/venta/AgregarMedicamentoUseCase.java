package co.com.ventas.ventas.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.venta.commands.AgregarMedicamento;

public class AgregarMedicamentoUseCase extends UseCase<RequestCommand<AgregarMedicamento>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMedicamento> agregarMedicamentoRequestCommand) {
        var command = agregarMedicamentoRequestCommand.getCommand();
        var venta = Venta.from(command.getVentaId(), repository().getEventsBy(command.getVentaId().value()));

        venta.agregarMedicamento(command.getMedicamentoId(),
                                command.getNombre(),
                                command.getLaboratorio(),
                                command.getEfectoFarmacologico(),
                                command.getPrecio(),
                                command.getCantidad());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));

    }
}
