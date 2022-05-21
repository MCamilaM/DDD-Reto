package co.com.ventas.ventas.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
/**
 * objeto de valor cantidad
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Cantidad implements ValueObject<Integer> {

    private final Integer value;

    public Cantidad(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(this.value < 0){
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
    }

    @Override
    public Integer value() {
        return value;
    }
}
