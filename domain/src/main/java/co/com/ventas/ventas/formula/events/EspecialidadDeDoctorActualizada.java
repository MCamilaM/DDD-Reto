package co.com.ventas.ventas.formula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.values.DoctorId;
import co.com.ventas.ventas.formula.values.Especialidad;

/**
 * evento Especialidad De Doctor Actualizada
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class EspecialidadDeDoctorActualizada extends DomainEvent {
    private final DoctorId doctorId;
    private final Especialidad especialidad;

    /**
     * Constructor
     * @param doctorId
     * @param especialidad
     */
    public EspecialidadDeDoctorActualizada(DoctorId doctorId, Especialidad especialidad) {
        super("co.com.ventas.ventas.EspecialidadDeDoctorActualizada");
        this.doctorId = doctorId;
        this.especialidad = especialidad;
    }


    /**
     * Getters
     */
    public DoctorId getDoctorId() {
        return doctorId;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
