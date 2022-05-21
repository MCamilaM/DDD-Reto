package co.com.ventas.ventas.formula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.formula.values.DoctorId;
import co.com.ventas.ventas.formula.values.Especialidad;
import co.com.ventas.ventas.formula.values.FormulaId;
import generics.Nombre;
import generics.Telefono;

/**
 * comando Agregar Doctor
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class AgregarDoctor extends Command {
    private final FormulaId formulaId;
    private final DoctorId doctorId;
    private final Nombre nombre;
    private final Especialidad especialidad;
    private final Telefono telefono;

    /**
     * Constructor
     * @param formulaId
     * @param doctorId
     * @param nombre
     * @param especialidad
     * @param telefono
     */
    public AgregarDoctor(FormulaId formulaId, DoctorId doctorId, Nombre nombre, Especialidad especialidad, Telefono telefono) {
        this.formulaId = formulaId;
        this.doctorId = doctorId;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
    }
    /**
     * Getters
     */

    public FormulaId getFormulaId() {
        return formulaId;
    }

    public DoctorId getDoctorId() {
        return doctorId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
