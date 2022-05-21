package co.com.ventas.ventas.formula.values;

import co.com.sofka.domain.generic.Identity;
/**
 * id de formula
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class FormulaId extends Identity {
    public FormulaId(String id){
        super(id);
    }
    public static FormulaId of(String id) {
        return new FormulaId(id);
    }
}
