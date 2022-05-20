package co.com.ventas.ventas.formula;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.commands.ActualizarDiagnosticoDePaciente;
import co.com.ventas.ventas.formula.events.DiagnosticoDePacienteActualizado;
import co.com.ventas.ventas.formula.events.FormulaCreada;
import co.com.ventas.ventas.formula.values.ClinicaId;
import co.com.ventas.ventas.formula.values.Diagnostico;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.formula.values.PacienteId;
import generics.Direccion;
import generics.Nombre;
import generics.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarDiagnosticoDePacienteUseCaseTest {

    @InjectMocks
    private ActualizarDiagnosticoDePacienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarDiagnosticoDePacienteHappyPass(){
        FormulaId formulaId = FormulaId.of("frm4");
        PacienteId pacienteId = PacienteId.of("pac2");
        Diagnostico diagnostico = new Diagnostico("qqqq");

        var command = new ActualizarDiagnosticoDePaciente(formulaId,pacienteId,diagnostico);

        when(repository.getEventsBy("frm4")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getFormulaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (DiagnosticoDePacienteActualizado)events.get(0);
        Assertions.assertEquals("frm4", event.aggregateRootId());
        Assertions.assertEquals("pac2", event.getPacienteId().value());
        Assertions.assertEquals("qqqq", event.getDiagnostico().value());
    }

    private List<DomainEvent> history() {
        ClinicaId clinicaId = ClinicaId.of("cl2");
        Nombre nombre = new Nombre("San juan");
        Telefono telefono = new Telefono("0123456789");
        Direccion direccion = new Direccion("calle 90-5");
        Clinica clinica = new Clinica(clinicaId,nombre,telefono,direccion);

        var event = new FormulaCreada(clinica);

        event.setAggregateRootId("frm4");
        return List.of(event);
    }

}