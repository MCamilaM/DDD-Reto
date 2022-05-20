package co.com.ventas.ventas.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<String> {

    private final String value;

    public Telefono(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El telefono  no puede estar vacio");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
