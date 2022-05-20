package co.com.ventas.ventas.empleado.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Fecha implements ValueObject<Fecha.Pros> {

    protected final LocalDateTime hora;
    protected final LocalDate dia;

    public Fecha(LocalDateTime hora, LocalDate dia) {
        this.hora = Objects.requireNonNull(hora);
        this.dia = Objects.requireNonNull(dia);
    }

    @Override
    public Pros value() {
        return new Pros() {
            @Override
            public LocalDateTime hora() {
                return hora;
            }

            @Override
            public LocalDate dia() {
                return dia;
            }
        };
    }


    public interface Pros {
        LocalDateTime hora();
        LocalDate dia();
    }
}
