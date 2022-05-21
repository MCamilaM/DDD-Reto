package co.com.ventas.ventas.formula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.values.Diagnostico;
import co.com.ventas.ventas.formula.values.PacienteId;
/**
 * evento Diagnostico De Paciente Actualizado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class DiagnosticoDePacienteActualizado extends DomainEvent {
    private final PacienteId pacienteId;
    private final Diagnostico diagnostico;

    /**
     * Constructor
     * @param pacienteId
     * @param diagnostico
     */
    public DiagnosticoDePacienteActualizado(PacienteId pacienteId, Diagnostico diagnostico) {
        super("co.com.ventas.ventas.DiagnosticoDePacienteActualizado");
        this.pacienteId = pacienteId;
        this.diagnostico = diagnostico;
    }

    /**
     * Getters
     */
    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
}
