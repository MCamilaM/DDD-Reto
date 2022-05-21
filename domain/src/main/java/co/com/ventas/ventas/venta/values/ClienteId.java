package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.Identity;
import co.com.ventas.ventas.formula.values.FormulaId;
/**
 * id de cliente
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class ClienteId extends Identity {
    public ClienteId(String id){
        super(id);
    }
    public static ClienteId of(String id) {
        return new ClienteId(id);
    }
}
