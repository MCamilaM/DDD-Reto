package co.com.ventas.ventas.formula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.formula.values.DoctorId;
import co.com.ventas.ventas.formula.values.Especialidad;
import co.com.ventas.ventas.formula.values.FormulaId;

public class ActualizarEspecialidadDeDoctor extends Command {

    private final FormulaId formulaId;
    private final DoctorId doctorId;
    private final Especialidad especialidad;

    public ActualizarEspecialidadDeDoctor(FormulaId formulaId, DoctorId doctorId, Especialidad especialidad) {
        this.formulaId = formulaId;
        this.doctorId = doctorId;
        this.especialidad = especialidad;
    }

    public FormulaId getFormulaId() {
        return formulaId;
    }

    public DoctorId getDoctorId() {
        return doctorId;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
