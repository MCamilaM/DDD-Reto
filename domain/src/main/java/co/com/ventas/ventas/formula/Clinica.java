package co.com.ventas.ventas.formula;

import co.com.sofka.domain.generic.Entity;
import generics.Direccion;
import generics.Telefono;
import co.com.ventas.ventas.formula.values.ClinicaId;
import generics.Nombre;

import java.util.Objects;

public class Clinica extends Entity<ClinicaId> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected Direccion direccion;

    public Clinica(ClinicaId clinicaId, Nombre nombre, Telefono telefono, Direccion direccion) {
        super(clinicaId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void ActualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }
}
