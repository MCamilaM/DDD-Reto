package co.com.ventas.ventas.empleado.values;

import co.com.sofka.domain.generic.Identity;
/**
 * id de contrato
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class ContratoId extends Identity {
    public ContratoId(String id){
        super(id);
    }
    public static ContratoId of(String id) {
        return new ContratoId(id);
    }
}
