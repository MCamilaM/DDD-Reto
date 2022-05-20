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
        if(this.value.length() != 10){
            throw new IllegalArgumentException("Número de telefono incorrecto. Debe contener 10 números");
        }
        try{
            Integer telefono = Integer.parseInt(this.value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Número de telefono incorrecto. Solo debe contener números");

        }
    }

    @Override
    public String value() {
        return value;
    }
}
