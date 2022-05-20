package co.com.ventas.ventas.formula.values;

import co.com.sofka.domain.generic.ValueObject;
import java.util.Objects;

public class Diagnostico implements ValueObject<String> {

    private final String value;

    public Diagnostico(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El diagnostico no puede estar en blanco.");
        }
    }
    @Override
    public String value() {
        return value;
    }
}
