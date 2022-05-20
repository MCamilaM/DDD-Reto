package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.empleado.commands.CrearEmpleado;

public class CrearEmpleadoUseCase extends UseCase<RequestCommand<CrearEmpleado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEmpleado> crearEmpleadoRequestCommand) {
        var command = crearEmpleadoRequestCommand.getCommand();

        var empleado = new Empleado(command.getEmpleadoId(), command.getNombre(), command.getContrato());

        emit().onResponse(new ResponseEvents(empleado.getUncommittedChanges()));
    }
}
