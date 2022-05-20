package co.com.ventas.ventas.formula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.Clinica;

public class FormulaCreada extends DomainEvent {
    private final Clinica clinica;

    public FormulaCreada(Clinica clinica) {
        super("co.com.ventas.ventas.FormulaCreada");
        this.clinica = clinica;
    }

    public Clinica getClinica() {
        return clinica;
    }
}
