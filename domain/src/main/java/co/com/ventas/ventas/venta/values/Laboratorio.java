package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

/**
 * objeto de valor laboratorio
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Laboratorio implements ValueObject<String> {

    private final String value;

    public Laboratorio(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El laboratorio no puede estar en blanco.");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
