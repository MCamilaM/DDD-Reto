package co.com.ventas.ventas.empleado;

import co.com.sofka.domain.generic.Entity;
import co.com.ventas.ventas.empleado.values.Descripcion;
import co.com.ventas.ventas.empleado.values.RolId;
import generics.Nombre;

import java.util.Objects;

/**
 * Entidad Rol
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Rol extends Entity<RolId> {

    protected Nombre nombre;
    protected Descripcion descripcion;

    /**
     * Constructor
     * @param entityId
     * @param nombre
     */
    public Rol(RolId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    /**
     * Metodo para agregar Descripcion
     * @param descripcion
     */
    public void agregarDescripcion(Descripcion descripcion){
        this.descripcion = Objects.requireNonNull(descripcion);
    }

}
