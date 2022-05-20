package co.com.ventas.ventas.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.ventas.ventas.empleado.values.EmpleadoId;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.venta.commands.CrearVenta;
import co.com.ventas.ventas.venta.events.VentaCreada;
import co.com.ventas.ventas.venta.values.*;
import generics.Fecha;
import generics.Nombre;
import generics.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

class CrearVentaUseCaseTest {

    private CrearVentaUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearVentaUseCase();
    }

    @Test
    public void crearVentaHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("venta1");
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

        var command = new CrearVenta(ventaId,empleadoId,formulaId,cliente,factura);

        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        var event = (VentaCreada)events.get(0);
        Assertions.assertEquals("venta1",event.aggregateRootId());
        Assertions.assertEquals("emp1",event.getEmpleadoId().value());
        Assertions.assertEquals("frm1",event.getFormulaId().value());
        Assertions.assertEquals("Jose",event.getCliente().nombre.value());
        Assertions.assertEquals("0123456789",event.getCliente().telefono.value());
        Assertions.assertEquals("jose1@gmail.com",event.getCliente().correoElectronico.value());
        Assertions.assertEquals(fecha,event.getFactura().fecha);
        Assertions.assertEquals(5634D,event.getFactura().total.value());



    }

}