package co.com.ventas.ventas.formula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.formula.values.Diagnostico;
import co.com.ventas.ventas.formula.values.Edad;
import co.com.ventas.ventas.formula.values.FormulaId;
import generics.Direccion;
import generics.Nombre;
import generics.Telefono;

public class AgregarPaciente extends Command {
    private final FormulaId formulaId;
    private final Nombre nombre;
    private final Edad edad;
    private final Direccion direccion;
    private final Telefono telefono;
    private final Diagnostico diagnostico;

    public AgregarPaciente(FormulaId formulaId,
                           Nombre nombre,
                           Edad edad,
                           Direccion direccion,
                           Telefono telefono,
                           Diagnostico diagnostico) {
        this.formulaId = formulaId;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.diagnostico = diagnostico;
    }

    public FormulaId getFormulaId() {
        return formulaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
}