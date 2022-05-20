package co.com.ventas.ventas.formula;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.commands.ActualizarEspecialidadDeDoctor;
import co.com.ventas.ventas.formula.events.EspecialidadDeDoctorActualizada;
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
class ActualizarEspecialidadDeDoctorUseCaseTest {

    @InjectMocks
    private ActualizarEspecialidadDeDoctorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarEspecialidadDeDoctorHappyPass(){
        //arrange
        FormulaId formulaId = FormulaId.of("frm5");
        DoctorId doctorId = DoctorId.of("doc2");
        Especialidad especialidad = new Especialidad("rrrr");

        var command = new ActualizarEspecialidadDeDoctor(formulaId,doctorId,especialidad);

        when(repository.getEventsBy("frm5")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getFormulaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assets
        var event = (EspecialidadDeDoctorActualizada)events.get(0);
        Assertions.assertEquals("frm5", event.aggregateRootId());
        Assertions.assertEquals("doc2", event.getDoctorId().value());
        Assertions.assertEquals("rrrr", event.getEspecialidad().value());


    }

    private List<DomainEvent> history() {
        ClinicaId clinicaId = ClinicaId.of("cl2");
        Nombre nombre = new Nombre("San juan");
        Telefono telefono = new Telefono("0123456789");
        Direccion direccion = new Direccion("calle 90-5");
        Clinica clinica = new Clinica(clinicaId,nombre,telefono,direccion);

        var event = new FormulaCreada(clinica);

        event.setAggregateRootId("frm5");
        return List.of(event);
    }

}