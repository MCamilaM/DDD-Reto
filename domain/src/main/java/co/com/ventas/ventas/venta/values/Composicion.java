package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Composicion implements ValueObject<String> {

    private final String value;

    public Composicion(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La composicion no puede estar en blanco.");
        }
    }

    @Override
    public String value() {
        return value;
    }

}
