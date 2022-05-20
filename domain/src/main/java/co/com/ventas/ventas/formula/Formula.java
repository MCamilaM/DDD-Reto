package co.com.ventas.ventas.formula;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.formula.events.*;
import co.com.ventas.ventas.formula.values.*;
import generics.Direccion;
import generics.Nombre;
import generics.Telefono;

import java.util.List;

public class Formula extends AggregateEvent<FormulaId> {
    protected Paciente paciente;
    protected Clinica clinica;
    protected Doctor doctor;

    public Formula(FormulaId formulaId, Clinica clinica) {
        super(formulaId);
        this.clinica = clinica;
        appendChange(new FormulaCreada(clinica)).apply();
        subscribe(new FormulaEventChange(this));

    }

    private Formula(FormulaId formulaId){
        super(formulaId);
        subscribe(new FormulaEventChange(this));
    }

    public static Formula from(FormulaId formulaId, List<DomainEvent> events){
        var formula = new Formula(formulaId);
        events.forEach(formula::applyEvent);
        return formula;
    }

    public void agregarPaciente(PacienteId pacienteId, Nombre nombre, Edad edad, Direccion direccion, Telefono telefono, Diagnostico diagnostico){
        appendChange(new PacienteAgregado(pacienteId,nombre,edad,direccion,telefono,diagnostico));
    }

    public void agregarDoctor(DoctorId doctorId, Nombre nombre, Especialidad especialidad, Telefono telefono){
        appendChange(new DoctorAgregado(doctorId,nombre,especialidad,telefono));
    }

    public void actualizarDiagnosticoDePaciente(PacienteId pacienteId, Diagnostico diagnostico){
        appendChange(new DiagnosticoDePacienteActualizado(pacienteId, diagnostico));
    }

    public void actualizarNombreDeClinica(ClinicaId clinicaId, Nombre nombre){
        appendChange(new NombreDeClinicaActualizado(clinicaId, nombre));
    }

    public void actualizarEspecialidadDeDoctor(DoctorId doctorId, Especialidad especialidad){
        appendChange(new EspecialidadDeDoctorActualizada(doctorId, especialidad));
    }
}
