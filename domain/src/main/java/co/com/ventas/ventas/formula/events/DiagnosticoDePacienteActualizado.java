package co.com.ventas.ventas.formula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.values.Diagnostico;
import co.com.ventas.ventas.formula.values.PacienteId;

public class DiagnosticoDePacienteActualizado extends DomainEvent {
    private final PacienteId pacienteId;
    private final Diagnostico diagnostico;

    public DiagnosticoDePacienteActualizado(PacienteId pacienteId, Diagnostico diagnostico) {
        super("co.com.ventas.ventas.DiagnosticoDePacienteActualizado");
        this.pacienteId = pacienteId;
        this.diagnostico = diagnostico;
    }

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
}
