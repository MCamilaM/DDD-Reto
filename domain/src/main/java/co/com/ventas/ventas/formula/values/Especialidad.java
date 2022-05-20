package co.com.ventas.ventas.formula.values;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especialidad implements ValueObject<String> {

    private final String value;

    public Especialidad(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La especialidad no puede estar en blanco.");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
