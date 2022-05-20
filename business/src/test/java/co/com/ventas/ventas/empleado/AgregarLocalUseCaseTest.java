package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.commands.AgregarLocal;
import co.com.ventas.ventas.empleado.events.EmpleadoCreado;
import co.com.ventas.ventas.empleado.events.LocalAgregado;
import co.com.ventas.ventas.empleado.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarLocalUseCaseTest {

    @InjectMocks
    private  AgregarLocalUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarLocalHappyPass(){
        //arrange
        EmpleadoId empleadoId = EmpleadoId.of("emp2");
        Direccion direccion = new Direccion("Calle 1-3");
        var command = new AgregarLocal(empleadoId,direccion);

        when(repository.getEventsBy("emp2")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEmpleadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (LocalAgregado)events.get(0);
        Assertions.assertEquals("Calle 1-3", event.getDireccion().value());
    }

    private List<DomainEvent> history() {
        ContratoId contratoId = new ContratoId("c3");
        LocalTime hora = LocalTime.of(10,50,18,05);
        Fecha fecha = new Fecha(hora, LocalDate.now());
        Descripcion descripcion = new Descripcion("Termino definido");
        Contrato contrato = new Contrato(contratoId, fecha, descripcion);

        var event = new EmpleadoCreado(
                new Nombre("Rayo"),
                contrato
        );
        event.setAggregateRootId("emp2");

        return List.of(event);
    }
}