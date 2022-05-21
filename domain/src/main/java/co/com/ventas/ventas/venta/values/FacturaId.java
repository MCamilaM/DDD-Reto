package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.Identity;
import co.com.ventas.ventas.formula.values.FormulaId;
/**
 * id de factura
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class FacturaId extends Identity {
    public FacturaId(String id){
        super(id);
    }
    public static FacturaId of(String id) {
        return new FacturaId(id);
    }
}
