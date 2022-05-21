package co.com.ventas.ventas.empleado;

import co.com.sofka.domain.generic.Entity;
import co.com.ventas.ventas.empleado.values.ContratoId;
import co.com.ventas.ventas.empleado.values.Descripcion;
import generics.Fecha;

import java.util.Objects;
/**
 * Entidad Contrato
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Contrato extends Entity<ContratoId> {

    protected Fecha fecha;
    protected Descripcion descripcion;

    /**
     * Constructor
     * @param entityId
     * @param fecha
     * @param descripcion
     */
    public Contrato(ContratoId entityId, Fecha fecha, Descripcion descripcion) {
        super(entityId);
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    /**
     * Metodo para modificar la fecha del contrato
     * @param fecha
     */
    public void modificarFecha(Fecha fecha){
        this.fecha = Objects.requireNonNull(fecha);
    }
}
