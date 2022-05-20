package co.com.ventas.ventas.empleado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.ventas.ventas.empleado.commands.CrearEmpleado;
import co.com.ventas.ventas.empleado.events.EmpleadoCreado;
import co.com.ventas.ventas.empleado.values.ContratoId;
import co.com.ventas.ventas.empleado.values.Descripcion;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.empleado.values.Fecha;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CrearEmpleadoUseCaseTest {

    private CrearEmpleadoUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearEmpleadoUseCase();
    }

    @Test
    public void crearCursoHappyPass(){
        //arrange

        EmpleadoId empleadoId = EmpleadoId.of("emp1");

        Nombre nombre = new Nombre("Ramón");

        ContratoId contratoId = new ContratoId("c1");
        Fecha fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        Descripcion descripcion = new Descripcion("Termino indefinido");
        Contrato contrato = new Contrato(contratoId, fecha, descripcion);

        var command = new CrearEmpleado(empleadoId,  nombre, contrato);
        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        var empleadoCreado = (EmpleadoCreado)events.get(0);
        Assertions.assertEquals("emp1", empleadoCreado.aggregateRootId());
        Assertions.assertEquals("Ramón", empleadoCreado.getNombre().value());
        Assertions.assertEquals(contrato, empleadoCreado.getContrato());



    }

}