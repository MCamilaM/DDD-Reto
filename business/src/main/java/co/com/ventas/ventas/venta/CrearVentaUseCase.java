package co.com.ventas.ventas.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.venta.commands.CrearVenta;

public class CrearVentaUseCase extends UseCase<RequestCommand<CrearVenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearVenta> crearVentaRequestCommand) {
        var command = crearVentaRequestCommand.getCommand();
        var venta = new Venta(command.getVentaId(),
                command.getEmpleadoId(),
                command.getFormulaId(),
                command.getCliente(),
                command.getFactura());
        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
