package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.Identity;
import co.com.ventas.ventas.formula.values.FormulaId;

public class MedicamentoId extends Identity {
    public MedicamentoId(String id){
        super(id);
    }
    public static MedicamentoId of(String id) {
        return new MedicamentoId(id);
    }
}
