package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * objeto de valor precio
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Precio implements ValueObject<Double> {

    private final Double value;

    public Precio(Double value) {
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    @Override
    public Double value() {
        return value;
    }
}
