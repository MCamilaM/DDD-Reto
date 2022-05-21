package co.com.ventas.ventas.formula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.formula.Clinica;
import co.com.ventas.ventas.formula.values.FormulaId;
/**
 * comando Crear Formula
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class CrearFormula extends Command {
    private final FormulaId formulaId;
    private final Clinica clinica;

    /**
     * Constructor
     * @param formulaId
     * @param clinica
     */
    public CrearFormula(FormulaId formulaId, Clinica clinica) {
        this.formulaId = formulaId;
        this.clinica = clinica;
    }

    /**
     * Getters
     */
    public FormulaId getFormulaId() {
        return formulaId;
    }

    public Clinica getClinica() {
        return clinica;
    }
}
