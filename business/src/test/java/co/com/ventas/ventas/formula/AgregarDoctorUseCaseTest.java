package co.com.ventas.ventas.formula;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.commands.AgregarDoctor;
import co.com.ventas.ventas.formula.events.DoctorAgregado;
import co.com.ventas.ventas.formula.events.FormulaCreada;
import co.com.ventas.ventas.formula.values.ClinicaId;
import co.com.ventas.ventas.formula.values.DoctorId;
import co.com.ventas.ventas.formula.values.Especialidad;
import co.com.ventas.ventas.formula.values.FormulaId;
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
class AgregarDoctorUseCaseTest {

    @InjectMocks
    private AgregarDoctorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarDoctorHappyPass(){
        //arrange
        FormulaId formulaId = FormulaId.of("frm2");
        DoctorId doctorId = DoctorId.of("doc1");
        Nombre nombre = new Nombre("Oscar");
        Especialidad especialidad = new Especialidad("Cardiologo");
        Telefono telefono = new Telefono("0123456789");

        var command = new AgregarDoctor(formulaId,doctorId,nombre,especialidad,telefono);

        when(repository.getEventsBy("frm2")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getFormulaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (DoctorAgregado) events.get(0);
        Assertions.assertEquals("frm2", event.aggregateRootId());
        Assertions.assertEquals("doc1", event.getDoctorId().value());
        Assertions.assertEquals("Oscar", event.getNombre().value());
        Assertions.assertEquals("Cardiologo", event.getEspecialidad().value());
        Assertions.assertEquals("0123456789", event.getTelefono().value());
    }

    private List<DomainEvent> history() {
        ClinicaId clinicaId = ClinicaId.of("cl2");
        Nombre nombre = new Nombre("San juan");
        Telefono telefono = new Telefono("0123456789");
        Direccion direccion = new Direccion("calle 90-5");
        Clinica clinica = new Clinica(clinicaId,nombre,telefono,direccion);

        var event = new FormulaCreada(clinica);

        event.setAggregateRootId("frm2");
        return List.of(event);
    }

}