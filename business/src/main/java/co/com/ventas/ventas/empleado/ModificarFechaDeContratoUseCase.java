package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.empleado.commands.ModificarFechaDeContrato;

public class ModificarFechaDeContratoUseCase extends UseCase<RequestCommand<ModificarFechaDeContrato>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarFechaDeContrato> modificarFechaDeContratoRequestCommand) {
        var command = modificarFechaDeContratoRequestCommand.getCommand();
        var empleado = Empleado.from(command.getEmpleadoId(),repository().getEventsBy(command.getEmpleadoId().value()));

        empleado.modificarFechaDeContrato(command.getContratoId(),command.getFecha());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
