package co.com.ventas.ventas.formula.values;

import co.com.sofka.domain.generic.Identity;
/**
 * id de paciente
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class PacienteId extends Identity {
    public PacienteId(String id){
        super(id);
    }
    public static PacienteId of(String id) {
        return new PacienteId(id);
    }
}
