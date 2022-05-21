package co.com.ventas.ventas.formula.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.values.Diagnostico;
import co.com.ventas.ventas.formula.values.Edad;
import co.com.ventas.ventas.formula.values.PacienteId;
import generics.Direccion;
import generics.Nombre;
import generics.Telefono;

/**
 * evento Paciente Agregado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class PacienteAgregado extends DomainEvent {
    private final PacienteId pacienteId;
    private final Nombre nombre;
    private final Edad edad;
    private final Direccion direccion;
    private final Telefono telefono;
    private final Diagnostico diagnostico;

    /**
     * Constructor
     * @param pacienteId
     * @param nombre
     * @param edad
     * @param direccion
     * @param telefono
     * @param diagnostico
     */
    public PacienteAgregado(PacienteId pacienteId,
                            Nombre nombre,
                            Edad edad,
                            Direccion direccion,
                            Telefono telefono,
                            Diagnostico diagnostico) {
        super("co.com.ventas.ventas.PacienteAgregado");
        this.pacienteId = pacienteId;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.diagnostico = diagnostico;
    }


    /**
     * Getters
     */
    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Edad getEdad() {
        return edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }
}
