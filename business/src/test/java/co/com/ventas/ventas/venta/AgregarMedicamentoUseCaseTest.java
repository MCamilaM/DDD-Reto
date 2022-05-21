package co.com.ventas.ventas.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.venta.commands.AgregarMedicamento;
import co.com.ventas.ventas.venta.events.MedicamentoCreado;
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
class AgregarMedicamentoUseCaseTest {

    @InjectMocks
    private AgregarMedicamentoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarMedicamentoHappyPass(){
        VentaId ventaId = VentaId.of("venta2");
        MedicamentoId medicamentoId = MedicamentoId.of("med1");
        Nombre nombre = new Nombre("Azitromicina");
        Laboratorio laboratorio = new Laboratorio("Genfar");
        EfectoFarmacologico efectoFarmacologico = new EfectoFarmacologico("aaaa");
        Precio precio = new Precio(5350D);
        Cantidad cantidad = new Cantidad(5);

        var command = new AgregarMedicamento(ventaId,
                            medicamentoId,
                            nombre,
                            laboratorio,
                            efectoFarmacologico,
                            precio,
                            cantidad);

        when(repository.getEventsBy("venta2")).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getVentaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (MedicamentoCreado)events.get(0);
        Assertions.assertEquals("venta2", event.aggregateRootId());
        Assertions.assertEquals("Azitromicina", event.getNombre().value());
        Assertions.assertEquals("Genfar", event.getLaboratorio().value());
        Assertions.assertEquals("aaaa", event.getEfectoFarmacologico().value());
        Assertions.assertEquals(5350D, event.getPrecio().value());
        Assertions.assertEquals(5, event.getCantidad().value());


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
        event.setAggregateRootId("venta2");
        return List.of(event);

    }

}