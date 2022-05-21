package co.com.ventas.ventas.empleado;

import co.com.sofka.domain.generic.Entity;
import generics.Direccion;
import co.com.ventas.ventas.empleado.values.LocalId;
import generics.Telefono;

import java.util.Objects;

/**
 * Entidad Local
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Local extends Entity<LocalId> {

    protected Direccion direccion;
    protected Telefono telefono;

    /**
     * Constructor
     * @param entityId
     * @param direccion
     */
    public Local(LocalId entityId, Direccion direccion) {
        super(entityId);
        this.direccion = direccion;
    }

    /**
     * Metodo para agregarTelefono
     * @param telefono
     */
    public void agregarTelefono(Telefono telefono){
        this.telefono = Objects.requireNonNull(telefono);
    }
}
