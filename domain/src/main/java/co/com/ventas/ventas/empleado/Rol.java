package co.com.ventas.ventas.empleado;

import co.com.sofka.domain.generic.Entity;
import co.com.ventas.ventas.empleado.values.Descripcion;
import co.com.ventas.ventas.empleado.values.RolId;

import java.util.Objects;

public class Rol extends Entity<RolId> {

    protected Nombre nombre;
    protected Descripcion descripcion;

    public Rol(RolId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    public void agregarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

}
