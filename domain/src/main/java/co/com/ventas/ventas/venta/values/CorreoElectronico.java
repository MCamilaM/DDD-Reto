package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CorreoElectronico implements ValueObject<String> {

    private final String value;

    public CorreoElectronico(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El correo no puede estar en blanco.");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
