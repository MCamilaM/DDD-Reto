package co.com.ventas.ventas.formula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.formula.values.Diagnostico;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.formula.values.PacienteId;

/**
 * comando Actualizar Diagnostico De Paciente
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class ActualizarDiagnosticoDePaciente extends Command {

    private final FormulaId formulaId;
    private final PacienteId pacienteId;
    private final Diagnostico diagnostico;

    /**
     * Constructor
     * @param formulaId
     * @param pacienteId
     * @param diagnostico
     */
    public ActualizarDiagnosticoDePaciente(FormulaId formulaId, PacienteId pacienteId, Diagnostico diagnostico) {
        this.formulaId = formulaId;
        this.pacienteId = pacienteId;
        this.diagnostico = diagnostico;
    }

    /**
     * Getters
     */
    public FormulaId getFormulaId() {
        return formulaId;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
}
