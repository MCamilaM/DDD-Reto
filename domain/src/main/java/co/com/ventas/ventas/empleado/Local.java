package co.com.ventas.ventas.empleado;

import co.com.sofka.domain.generic.Entity;
import generics.Direccion;
import co.com.ventas.ventas.empleado.values.LocalId;
import generics.Telefono;

import java.util.Objects;

public class Local extends Entity<LocalId> {

    protected Direccion direccion;
    protected Telefono telefono;

    public Local(LocalId entityId, Direccion direccion) {
        super(entityId);
        this.direccion = direccion;
    }

    public void agregarTelefono(Telefono telefono){
        this.telefono = Objects.requireNonNull(telefono);
    }
}
