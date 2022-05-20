package co.com.ventas.ventas.formula;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.ventas.ventas.formula.commands.CrearFormula;

public class CrearFormulaUseCase extends UseCase<RequestCommand<CrearFormula>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearFormula> crearFormulaRequestCommand) {
        var command = crearFormulaRequestCommand.getCommand();

        var formula = new Formula(command.getFormulaId(),command.getClinica());

        emit().onResponse(new ResponseEvents(formula.getUncommittedChanges()));
    }
}
