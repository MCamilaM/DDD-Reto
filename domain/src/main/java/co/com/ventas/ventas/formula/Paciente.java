package co.com.ventas.ventas.formula;

import co.com.sofka.domain.generic.Entity;
import co.com.ventas.ventas.formula.values.PacienteId;
import generics.Direccion;
import generics.Telefono;
import co.com.ventas.ventas.formula.values.Diagnostico;
import co.com.ventas.ventas.formula.values.Edad;
import generics.Nombre;
import java.util.Objects;

public class Paciente extends Entity<PacienteId> {

    protected Nombre nombre;
    protected Edad edad;
    protected Direccion direccion;
    protected Telefono telefono;
    protected Diagnostico diagnostico;

    public Paciente(PacienteId pacienteId, Nombre nombre, Edad edad, Direccion direccion, Telefono telefono, Diagnostico diagnostico) {
        super(pacienteId);
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.diagnostico = diagnostico;
    }

    public void actualizarDiagnostico(Diagnostico diagnostico){
        this.diagnostico = Objects.requireNonNull(diagnostico);
    }
}
