package co.com.ventas.ventas.formula.values;

import co.com.sofka.domain.generic.Identity;
/**
 * id de clinica
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class ClinicaId extends Identity {
    public ClinicaId(String id){
        super(id);
    }
    public static ClinicaId of(String id) {
        return new ClinicaId(id);
    }
}
