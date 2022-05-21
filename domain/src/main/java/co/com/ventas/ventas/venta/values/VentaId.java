package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.Identity;

/**
 * id de venta
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class VentaId extends Identity {
    public VentaId(String id){
        super(id);
    }
    public static VentaId of(String id) {
        return new VentaId(id);
    }
}
