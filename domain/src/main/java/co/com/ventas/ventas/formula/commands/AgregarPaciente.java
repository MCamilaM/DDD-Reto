package co.com.ventas.ventas.formula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.formula.values.Diagnostico;
import co.com.ventas.ventas.formula.values.Edad;
import co.com.ventas.ventas.formula.values.FormulaId;
import co.com.ventas.ventas.formula.values.PacienteId;
import generics.Direccion;
import generics.Nombre;
import generics.Telefono;

/**
 * comando Agregar paciente
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class AgregarPaciente extends Command {
    private final FormulaId formulaId;
    private final PacienteId pacienteId;
    private final Nombre nombre;
    private final Edad edad;
    private final Direccion direccion;
    private final Telefono telefono;
    private final Diagnostico diagnostico;

    /**
     * Constructor
     * @param formulaId
     * @param pacienteId
     * @param nombre
     * @param edad
     * @param direccion
     * @param telefono
     * @param diagnostico
     */
    public AgregarPaciente(FormulaId formulaId,
                           PacienteId pacienteId,
                           Nombre nombre,
                           Edad edad,
                           Direccion direccion,
                           Telefono telefono,
                           Diagnostico diagnostico) {
        this.formulaId = formulaId;
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
    public FormulaId getFormulaId() {
        return formulaId;
    }

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