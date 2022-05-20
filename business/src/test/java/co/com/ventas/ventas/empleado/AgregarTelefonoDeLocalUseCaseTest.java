package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.commands.AgregarTelefonoDeLocal;
import co.com.ventas.ventas.empleado.events.EmpleadoCreado;
import co.com.ventas.ventas.empleado.events.TelefonoAgregadoDeLocal;
import co.com.ventas.ventas.empleado.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AgregarTelefonoDeLocalUseCaseTest {

    @InjectMocks
    private AgregarTelefonoDeLocalUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarTelefonoDeLocalHappyPass(){
        //arrange
        EmpleadoId empleadoId = EmpleadoId.of("emp4");
        LocalId localId = LocalId.of("loc3");
        Telefono telefono = new Telefono("0123456789");
        var command = new AgregarTelefonoDeLocal(empleadoId,localId,telefono);

        when(repository.getEventsBy("emp4")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEmpleadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (TelefonoAgregadoDeLocal)events.get(0);
        Assertions.assertEquals("0123456789", event.getTelefono().value());

    }

    private List<DomainEvent> history() {
        ContratoId contratoId = new ContratoId("c3");
        Fecha fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        Descripcion descripcion = new Descripcion("por horas");
        Contrato contrato = new Contrato(contratoId, fecha, descripcion);

        var event = new EmpleadoCreado(
                new Nombre("Ana"),
                contrato
        );
        event.setAggregateRootId("emp4");

        return List.of(event);
    }

}