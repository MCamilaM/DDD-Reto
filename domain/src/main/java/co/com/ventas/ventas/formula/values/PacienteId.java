package co.com.ventas.ventas.formula.values;

import co.com.sofka.domain.generic.Identity;

public class PacienteId extends Identity {
    public PacienteId(String id){
        super(id);
    }
    public static PacienteId of(String id) {
        return new PacienteId(id);
    }
}
