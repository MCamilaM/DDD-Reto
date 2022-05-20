package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.empleado.commands.AgregarRol;

public class AgregarRolUseCase extends UseCase<RequestCommand<AgregarRol>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRol> agregarRolRequestCommand) {
        var command = agregarRolRequestCommand.getCommand();
        var empleado = Empleado.from(command.getEmpleadoId(), repository().getEventsBy(command.getEmpleadoId().value()));

        empleado.agregarRol(command.getNombre());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
