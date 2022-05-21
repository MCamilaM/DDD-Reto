package co.com.ventas.ventas.venta;

import co.com.sofka.domain.generic.Entity;
import co.com.ventas.ventas.venta.values.ClienteId;
import co.com.ventas.ventas.venta.values.CorreoElectronico;
import generics.Nombre;
import generics.Telefono;

import java.util.Objects;

/**
 * Entidad Cliente
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Cliente extends Entity<ClienteId> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected CorreoElectronico correoElectronico;

    /**
     * Constructor
     * @param clienteId
     * @param nombre
     * @param telefono
     * @param correoElectronico
     */
    public Cliente(ClienteId clienteId, Nombre nombre, Telefono telefono, CorreoElectronico correoElectronico) {
        super(clienteId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Metodo para actualizar correo electronico de un cliente
     * @param correoElectronico
     */
    public void actualizarCorreoElectronico(CorreoElectronico correoElectronico){
        this.correoElectronico = Objects.requireNonNull(correoElectronico);
    }
}
