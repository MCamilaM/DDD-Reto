package co.com.ventas.ventas.formula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.formula.values.Especialidad;
import co.com.ventas.ventas.formula.values.FormulaId;
import generics.Nombre;
import generics.Telefono;

public class AgregarDoctor extends Command {
    private final FormulaId formulaId;
    private final Nombre nombre;
    private final Especialidad especialidad;
    private final Telefono telefono;

    public AgregarDoctor(FormulaId formulaId, Nombre nombre, Especialidad especialidad, Telefono telefono) {
        this.formulaId = formulaId;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }

    public FormulaId getFormulaId() {
        return formulaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
