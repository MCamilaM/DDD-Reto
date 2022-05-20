package co.com.ventas.ventas.venta;

import co.com.sofka.domain.generic.Entity;
import co.com.ventas.ventas.venta.values.ClienteId;
import co.com.ventas.ventas.venta.values.CorreoElectronico;
import generics.Nombre;
import generics.Telefono;

import java.util.Objects;

public class Cliente extends Entity<ClienteId> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected CorreoElectronico correoElectronico;

    public Cliente(ClienteId clienteId, Nombre nombre, Telefono telefono, CorreoElectronico correoElectronico) {
        super(clienteId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public void actualizarCorreoElectronico(CorreoElectronico correoElectronico){
        this.correoElectronico = Objects.requireNonNull(correoElectronico);
    }
}
