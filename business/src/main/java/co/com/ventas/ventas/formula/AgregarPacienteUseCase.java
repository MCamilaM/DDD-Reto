package co.com.ventas.ventas.formula;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.formula.commands.AgregarPaciente;

public class AgregarPacienteUseCase extends UseCase<RequestCommand<AgregarPaciente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPaciente> agregarPacienteRequestCommand) {
        var command = agregarPacienteRequestCommand.getCommand();

        var formula = Formula.from(command.getFormulaId(), repository().getEventsBy(command.getFormulaId().value()));

        formula.agregarPaciente(command.getPacienteId(),
                                command.getNombre(),
                                command.getEdad(),
                                command.getDireccion(),
                                command.getTelefono(),
                                command.getDiagnostico());

        emit().onResponse(new ResponseEvents(formula.getUncommittedChanges()));
    }
}
