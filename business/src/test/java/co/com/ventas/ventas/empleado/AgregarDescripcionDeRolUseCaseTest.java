package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.commands.AgregarDescripcionDeRol;
import co.com.ventas.ventas.empleado.events.DescripcionAgregadaDeRol;
import co.com.ventas.ventas.empleado.events.EmpleadoCreado;
import co.com.ventas.ventas.empleado.events.RolAgregado;
import co.com.ventas.ventas.empleado.values.*;
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
class AgregarDescripcionDeRolUseCaseTest {

    @InjectMocks
    private AgregarDescripcionDeRolUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarDescripcionDeRolHappyPass(){
        //arrange
        EmpleadoId empleadoId = EmpleadoId.of("emp5");
        RolId rolId = RolId.of("rol3");
        Descripcion descripcion = new Descripcion("Maneja el negocio A");
        var command = new AgregarDescripcionDeRol(empleadoId,rolId,descripcion);

        when(repository.getEventsBy("emp5")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getEmpleadoId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (DescripcionAgregadaDeRol)events.get(0);
        Assertions.assertEquals("Maneja el negocio A", event.getDescripcion().value());
        /*Assertions.assertEquals("emp5",event.aggregateRootId());
        Assertions.assertEquals("rol3",event.getRolId().value());*/

    }

    private List<DomainEvent> history() {
        ContratoId contratoId = new ContratoId("c4");
        LocalTime hora = LocalTime.of(10,50,18,05);
        Fecha fecha = new Fecha(hora, LocalDate.now());
        Descripcion descripcion = new Descripcion("Termino definido");
        Contrato contrato = new Contrato(contratoId, fecha, descripcion);

        var event = new EmpleadoCreado(
                new Nombre("Carlos"),
                contrato
        );

        RolId rolId = RolId.of("rol3");
        Nombre nombre = new Nombre("Admin");
        var event2 = new RolAgregado(rolId,nombre);

        event.setAggregateRootId("emp5");

        return List.of(event,event2);
    }
}