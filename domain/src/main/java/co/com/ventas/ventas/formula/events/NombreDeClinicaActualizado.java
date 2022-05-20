package co.com.ventas.ventas.formula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.values.ClinicaId;
import generics.Nombre;

public class NombreDeClinicaActualizado extends DomainEvent {
    private final ClinicaId clinicaId;
    private final Nombre nombre;

    public NombreDeClinicaActualizado(ClinicaId clinicaId, Nombre nombre) {
        super("co.com.ventas.ventas.NombreDeClinicaActualizado");
        this.clinicaId = clinicaId;
        this.nombre = nombre;
    }

    public ClinicaId getClinicaId() {
        return clinicaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
