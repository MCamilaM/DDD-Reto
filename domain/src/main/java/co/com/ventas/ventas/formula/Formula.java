package co.com.ventas.ventas.formula;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.events.*;
import co.com.ventas.ventas.formula.values.*;
import generics.Direccion;
import generics.Nombre;
import generics.Telefono;

import java.util.List;
/**
 * Agregado Formula
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Formula extends AggregateEvent<FormulaId> {
    protected Paciente paciente;
    protected Clinica clinica;
    protected Doctor doctor;

    /**
     * Consturctor
     * @param formulaId
     * @param clinica
     */
    public Formula(FormulaId formulaId, Clinica clinica) {
        super(formulaId);
        this.clinica = clinica;
        appendChange(new FormulaCreada(clinica)).apply();
        subscribe(new FormulaEventChange(this));

    }

    /**
     * Constructor
     * @param formulaId
     */
    private Formula(FormulaId formulaId){
        super(formulaId);
        subscribe(new FormulaEventChange(this));
    }

    /**
     * metodo para aplicar todos los eventos
     * @param formulaId
     * @param events
     * @return
     */
    public static Formula from(FormulaId formulaId, List<DomainEvent> events){
        var formula = new Formula(formulaId);
        events.forEach(formula::applyEvent);
        return formula;
    }

    /**
     * Metodo para
      * @param pacienteId
     * @param nombre
     * @param edad
     * @param direccion
     * @param telefono
     * @param diagnostico
     */
    public void agregarPaciente(PacienteId pacienteId, Nombre nombre, Edad edad, Direccion direccion, Telefono telefono, Diagnostico diagnostico){
        appendChange(new PacienteAgregado(pacienteId,nombre,edad,direccion,telefono,diagnostico));
    }

    /**
     * Metodo para agregar doctor
     * @param doctorId
     * @param nombre
     * @param especialidad
     * @param telefono
     */
    public void agregarDoctor(DoctorId doctorId, Nombre nombre, Especialidad especialidad, Telefono telefono){
        appendChange(new DoctorAgregado(doctorId,nombre,especialidad,telefono));
    }

    /**
     * Metodo para actualizaa diagnostico de un paciente
     * @param pacienteId
     * @param diagnostico
     */
    public void actualizarDiagnosticoDePaciente(PacienteId pacienteId, Diagnostico diagnostico){
        appendChange(new DiagnosticoDePacienteActualizado(pacienteId, diagnostico));
    }

    /**
     * Metodo para actualizar nombre de una clinica
     * @param clinicaId
     * @param nombre
     */
    public void actualizarNombreDeClinica(ClinicaId clinicaId, Nombre nombre){
        appendChange(new NombreDeClinicaActualizado(clinicaId, nombre));
    }

    /**
     * Metodo para actualizar especialidad de un doctor
     * @param doctorId
     * @param especialidad
     */
    public void actualizarEspecialidadDeDoctor(DoctorId doctorId, Especialidad especialidad){
        appendChange(new EspecialidadDeDoctorActualizada(doctorId, especialidad));
    }
}
