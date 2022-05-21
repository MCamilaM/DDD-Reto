package co.com.ventas.ventas.formula.values;

import co.com.sofka.domain.generic.Identity;
/**
 * id de doctor
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class DoctorId extends Identity {
    public DoctorId(String id){
        super(id);
    }
    public static DoctorId of(String id) {
        return new DoctorId(id);
    }
}
