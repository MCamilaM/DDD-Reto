package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.empleado.commands.AgregarDescripcionDeRol;


public class AgregarDescripcionDeRolUseCase extends UseCase<RequestCommand<AgregarDescripcionDeRol>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDescripcionDeRol> agregarDescripcionDeRolRequestCommand) {
        var command = agregarDescripcionDeRolRequestCommand.getCommand();
        var empleado = Empleado.from(command.getEmpleadoId(),repository().getEventsBy(command.getEmpleadoId().value()));

        empleado.agregarDescripcionDeRol(command.getRolId(),command.getDescripcion());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
