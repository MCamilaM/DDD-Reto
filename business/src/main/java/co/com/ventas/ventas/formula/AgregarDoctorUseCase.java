package co.com.ventas.ventas.formula;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.formula.commands.AgregarDoctor;

public class AgregarDoctorUseCase extends UseCase<RequestCommand<AgregarDoctor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarDoctor> agregarDoctorRequestCommand) {
        var command = agregarDoctorRequestCommand.getCommand();

        var formula = Formula.from(command.getFormulaId(), repository().getEventsBy(command.getFormulaId().value()));

        formula.agregarDoctor(command.getDoctorId(), command.getNombre(), command.getEspecialidad(), command.getTelefono());

        emit().onResponse(new ResponseEvents(formula.getUncommittedChanges()));
    }
}
