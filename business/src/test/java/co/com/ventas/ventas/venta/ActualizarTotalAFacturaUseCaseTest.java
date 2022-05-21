package co.com.ventas.ventas.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.venta.commands.ActualizarTotalAFactura;
import co.com.ventas.ventas.venta.events.TotalDeFacturaActualizado;
import co.com.ventas.ventas.venta.events.VentaCreada;
import co.com.ventas.ventas.venta.values.*;
import generics.Fecha;
import generics.Nombre;
import generics.Telefono;
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
class ActualizarTotalAFacturaUseCaseTest {

    @InjectMocks
    private ActualizarTotalAFacturaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarTotalAFacturaHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("venta1");
        FacturaId facturaId = FacturaId.of("fac1");
        Total total = new Total(4370D);

        var command = new ActualizarTotalAFactura(ventaId,facturaId,total);

        when(repository.getEventsBy("venta1")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getVentaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        var event = (TotalDeFacturaActualizado)events.get(0);
        Assertions.assertEquals("venta1", event.aggregateRootId());
        Assertions.assertEquals("fac1", event.getFacturaId().value());
        Assertions.assertEquals(4370D, event.getTotal().value());


    }

    private List<DomainEvent> history() {
        EmpleadoId empleadoId = EmpleadoId.of("emp1");
        FormulaId formulaId = FormulaId.of("frm1");

        ClienteId clienteId = ClienteId.of("cl1");
        Nombre nombre = new Nombre("Jose");
        Telefono telefono = new Telefono("0123456789");
        CorreoElectronico correoElectronico = new CorreoElectronico("jose1@gmail.com");

        Cliente cliente = new Cliente(clienteId,nombre,telefono,correoElectronico);

        FacturaId facturaId = FacturaId.of("fac1");
        LocalTime hora = LocalTime.of(5,40,36,05);
        LocalDate dia = LocalDate.of(2022,5,17);
        Fecha fecha = new Fecha(hora,dia);
        Total total = new Total(5634D);
        Factura factura = new Factura(facturaId,fecha,total);

        var event = new VentaCreada(empleadoId,formulaId,cliente,factura);
        event.setAggregateRootId("venta1");
        return List.of(event);

    }

}