package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.empleado.commands.AgregarLocal;
import co.com.ventas.ventas.empleado.commands.AgregarRol;

public class AgregarLocalUseCase extends UseCase<RequestCommand<AgregarLocal>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarLocal> agregarLocalRequestCommand) {
        var command = agregarLocalRequestCommand.getCommand();
        var empleado = Empleado.from(command.getEmpleadoId(),repository().getEventsBy(command.getEmpleadoId().value()));

        empleado.agregarLocal(command.getDireccion());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
