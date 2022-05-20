package co.com.ventas.ventas.formula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.values.DoctorId;
import co.com.ventas.ventas.formula.values.Especialidad;
import generics.Nombre;
import generics.Telefono;

public class DoctorAgregado extends DomainEvent {
    private final DoctorId doctorId;
    private final Nombre nombre;
    private final Especialidad especialidad;
    private final Telefono telefono;

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
