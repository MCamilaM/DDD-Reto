package co.com.ventas.ventas.formula.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Objeto de valor edad
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Edad implements ValueObject<Integer> {

    private final Integer value;

    public Edad(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
    }

    @Override
    public Integer value() {
        return value;
    }
}
