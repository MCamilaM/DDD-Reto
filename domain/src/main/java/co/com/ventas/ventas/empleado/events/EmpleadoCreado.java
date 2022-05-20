package co.com.ventas.ventas.empleado.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.Contrato;
import co.com.ventas.ventas.empleado.Nombre;


public class EmpleadoCreado extends DomainEvent {
    private final Nombre nombre;
    private final Contrato contrato;

    public EmpleadoCreado(Nombre nombre, Contrato contrato) {
        super("co.com.ventas.ventas.EmpleadoCreado");
        this.nombre = nombre;
        this.contrato = contrato;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Contrato getContrato() {
        return contrato;
    }

}
