package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.Contrato;
import generics.Nombre;

/**
 * evento Empleado Creado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class EmpleadoCreado extends DomainEvent {
    private final Nombre nombre;
    private final Contrato contrato;

    /**
     * Constructor
     * @param nombre
     * @param contrato
     */
    public EmpleadoCreado(Nombre nombre, Contrato contrato) {
        super("co.com.ventas.ventas.EmpleadoCreado");
        this.nombre = nombre;
        this.contrato = contrato;
    }

    /**
     *Getters
     */
    public Nombre getNombre() {
        return nombre;
    }

    public Contrato getContrato() {
        return contrato;
    }

}
