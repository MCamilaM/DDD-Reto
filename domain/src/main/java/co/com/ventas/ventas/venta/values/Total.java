package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * objeto de valor total
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Total implements ValueObject<Double> {

    private final Double value;

    public Total(Double value) {
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("El precio total no puede ser negativo");
        }
    }

    @Override
    public Double value() {
        return value;
    }
}
