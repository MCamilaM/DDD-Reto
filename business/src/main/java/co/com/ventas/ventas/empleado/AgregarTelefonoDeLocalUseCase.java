package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.empleado.commands.AgregarTelefonoDeLocal;

public class AgregarTelefonoDeLocalUseCase extends UseCase<RequestCommand<AgregarTelefonoDeLocal>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarTelefonoDeLocal> agregarTelefonoDeLocalRequestCommand) {
        var command = agregarTelefonoDeLocalRequestCommand.getCommand();
        var empleado = Empleado.from(command.getEmpleadoId(),repository().getEventsBy(command.getEmpleadoId().value()));

        empleado.agregarTelefonoDeLocal(command.getLocalId(), command.getTelefono());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
