package co.com.ventas.ventas.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.venta.events.TotalDeFacturaActualizado;
import co.com.ventas.ventas.venta.events.VentaActualizada;
import co.com.ventas.ventas.venta.events.VentaCreada;
import co.com.ventas.ventas.venta.events.VentaFinalizada;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarVentaUseCaseTest {

    @InjectMocks
    private ActualizarVentaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarVentaHappyPass(){
        VentaId ventaId = VentaId.of("venta1");

        var event = new VentaFinalizada(ventaId);

        when(repository.getEventsBy("venta1")).thenReturn(history());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var ventaFinalizada = (VentaActualizada)events.get(0);
        Assertions.assertEquals("venta1",ventaFinalizada.getVentaId().value());
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