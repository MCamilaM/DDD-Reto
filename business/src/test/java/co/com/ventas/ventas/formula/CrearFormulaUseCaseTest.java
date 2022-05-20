package co.com.ventas.ventas.formula;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.ventas.ventas.formula.commands.CrearFormula;
import co.com.ventas.ventas.formula.events.FormulaCreada;
import co.com.ventas.ventas.formula.values.ClinicaId;
import co.com.ventas.ventas.formula.values.FormulaId;
import generics.Direccion;
import generics.Nombre;
import generics.Telefono;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearFormulaUseCaseTest {

    private CrearFormulaUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearFormulaUseCase();
    }

    @Test
    public void crearFormulaHappyPass(){
        //arrange
        FormulaId formulaId = FormulaId.of("fml1");

        ClinicaId clinicaId = ClinicaId.of("cl1");
        Nombre nombre = new Nombre("San Juan");
        Telefono telefono = new Telefono("0123456789");
        Direccion direccion = new Direccion("Calle 100-5");
        Clinica clinica = new Clinica(clinicaId,nombre,telefono,direccion);

        var command = new CrearFormula(formulaId, clinica);

        //act
        var events= UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        //asserts
        var event = (FormulaCreada)events.get(0);
        Assertions.assertEquals("fml1", event.aggregateRootId());
        Assertions.assertEquals(clinica, event.getClinica());
    }

}