package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.commands.AgregarRol;
import co.com.ventas.ventas.empleado.events.EmpleadoCreado;
import co.com.ventas.ventas.empleado.events.RolAgregado;
import co.com.ventas.ventas.empleado.values.ContratoId;
import co.com.ventas.ventas.empleado.values.Descripcion;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.empleado.values.Fecha;
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
class AgregarRolUseCaseTest {

    @InjectMocks
    private AgregarRolUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarRolHappyPass() {
        //arrange
        EmpleadoId empleadoId = EmpleadoId.of("emp1");
        Nombre nombre = new Nombre("Admin");
        var command = new AgregarRol(empleadoId, nombre);

        when(repository.getEventsBy("emp1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEmpleadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (RolAgregado) events.get(0);
        Assertions.assertEquals("Admin",event.getNombre().value());

    }

    private List<DomainEvent> history() {
        ContratoId contratoId = new ContratoId("c2");
        LocalTime hora = LocalTime.of(10,50,18,05);
        Fecha fecha = new Fecha(hora, LocalDate.now());
        Descripcion descripcion = new Descripcion("Termino definido");
        Contrato contrato = new Contrato(contratoId, fecha, descripcion);

        var event = new EmpleadoCreado(
                new Nombre("Rulfo"),
                contrato
        );
        event.setAggregateRootId("emp1");

        return List.of(event);
    }

}