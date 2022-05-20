package co.com.ventas.ventas.formula;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import co.com.ventas.ventas.formula.commands.ActualizarNombreDeClinica;

public class ActualizarNombreDeClinicaUseCase extends UseCase<RequestCommand<ActualizarNombreDeClinica>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreDeClinica> actualizarNombreDeClinicaRequestCommand) {
        var command = actualizarNombreDeClinicaRequestCommand.getCommand();

        var formula = Formula.from(command.getFormulaId(),repository().getEventsBy(command.getFormulaId().value()));

        formula.actualizarNombreDeClinica(command.getClinicaId(), command.getNombre());

        emit().onResponse(new ResponseEvents(formula.getUncommittedChanges()));
    }
}
