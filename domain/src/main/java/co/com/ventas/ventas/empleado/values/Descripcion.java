package co.com.ventas.ventas.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * Objeto de valor Descripcion
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Descripcion implements ValueObject<String> {

    private final String value;

    public Descripcion(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La descripcion no puede estar en blanco.");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
