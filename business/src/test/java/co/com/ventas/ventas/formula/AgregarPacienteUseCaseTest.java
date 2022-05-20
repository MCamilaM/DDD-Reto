package co.com.ventas.ventas.formula;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.commands.AgregarPaciente;
import co.com.ventas.ventas.formula.events.FormulaCreada;
import co.com.ventas.ventas.formula.events.PacienteAgregado;
import co.com.ventas.ventas.formula.values.*;
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
class AgregarPacienteUseCaseTest {

    @InjectMocks
    private AgregarPacienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarPacienteHappyPass(){

        FormulaId formulaId = FormulaId.of("frm3");
        PacienteId pacienteId = PacienteId.of("pac2");
        Nombre nombre = new Nombre("Jorge");
        Edad edad = new Edad(34);
        Direccion direccion = new Direccion("Calle 23-3");
        Telefono telefono = new Telefono("0123456789");
        Diagnostico diagnostico = new Diagnostico("wwww");

        var command = new AgregarPaciente(formulaId,pacienteId,nombre,edad,direccion,telefono,diagnostico);

        when(repository.getEventsBy("frm3")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getFormulaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (PacienteAgregado) events.get(0);
        Assertions.assertEquals("frm3", event.aggregateRootId());
        Assertions.assertEquals("pac2", event.getPacienteId().value());
        Assertions.assertEquals("Jorge", event.getNombre().value());
        Assertions.assertEquals(34, event.getEdad().value());
        Assertions.assertEquals("Calle 23-3", event.getDireccion().value());
        Assertions.assertEquals("0123456789", event.getTelefono().value());
        Assertions.assertEquals("wwww", event.getDiagnostico().value());

    }

    private List<DomainEvent> history() {
        ClinicaId clinicaId = ClinicaId.of("cl2");
        Nombre nombre = new Nombre("San juan");
        Telefono telefono = new Telefono("0123456789");
        Direccion direccion = new Direccion("calle 90-5");
        Clinica clinica = new Clinica(clinicaId,nombre,telefono,direccion);

        var event = new FormulaCreada(clinica);

        event.setAggregateRootId("frm3");
        return List.of(event);
    }

}