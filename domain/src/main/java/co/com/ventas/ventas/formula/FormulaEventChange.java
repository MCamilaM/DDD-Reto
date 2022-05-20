package co.com.ventas.ventas.formula;

import co.com.sofka.domain.generic.EventChange;
import co.com.ventas.ventas.formula.events.*;

public class FormulaEventChange extends EventChange {
    public FormulaEventChange(Formula formula) {
        apply((FormulaCreada event) ->{
            formula.clinica = event.getClinica();
        });

        apply((DoctorAgregado event) ->{
            var doctor = new Doctor(event.getDoctorId(),
                                    event.getNombre(),
                                    event.getEspecialidad(),
                                    event.getTelefono());
            formula.doctor = doctor;
        });

        apply((PacienteAgregado event) ->{
            var paciente = new Paciente(event.getPacienteId(),
                                        event.getNombre(),
                                        event.getEdad(),
                                        event.getDireccion(),
                                        event.getTelefono(),
                                        event.getDiagnostico());
            formula.paciente = paciente;
        });

        apply((DiagnosticoDePacienteActualizado event) ->{
            formula.actualizarDiagnosticoDePaciente(event.getPacienteId(), event.getDiagnostico());
        });

        apply((EspecialidadDeDoctorActualizada event) ->{
            formula.actualizarEspecialidadDeDoctor(event.getDoctorId(), event.getEspecialidad());
        });

        apply((NombreDeClinicaActualizado event) ->{
            formula.actualizarNombreDeClinica(event.getClinicaId(), event.getNombre());
        });
    }
}

