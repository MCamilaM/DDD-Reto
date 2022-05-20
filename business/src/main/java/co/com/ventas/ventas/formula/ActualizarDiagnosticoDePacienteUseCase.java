package co.com.ventas.ventas.formula;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.formula.commands.ActualizarDiagnosticoDePaciente;

public class ActualizarDiagnosticoDePacienteUseCase extends UseCase<RequestCommand<ActualizarDiagnosticoDePaciente>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarDiagnosticoDePaciente> actualizarDiagnosticoDePacienteRequestCommand) {
        var command = actualizarDiagnosticoDePacienteRequestCommand.getCommand();
        var formula = Formula.from(command.getFormulaId(),repository().getEventsBy(command.getFormulaId().value()));

        formula.actualizarDiagnosticoDePaciente(command.getPacienteId(),command.getDiagnostico());

        emit().onResponse(new ResponseEvents(formula.getUncommittedChanges()));
    }
}
