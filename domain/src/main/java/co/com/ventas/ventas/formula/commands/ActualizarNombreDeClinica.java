package co.com.ventas.ventas.formula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.formula.values.ClinicaId;
import co.com.ventas.ventas.formula.values.FormulaId;
import generics.Nombre;

public class ActualizarNombreDeClinica extends Command {
    private final FormulaId formulaId;
    private final ClinicaId clinicaId;
    private final Nombre nombre;

    public ActualizarNombreDeClinica(FormulaId formulaId, ClinicaId clinicaId, Nombre nombre) {
        this.formulaId = formulaId;
        this.clinicaId = clinicaId;
        this.nombre = nombre;
    }

    public FormulaId getFormulaId() {
        return formulaId;
    }

    public ClinicaId getClinicaId() {
        return clinicaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
