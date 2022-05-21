package co.com.ventas.ventas.formula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.values.ClinicaId;
import generics.Nombre;
/**
 * evento Nombre De Clinica Actualizado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class NombreDeClinicaActualizado extends DomainEvent {
    private final ClinicaId clinicaId;
    private final Nombre nombre;

    /**
     * Constructor
     * @param clinicaId
     * @param nombre
     */
    public NombreDeClinicaActualizado(ClinicaId clinicaId, Nombre nombre) {
        super("co.com.ventas.ventas.NombreDeClinicaActualizado");
        this.clinicaId = clinicaId;
        this.nombre = nombre;
    }


    /**
     * Getters
     */
    public ClinicaId getClinicaId() {
        return clinicaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
