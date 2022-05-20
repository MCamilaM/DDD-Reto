package co.com.ventas.ventas.formula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.formula.Clinica;
import co.com.ventas.ventas.formula.values.FormulaId;

public class CrearFormula extends Command {
    private final FormulaId formulaId;
    private final Clinica clinica;

    public CrearFormula(FormulaId formulaId, Clinica clinica) {
        this.formulaId = formulaId;
        this.clinica = clinica;
    }

    public FormulaId getFormulaId() {
        return formulaId;
    }

    public Clinica getClinica() {
        return clinica;
    }
}
