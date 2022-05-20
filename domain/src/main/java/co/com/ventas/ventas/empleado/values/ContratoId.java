package co.com.ventas.ventas.empleado.values;

import co.com.sofka.domain.generic.Identity;

public class ContratoId extends Identity {
    public ContratoId(String id){
        super(id);
    }
    public static ContratoId of(String id) {
        return new ContratoId(id);
    }
}
