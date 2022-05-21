package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.values.Descripcion;
import co.com.ventas.ventas.empleado.values.RolId;

/**
 * evento Descripcion Agregada De Rol
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class DescripcionAgregadaDeRol extends DomainEvent {
    private final RolId rolId;
    private final Descripcion descripcion;

    /**
     * Constructor
     * @param rolId
     * @param descripcion
     */
    public DescripcionAgregadaDeRol(RolId rolId, Descripcion descripcion) {
        super("co.com.ventas.ventas.DescripcionAgregadaARol");
        this.rolId = rolId;
        this.descripcion = descripcion;
    }

    /**
     *Getters
     */
    public RolId getRolId() {
        return rolId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
