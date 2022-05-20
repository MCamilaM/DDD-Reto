package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.Identity;
import co.com.ventas.ventas.formula.values.FormulaId;

public class FacturaId extends Identity {
    public FacturaId(String id){
        super(id);
    }
    public static FacturaId of(String id) {
        return new FacturaId(id);
    }
}
