package co.com.ventas.ventas.formula.values;

import co.com.sofka.domain.generic.Identity;

public class ClinicaId extends Identity {
    public ClinicaId(String id){
        super(id);
    }
    public static ClinicaId of(String id) {
        return new ClinicaId(id);
    }
}
