package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.Identity;
import co.com.ventas.ventas.formula.values.FormulaId;
/**
 * id de medicamento
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class MedicamentoId extends Identity {
    public MedicamentoId(String id){
        super(id);
    }
    public static MedicamentoId of(String id) {
        return new MedicamentoId(id);
    }
}
