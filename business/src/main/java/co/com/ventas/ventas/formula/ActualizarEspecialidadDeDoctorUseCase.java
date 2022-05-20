package co.com.ventas.ventas.formula;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.formula.commands.ActualizarEspecialidadDeDoctor;

public class ActualizarEspecialidadDeDoctorUseCase extends UseCase<RequestCommand<ActualizarEspecialidadDeDoctor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEspecialidadDeDoctor> actualizarEspecialidadDeDoctorRequestCommand) {
        var command = actualizarEspecialidadDeDoctorRequestCommand.getCommand();
        var formula = Formula.from(command.getFormulaId(),repository().getEventsBy(command.getFormulaId().value()));

        formula.actualizarEspecialidadDeDoctor(command.getDoctorId(),command.getEspecialidad());

        emit().onResponse(new ResponseEvents(formula.getUncommittedChanges()));
    }
}
