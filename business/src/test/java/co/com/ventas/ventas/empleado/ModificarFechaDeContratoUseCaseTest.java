package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.commands.ModificarFechaDeContrato;
import co.com.ventas.ventas.empleado.events.EmpleadoCreado;
import co.com.ventas.ventas.empleado.events.FechaModificadaDeContrato;
import co.com.ventas.ventas.empleado.values.ContratoId;
import co.com.ventas.ventas.empleado.values.Descripcion;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import generics.Fecha;
import generics.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModificarFechaDeContratoUseCaseTest {

    @InjectMocks
    private ModificarFechaDeContratoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    ModificarFechaDeContratoUseCaseTest() {
    }

    @Test
    public void modificarFechaDeContratroHappyPass(){
        EmpleadoId empleadoId = EmpleadoId.of("emp5");
        ContratoId contratoId = ContratoId.of("c5");
        LocalTime hora = LocalTime.of(5,40,36,05);
        LocalDate dia = LocalDate.of(2022,5,17);
        Fecha fecha = new Fecha(hora,dia);
        var command = new ModificarFechaDeContrato(empleadoId,contratoId,fecha);

        when(repository.getEventsBy("emp5")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEmpleadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (FechaModificadaDeContrato)events.get(0);
        Assertions.assertEquals(fecha, event.getFecha());


    }

    private List<DomainEvent> history() {
        ContratoId contratoId = new ContratoId("c5");
        LocalTime hora = LocalTime.of(10,50,18,05);
        Fecha fecha = new Fecha(hora, LocalDate.now());
        Descripcion descripcion = new Descripcion("por horas");
        Contrato contrato = new Contrato(contratoId, fecha, descripcion);

        var event = new EmpleadoCreado(
                new Nombre("Robert"),
                contrato
        );
        event.setAggregateRootId("emp5");

        return List.of(event);
    }

}