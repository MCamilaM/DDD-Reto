package co.com.ventas.ventas.formula.values;

import co.com.sofka.domain.generic.Identity;

public class FormulaId extends Identity {
    public FormulaId(String id){
        super(id);
    }
    public static FormulaId of(String id) {
        return new FormulaId(id);
    }
}
