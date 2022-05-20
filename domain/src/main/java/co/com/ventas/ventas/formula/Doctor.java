package co.com.ventas.ventas.formula;

import co.com.sofka.domain.generic.Entity;
import co.com.ventas.ventas.formula.values.DoctorId;
import co.com.ventas.ventas.formula.values.Especialidad;
import generics.Nombre;
import generics.Telefono;

import java.util.Objects;

public class Doctor extends Entity<DoctorId> {

    protected Nombre nombre;
    protected Especialidad especialidad;
    protected Telefono telefono;

    public Doctor(DoctorId doctorId, Nombre nombre, Especialidad especialidad, Telefono telefono) {
        super(doctorId);
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }

    public void actualizarEspecialidad(Especialidad especialidad){
        this.especialidad = Objects.requireNonNull(especialidad);
    }
}
