package co.com.ventas.ventas.formula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.formula.values.Diagnostico;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.formula.values.PacienteId;

public class ActualizarDiagnosticoDePaciente extends Command {

    private final FormulaId formulaId;
    private final PacienteId pacienteId;
    private final Diagnostico diagnostico;

    public ActualizarDiagnosticoDePaciente(FormulaId formulaId, PacienteId pacienteId, Diagnostico diagnostico) {
        this.formulaId = formulaId;
        this.pacienteId = pacienteId;
        this.diagnostico = diagnostico;
    }

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
