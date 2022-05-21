package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import generics.Nombre;
import co.com.ventas.ventas.empleado.values.RolId;

/**
 * evento Rol Agregado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class RolAgregado extends DomainEvent {
    private final RolId rolId;
    private final Nombre nombre;

    /**
     * Constructor
     * @param rolId
     * @param nombre
     */
    public RolAgregado(RolId rolId, Nombre nombre) {
        super("co.com.ventas.ventas.RolCreado");
        this.rolId = rolId;
        this.nombre = nombre;
    }


    /**
     * Getters
     */
    public RolId getRolId() {
        return rolId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}


