package co.com.ventas.ventas.formula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.values.DoctorId;
import co.com.ventas.ventas.formula.values.Especialidad;
import generics.Nombre;
import generics.Telefono;

/**
 * evento Doctor Agregado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class DoctorAgregado extends DomainEvent {
    private final DoctorId doctorId;
    private final Nombre nombre;
    private final Especialidad especialidad;
    private final Telefono telefono;

    /**
     * Constructor
     * @param doctorId
     * @param nombre
     * @param especialidad
     * @param telefono
     */
    public DoctorAgregado(DoctorId doctorId,
                          Nombre nombre,
                          Especialidad especialidad,
                          Telefono telefono) {
        super("co.com.ventas.ventas.DoctorAgregado");
        this.doctorId = doctorId;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }


    /**
     * Getters
     */
    public DoctorId getDoctorId() {
        return doctorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
