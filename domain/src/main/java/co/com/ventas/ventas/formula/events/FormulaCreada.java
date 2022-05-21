package co.com.ventas.ventas.formula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.Clinica;

/**
 * evento Formula Creada
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class FormulaCreada extends DomainEvent {
    private final Clinica clinica;

    /**
     * Constructor
     * @param clinica
     */
    public FormulaCreada(Clinica clinica) {
        super("co.com.ventas.ventas.FormulaCreada");
        this.clinica = clinica;
    }


    /**
     * Getters
     */
    public Clinica getClinica() {
        return clinica;
    }
}
